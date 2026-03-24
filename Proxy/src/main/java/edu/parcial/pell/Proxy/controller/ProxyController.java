package edu.parcial.pell.Proxy.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController{

    private static final String USER_AGENT = "Mozilla/5.0";

    @Value("${SERVICE_URL1:http://54.174.229.2:8080}")
    private String service1;
    @Value("${SERVICE_URL2:http://13.221.151.115:8080}")
    private String service2;

    @GetMapping("/pellseq")
    public String proxy(int n) throws Exception{
        try{
            String url = service1 + "/pellseq?n=" + n;
            return callService(url);
        }catch(Exception e){
            String url = service2 + "/pellseq?n=" + n;
            return callService(url);
        }
    }
    public String callService(String url) throws IOException{

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
            return null;
        }
        
    }

}