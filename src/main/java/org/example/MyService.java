package org.example;
import com.googlecode.jsonrpc4j.JsonRpcMethod;

public interface MyService {
    @JsonRpcMethod("add")
    int add(int a, int b);

    @JsonRpcMethod("subtract")
    int subtract(int a, int b);

    @JsonRpcMethod("foo")
    int foo();
}
