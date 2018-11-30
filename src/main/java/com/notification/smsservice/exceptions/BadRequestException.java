package com.notification.smsservice.exceptions;


/**
 * User: edward <br/>
 * Date: 11/25/18 7:50 AM <br/>
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
