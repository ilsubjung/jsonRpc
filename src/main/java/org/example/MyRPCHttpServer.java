package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.example.servlet.JsonRpcHttpServlet;

public class MyRPCHttpServer {
    public static void main(String[] args) throws Exception {
        // Create an instance of your service implementation
        MyServiceImpl myService = new MyServiceImpl();

        // Create the servlet
        JsonRpcHttpServlet jsonRpcServlet = new JsonRpcHttpServlet(myService, MyService.class);

        // Create the Jetty server on port 8080
        Server server = new Server(8080);

        // Create a ServletContextHandler for the context path "/"
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");

        // Add the JsonRpcHttpServlet to the context
        contextHandler.addServlet(new ServletHolder(jsonRpcServlet), "/jsonrpc");

        // Set the context handler for the server
        server.setHandler(contextHandler);

        // Start the server
        server.start();
        System.out.println("JSON-RPC server started on http://localhost:8080/jsonrpc");

        // Wait for the server to stop
        server.join();
    }
}

