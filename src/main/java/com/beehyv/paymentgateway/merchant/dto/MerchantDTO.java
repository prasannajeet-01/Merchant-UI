package com.beehyv.paymentgateway.merchant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDTO {
    private Long merchantId;
    private String name;
    private String email;
    private String businessType;
    private String address;
    private String phone;
}
