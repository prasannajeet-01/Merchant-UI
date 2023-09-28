package com.beehyv.paymentgateway.merchant.service;

import com.beehyv.paymentgateway.merchant.dto.MerchantDTO;
import org.springframework.http.ResponseEntity;

public interface MerchantService {
    ResponseEntity<MerchantDTO> registerAMerchant(MerchantDTO merchant);
}
