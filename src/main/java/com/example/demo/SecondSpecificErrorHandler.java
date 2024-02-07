package com.example.demo;

import graphql.GraphQLError;
import org.springframework.core.annotation.Order;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class SecondSpecificErrorHandler {
    @GraphQlExceptionHandler
    public GraphQLError handle(UnsupportedOperationException e) {
        return GraphQLError.newError().message("handle: " + e.getMessage()).build();
    }
}
