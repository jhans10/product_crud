package com.example.product.exception;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class ApiExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(Map.of("error", e.getMessage()))
                .build();
    }
}
