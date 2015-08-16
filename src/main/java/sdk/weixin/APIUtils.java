package sdk.weixin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sdk.weixin.req.BaseRequest;
import sdk.weixin.req.RequestMethod;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;
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

    private APIUtils(int maxCon) {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(maxCon);
        cm.setDefaultMaxPerRoute(cm.getMaxTotal());
        httpClient = HttpClients.custom().setConnectionManager(cm).build();

        objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    }

    /**
     * 获取单例
     *
     * @param maxCon 最大并发,最大host并发
     * @return 实例
     */
    public static APIUtils getInstance(int maxCon) {
        ReentrantReadWriteLock.ReadLock readLock = INS_LOCK.readLock();
        readLock.lock();
        if (null != INS) {
            readLock.unlock();
            return INS;
        }

        readLock.unlock();

        ReentrantReadWriteLock.WriteLock writeLock = INS_LOCK.writeLock();
        writeLock.lock();
        if (null != INS) {
            writeLock.unlock();
            return INS;
        }

        INS = new APIUtils(maxCon);
        writeLock.unlock();
        return INS;
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
                Map<String, Object> params = request.getParams();
                if (null != params) {
                    StringWriter outputParams = new StringWriter();
                    try {
                        objectMapper.writeValue(outputParams, params);
                    } catch (IOException e) {
                        LOGGER.error("serialize param", e);
                    }

                    String content = outputParams.toString();
                    if (StringUtils.isNoneBlank(content)) {
                        req.setEntity(new StringEntity(content, StandardCharsets.UTF_8));
                    }

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
