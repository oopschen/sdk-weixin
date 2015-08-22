package sdk.weixin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.CustomizeTrustManager;
import sdk.weixin.req.RequestMethod;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * api 请求工具类
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class APIUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(APIUtils.class);
    private static final ReentrantReadWriteLock INS_LOCK = new ReentrantReadWriteLock();
    private static APIUtils INS;

    private ObjectMapper objectMapper;
    private CloseableHttpClient httpClient;

    private APIUtils(int maxCon, int timeoutSec) {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[] {new CustomizeTrustManager()}, null);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            LOGGER.error("init ssl", e);
        }

        if (null != sslContext) {
            SocketConfig socketConfig =
                SocketConfig.custom().setSoKeepAlive(false).setSoTimeout(timeoutSec * 1000).build();
            SSLConnectionSocketFactory sslConnectionSocketFactory =
                new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
            httpClient = HttpClients.custom().setDefaultSocketConfig(socketConfig)
                .setSSLSocketFactory(sslConnectionSocketFactory).setMaxConnTotal(maxCon)
                .setMaxConnPerRoute(maxCon).build();
        }

        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
    }

    /**
     * 获取单例
     *
     * @param maxCon 最大并发,最大host并发
     * @return 实例
     */
    public static APIUtils getInstance(int maxCon, int timeoutSec) {
        ReentrantReadWriteLock.ReadLock readLock = INS_LOCK.readLock();
        readLock.lock();
        try {
            if (null != INS) {
                return INS;
            }

        } finally {
            readLock.unlock();
        }

        ReentrantReadWriteLock.WriteLock writeLock = INS_LOCK.writeLock();
        writeLock.lock();
        try {
            if (null != INS) {
                return INS;
            }

            INS = new APIUtils(maxCon, timeoutSec);
            return INS;
        } finally {
            writeLock.unlock();

        }
    }


    public <T extends Object> T request(BaseRequest request, Class<T> clz) {
        if (null == request || null == clz) {
            return null;
        }

        // do request
        String uri = request.getRequestURI();
        if (StringUtils.isBlank(uri)) {
            return null;
        }

        RequestMethod requestMethod = request.getMethod();
        HttpUriRequest httpUriRequest = null;

        switch (requestMethod) {
            case GET:
                httpUriRequest = new HttpGet(uri);
                break;
            case POST:
                HttpPost req = new HttpPost(uri);
                StringWriter outputParams = new StringWriter();
                try {
                    objectMapper.writeValue(outputParams, request);
                } catch (IOException e) {
                    LOGGER.error("serialize param", e);
                }

                String content = outputParams.toString();
                if (StringUtils.isNoneBlank(content)) {
                    req.setEntity(new StringEntity(content, StandardCharsets.UTF_8));
                }


                httpUriRequest = req;
                break;
            default:
                return null;
        }

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpUriRequest);
            return objectMapper.readValue(response.getEntity().getContent(), clz);
        } catch (IOException e) {
            LOGGER.error("execute req", e);
        } finally {
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    LOGGER.error("close res", e);
                }
            }
        }
        return null;
    }
}
