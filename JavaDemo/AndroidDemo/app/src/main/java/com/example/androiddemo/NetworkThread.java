package com.example.androiddemo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

public class NetworkThread implements Callable<String> {
    private final String name;
    private final String password;
    private final String url;

    public NetworkThread(String name, String password, String url) {
        this.name = name;
        this.password = password;
        this.url = url;
    }

    @Override
    public String call(){
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            String data = "name="+ URLEncoder.encode(name, StandardCharsets.UTF_8.toString())+"&password="+URLEncoder.encode(password,StandardCharsets.UTF_8.toString());
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
            byte [] bytes = new byte[1024];
            int len = connection.getInputStream().read(bytes);
            return new String(bytes,0,len,StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}