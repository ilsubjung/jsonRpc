package org.example;

import com.googlecode.jsonrpc4j.JsonRpcServer;
import com.googlecode.jsonrpc4j.StreamServer;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class MyJsonRpcServer {
    public static void main(String[] args) throws Exception {
        MyService myService = new MyServiceImpl();
        JsonRpcServer jsonRpcServer = new JsonRpcServer(myService, MyService.class);

        // Create a server socket on port 8080
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), 8080));
        // Create a StreamServer to listen for incoming connections
        StreamServer streamServer = new StreamServer(jsonRpcServer, 5, serverSocket);

        // Start the server
        streamServer.start();

        System.out.println("JSON-RPC server started on port 8080");
    }
}


