package com.softete.followpolitical.rest.api.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpService {

    public InputStream getRequest(String urlParam) throws IOException {
        URL url = new URL(urlParam);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");

        return connection.getInputStream();
    }
}
