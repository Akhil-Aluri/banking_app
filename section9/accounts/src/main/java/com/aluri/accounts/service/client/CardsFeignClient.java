package com.aluri.accounts.service.client;


import com.aluri.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cards")
public interface CardsFeignClient {

    @GetMapping(value = "/cards/getCardDetails", consumes = "application/json")
    public ResponseEntity<CardsDto> getCardDetails(@RequestParam String mobileNumber,
                                                   @RequestHeader("aluri-correlation-id") String correlationId);

}
