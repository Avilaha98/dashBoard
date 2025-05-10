import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;

public class HttpTraceTestWithSSLBypass {
    public static void main(String[] args) throws Exception {
        // Set up the bypass for SSL certificate validation
        disableSslVerification();

        String urlString = "https://example.com"; 
        URL url = new URL(urlString);

     
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

  
        connection.setRequestMethod("GET");

       

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

    
        System.out.println("\nResponse Headers:");
        for (String header : connection.getHeaderFields().keySet()) {
            System.out.println(header + ": " + connection.getHeaderField(header));
        }

            }

    // Method to disable SSL certificate validation
    private static void disableSslVerification() throws Exception {
        // Create a trust manager that accepts all certificates
        TrustManager[] trustAllCertificates = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCertificates, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Install the all-trusting host name verifier
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
    }
}
