package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8080");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        /* String jsonString = "{\n" +
                "    \"jsonrpc\" : \"2.0\",\n" +
                "    \"method\" : \"add\",\n" +
                "    \"params\": [3,5],\n" +
                "    \"id\": \"100\"\n" +
                "}"; */
        String jsonString = "{\n" +
                "    \"jsonrpc\" : \"2.0\",\n" +
                "    \"method\" : \"foo\",\n" +
                "    \"id\": \"10000\"\n" +
                "}";
        System.out.println(jsonString);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }


    }
}