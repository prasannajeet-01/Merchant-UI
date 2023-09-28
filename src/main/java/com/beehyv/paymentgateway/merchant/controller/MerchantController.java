package com.beehyv.paymentgateway.merchant.controller;


import com.beehyv.paymentgateway.merchant.dto.MerchantDTO;
import com.beehyv.paymentgateway.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
@CrossOrigin({"*"})
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping("/register")
    ResponseEntity<MerchantDTO>registerMerchant(@RequestBody MerchantDTO merchant){
        return merchantService.registerAMerchant(merchant);

    }
}
