package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApacheClient {
    public static void main(String[] args) throws Exception{
        String jsonString = "{\n" +
                "    \"jsonrpc\" : \"2.0\",\n" +
                "    \"method\" : \"add\",\n" +
                "    \"params\": [3,5],\n" +
                "    \"id\": \"100\"\n" +
                "}";
        System.out.println(jsonString);

        HttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpPost request = new HttpPost("http://localhost:8080/jsonrpc");
            StringEntity params = new StringEntity(jsonString);
            request.addHeader("content-type", "application/json");
            request.addHeader("Accept", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            HttpEntity respEntity = response.getEntity();

            System.out.println(respEntity);
            String a = "A";
// handle response here...
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
