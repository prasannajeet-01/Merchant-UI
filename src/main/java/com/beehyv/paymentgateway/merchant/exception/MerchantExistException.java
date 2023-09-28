package com.beehyv.paymentgateway.merchant.exception;

public class MerchantExistException extends Exception{
    public MerchantExistException(String error){
        super(error);
    }
}
