package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws Exception{
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws Exception{
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws Exception{
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) throws Exception{
        SocketClient client = new SocketClient();
        client.startConnection("localhost", 8080);
        String jsonString = "{\n" +
                "    \"jsonrpc\" : \"2.0\",\n" +
                "    \"method\" : \"subtract\",\n" +
                "    \"params\": [2,5],\n" +
                "    \"id\": \"ABC\"\n" +
                "}";
        System.out.println(jsonString);
        String response = client.sendMessage(jsonString);
        System.out.println(response);
        client.stopConnection();
    }
}