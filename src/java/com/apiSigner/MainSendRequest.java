package com.apiSigner;


import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class MainSendRequest {


    public static Map<String, String> doGetRequest(String url, String key, String secret) throws Exception {

        Map<String, String> requestResult = new HashMap<String, String>();

        //Instantiate an HttpClient
        HttpClient client = new HttpClient();

        //Instantiate a GET HTTP method
        GetMethod method = new GetMethod(url);

        //add key
        NameValuePair nvp1 = new NameValuePair("key", key);
        //add the timestamp
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        String timestamp = String.valueOf(calendar.getTimeInMillis());
        NameValuePair nvp2 = new NameValuePair("timestamp", timestamp);

        //calculate signature
        String signature = HmacSha1MessageSigner.sign(url, "GET", key, secret, timestamp);
        NameValuePair nvp3 = new NameValuePair("signature", signature);

        method.setQueryString(new NameValuePair[]{nvp1,nvp2,nvp3});

        int statusCode = client.executeMethod(method);

        requestResult.put("statusCode", Integer.toString(statusCode));
        requestResult.put("statusText", HttpStatus.getStatusText(statusCode));
        requestResult.put("responseBody", method.getResponseBodyAsString());
        requestResult.put("queryString", method.getQueryString());

        //release connection
        method.releaseConnection();


        return requestResult;
    }

//    public static void doPostRequest(String[] args) {
//
//        //Instantiate an HttpClient
//        HttpClient client = new HttpClient();
//
//        //Instantiate a GET HTTP method
//        PostMethod method = new PostMethod(url);
//        method.setRequestHeader("Content-type",
//                "text/xml; charset=ISO-8859-1");
//
//        //Define name-value pairs to set into the QueryString
//        NameValuePair nvp1= new NameValuePair("firstName","fname");
//        NameValuePair nvp2= new NameValuePair("lastName","lname");
//        NameValuePair nvp3= new NameValuePair("email","email@email.com");
//
//        method.setQueryString(new NameValuePair[]{nvp1,nvp2,nvp3});
//
//        try{
//            int statusCode = client.executeMethod(method);
//
//            System.out.println("Status Code = "+statusCode);
//            System.out.println("QueryString>>> "+method.getQueryString());
//            System.out.println("Status Text>>>"
//                  +HttpStatus.getStatusText(statusCode));
//
//            //Get data as a String
//            System.out.println(method.getResponseBodyAsString());
//
//            //OR as a byte array
//            byte [] res  = method.getResponseBody();
//
//            //write to file
//            FileOutputStream fos= new FileOutputStream("donepage.html");
//            fos.write(res);
//
//            //release connection
//            method.releaseConnection();
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//    }
}