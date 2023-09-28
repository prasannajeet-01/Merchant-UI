package com.beehyv.paymentgateway.merchant.controller;

import com.beehyv.paymentgateway.merchant.dto.PaymentDTO;
import com.beehyv.paymentgateway.merchant.enums.PaymentStatus;
import com.beehyv.paymentgateway.merchant.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
@CrossOrigin({"*"})
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/merchant")
    ResponseEntity<PaymentDTO> paymentRequest(@RequestBody PaymentDTO payment){
        return paymentService.doPayment(payment);

    }

    @GetMapping("payment_request/{transactionId}")
    ResponseEntity<String>getPaymentStatusByTransactionId(@PathVariable(name = "transactionId") UUID id){
        return paymentService.getStatusOfPayment(id);
    }

}
