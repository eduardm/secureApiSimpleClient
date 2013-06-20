package com.apiSigner;

import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


public class HmacSha1MessageSigner {

    private static final String MAC_NAME = "HmacSHA1";


    public String getSignatureMethod() {
        return "HMAC-SHA1";
    }


    public static String sign(String url, String method, String key, String secret, String timestamp)
            throws Exception {
        String stringToBeSigned = createStringForSignature(url, method, key, timestamp);
        String signature = calculateRFC2104HMAC(stringToBeSigned, secret);

        return signature;
    }

    private static String createStringForSignature(String url, String method, String key, String timestamp) throws Exception {
        String stringForSignature;
        if (url.contains("?")) {
            stringForSignature = method + url + "&key=" + key + "&timestamp=" + timestamp;
        } else {
            stringForSignature = method + url + "?key=" + key + "&timestamp=" + timestamp;
        }
        return URLEncoder.encode(stringForSignature, "UTF8");
    }

    private static String calculateRFC2104HMAC(String data, String key)
            throws Exception {
        String result;
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), MAC_NAME);

        Mac mac = Mac.getInstance(MAC_NAME);
        mac.init(signingKey);

        byte[] rawHmac = mac.doFinal(data.getBytes());

        result =new String(new Base64().encode(rawHmac));

        return result;
    }
}