package com.beehyv.paymentgateway.merchant.serviceimpl;


import com.beehyv.paymentgateway.merchant.dto.MerchantDTO;
import com.beehyv.paymentgateway.merchant.service.MerchantService;
import com.beehyv.paymentgateway.merchant.utils.HttpCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    private HttpCall httpCall;

    MerchantDTO stringToMerchantObject(String response) {

        Gson gson = new Gson();
        Type type = new TypeToken<MerchantDTO>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    @Override
    public ResponseEntity<MerchantDTO> registerAMerchant(MerchantDTO merchant) {
        String response = (String) httpCall.callPostAPI(merchant, "http://localhost:9091/simulator/create");



        return new ResponseEntity<>(stringToMerchantObject(response), HttpStatus.OK);
    }
}
