package com.assignment.whiskeyapi.exceptions;

import java.io.Serializable;

public class WhiskeyServiceException extends Throwable implements Serializable {

    private Integer httpCode;
    private String method;
    private String error;
    private String description;

    public WhiskeyServiceException(Integer httpCode, String method, String error, String description) {
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

    public static class WhiskeyServiceExceptionBuilder {

        private Integer httpCode;
        private String method;
        private String error;
        private String description;

        public WhiskeyServiceExceptionBuilder() {

        }

        public WhiskeyServiceExceptionBuilder httpCode(Integer httpCode) {
            this.httpCode = httpCode;
            return this;
        }

        public WhiskeyServiceExceptionBuilder method(String method) {
            this.method = method;
            return this;
        }

        public WhiskeyServiceExceptionBuilder description(String description) {
            this.description = description;
            return this;
        }

        public WhiskeyServiceExceptionBuilder error(String error) {
            this.error = error;
            return this;
        }

        public WhiskeyServiceException build() {
            return new WhiskeyServiceException(this.httpCode, this.method, this.description, this.error);
        }

    }

    @Override
    public String toString() {
        return "WhiskeyServiceException{" +
                "httpCode=" + httpCode +
                ", method='" + method + '\'' +
                ", error='" + error + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
