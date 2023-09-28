package com.beehyv.paymentgateway.merchant.utils;

import com.beehyv.paymentgateway.merchant.exception.CustomException;
import com.beehyv.paymentgateway.merchant.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
public class HttpCall {

    @Autowired
    private WebClient webClient;

    public Object callPostAPI(Object object, String url) {
        return webClient
                .post()
                .uri(url)
                .body(Mono.just(object), new ParameterizedTypeReference<Object>() {
                })
                .retrieve()
                .onStatus(status -> status.isError(), response -> {
                    Mono<ErrorResponse> clientResponse = response.bodyToMono(ErrorResponse.class);
                    return clientResponse.flatMap(responseObject -> {
                            throw new CustomException(responseObject.getStatus(), responseObject.getMessage(),
                                responseObject.getCause());

                    });
                })

                .bodyToMono(String.class)
                .block();
    }

    public Object callGetAPI(String url) {

        String str = webClient
                .get()
                .uri(url)
                .retrieve()
                .onStatus(status -> status.isError(), response -> {
                    Mono<ErrorResponse> clientResponse = response.bodyToMono(ErrorResponse.class);
                    return clientResponse.flatMap(responseObject -> {
                        throw new CustomException(responseObject.getStatus(), responseObject.getMessage(),
                                responseObject.getCause());

                    });
                })

                .bodyToMono(String.class)
                .block();

        return str;

    }



}
