package apisigner

import com.apiSigner.MainSendRequest
import javax.crypto.spec.SecretKeySpec
import javax.crypto.Mac
import org.apache.commons.codec.binary.Base64

class ApiSignerService {
    MainSendRequest mainSendRequest

    def makeRequest(key, secret, url, method) {
        if (method.equals("GET")) {
            def response = mainSendRequest.doGetRequest(url, key, secret)
            return response
        }
    }

    def calculateRFC2104HMAC(String data, String key)
    throws Exception {
        String result;
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HMAC-SHA1");

        Mac mac = Mac.getInstance("HMAC-SHA1");
        mac.init(signingKey);

        byte[] rawHmac = mac.doFinal(data.getBytes());

        result = new String(new Base64().encode(rawHmac));

        return result;
    }

}