package org.example;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;

import java.net.URL;

public class Client2 {
    public static void main(String[] args) throws Exception, Throwable{
        JsonRpcHttpClient client = new JsonRpcHttpClient(
                new URL("http://localhost:8080/jsonrpc"));

        Integer i = client.invoke("add", new Object[] { 4, 3 }, Integer.class);
        System.out.println(i);
    }
}
