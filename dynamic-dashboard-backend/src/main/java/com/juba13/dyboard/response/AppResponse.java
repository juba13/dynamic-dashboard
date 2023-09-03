package com.juba13.dyboard.response;

import org.springframework.http.HttpStatus;

/**
 * Custom response class for handling API responses.
 *
 * @param <T> The type of data in the response body.
 */
public class AppResponse<T> {

    private HttpStatus status;
    private String message;
    private String error;
    private String path;
    private T body;
    private T header;

    /**
     * Constructor for creating an AppResponse with a specified HTTP status.
     *
     * @param status The HTTP status code.
     */
    private AppResponse(HttpStatus status) {
        this.status = status;
    }

    /**
     * Default constructor for AppResponse.
     */
    private AppResponse() {
    }

    /**
     * Create a new AppResponse with the specified HTTP status.
     *
     * @param status The HTTP status code.
     * @return The created AppResponse.
     */
    public static <T> AppResponse<T> build(HttpStatus status) {
        return new AppResponse<>(status);
    }

    /**
     * Get the HTTP status code.
     *
     * @return The HTTP status code.
     */
    public Integer getStatus() {
        return status.value();
    }

    /**
     * Get the response message.
     *
     * @return The response message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the response message.
     *
     * @param message The response message.
     * @return This AppResponse instance.
     */
    public AppResponse<T> message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the response body.
     *
     * @return The response body.
     */
    public T getBody() {
        return body;
    }

    /**
     * Set the response body.
     *
     * @param data The response body data.
     * @return This AppResponse instance.
     */
    public AppResponse<T> body(T data) {
        this.body = data;
        return this;
    }

    /**
     * Set the response header.
     *
     * @param data The response header data.
     * @return This AppResponse instance.
     */
    public AppResponse<T> header(T data) {
        this.header = data;
        return this;
    }

    /**
     * Get the response header.
     *
     * @return The response header.
     */
    public T getHeader() {
        return header;
    }

    /**
     * Get the error message.
     *
     * @return The error message.
     */
    public String getError() {
        return error;
    }

    /**
     * Set the error message.
     *
     * @param error The error message.
     * @return This AppResponse instance.
     */
    public AppResponse<T> error(String error) {
        this.error = error;
        return this;
    }
}
