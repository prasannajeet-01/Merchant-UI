package com.beehyv.paymentgateway.merchant.service;

import com.beehyv.paymentgateway.merchant.dto.PaymentDTO;
import com.beehyv.paymentgateway.merchant.enums.PaymentStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PaymentService {
    ResponseEntity<PaymentDTO> doPayment(PaymentDTO payment);
    ResponseEntity<String>getStatusOfPayment(UUID id);
}
