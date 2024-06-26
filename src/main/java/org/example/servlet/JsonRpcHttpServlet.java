package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.JsonRpcServer;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonRpcHttpServlet extends HttpServlet {
    private JsonRpcServer jsonRpcServer;

    public JsonRpcHttpServlet(Object serviceImplementation, Class<?> serviceInterface) {
        ObjectMapper objectMapper = new ObjectMapper();
        jsonRpcServer = new JsonRpcServer(objectMapper, serviceImplementation, serviceInterface);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jsonRpcServer.handle(req, resp);
    }
}

