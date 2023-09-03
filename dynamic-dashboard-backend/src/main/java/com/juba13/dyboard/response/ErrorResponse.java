package com.juba13.dyboard.response;

import java.util.Date;

/**
 * Represents an error response with timestamp, message, and details.
 */
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String details;

    /**
     * Constructor to create an ErrorResponse instance.
     *
     * @param timestamp The timestamp of the error.
     * @param message   The error message.
     * @param details   Additional details about the error.
     */
    public ErrorResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * Get the timestamp of the error.
     *
     * @return The timestamp.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Set the timestamp of the error.
     *
     * @param timestamp The timestamp to set.
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Get the error message.
     *
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the error message.
     *
     * @param message The error message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get additional details about the error.
     *
     * @return The error details.
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set additional details about the error.
     *
     * @param details The error details to set.
     */
    public void setDetails(String details) {
        this.details = details;
    }
}
