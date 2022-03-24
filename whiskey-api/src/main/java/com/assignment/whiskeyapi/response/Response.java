package com.assignment.whiskeyapi.response;

import java.io.Serializable;

public class Response implements Serializable {

    private Integer httpCode;
    private String method;
    private String error;
    private String description;

    public Response(Integer httpCode, String description) {
        this.httpCode = httpCode;
        this.description = description;
    }

    public Response(Integer httpCode, String method, String error, String description) {
        this.httpCode = httpCode;
        this.method = method;
        this.error = error;
        this.description = description;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public String getMethod() {
        return method;
    }

    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Response{" +
                "httpCode=" + httpCode +
                ", method='" + method + '\'' +
                ", error='" + error + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
