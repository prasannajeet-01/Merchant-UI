package com.beehyv.paymentgateway.merchant.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {

    public Long status;
    public String message;
    public Object errors;

    public CustomException(String message) {
        super(message);
    }

}

