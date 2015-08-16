package sdk.weixin.req;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * trust all manager
 *
 * @author ray
 * @version %I%, %G%
 * @since 1.0
 */
public class CustomizeTrustManager implements X509TrustManager {
    @Override public void checkClientTrusted(X509Certificate[] x509Certificates, String s)
        throws CertificateException {

    }

    @Override public void checkServerTrusted(X509Certificate[] x509Certificates, String s)
        throws CertificateException {

    }

    @Override public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
