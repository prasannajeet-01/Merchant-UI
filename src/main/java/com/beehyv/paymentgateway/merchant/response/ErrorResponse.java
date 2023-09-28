package com.beehyv.paymentgateway.merchant.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private Long status;
    private String cause;
    private String message;
    private String path;
}
