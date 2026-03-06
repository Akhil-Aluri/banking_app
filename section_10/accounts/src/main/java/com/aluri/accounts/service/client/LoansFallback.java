package com.aluri.accounts.service.client;

import com.aluri.accounts.dto.LoansDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LoansFallback implements LoansFeignClient{

    @Override
    public ResponseEntity<LoansDto> getLoanDetails(String mobileNumber, String correlationId) {
        return null;
    }
}
