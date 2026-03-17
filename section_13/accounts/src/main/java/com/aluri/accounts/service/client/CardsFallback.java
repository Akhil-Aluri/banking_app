package com.aluri.accounts.service.client;

import com.aluri.accounts.dto.CardsDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CardsFallback implements CardsFeignClient{

    @Override
    public ResponseEntity<CardsDto> getCardDetails(String mobileNumber, String correlationId) {
        return null;
    }
}
