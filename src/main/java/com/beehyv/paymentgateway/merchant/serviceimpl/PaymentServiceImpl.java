package com.beehyv.paymentgateway.merchant.serviceimpl;



import com.beehyv.paymentgateway.merchant.dto.PaymentDTO;
import com.beehyv.paymentgateway.merchant.service.PaymentService;
import com.beehyv.paymentgateway.merchant.utils.HttpCall;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.UUID;


@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private HttpCall httpCall;

    PaymentDTO stringToPaymentObject(String response) {

        Gson gson = new Gson();
        Type type = new TypeToken<PaymentDTO>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    @Override
    public ResponseEntity<PaymentDTO> doPayment(PaymentDTO payment) {
        String response = (String) httpCall.callPostAPI(payment, "http://localhost:9091/simulator/payment");
        return new ResponseEntity<>(stringToPaymentObject(response), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<String> getStatusOfPayment(UUID id) {
        String response = (String) httpCall.callGetAPI("http://localhost:9091/simulator/payment_request/" + id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
