package com.aluri.accounts.service.client;

import com.aluri.accounts.dto.LoansDto;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loans")
public interface LoansFeignClient {

    @GetMapping(value = "/loans/getLoans", consumes = "application/json")
    public ResponseEntity<LoansDto> getLoanDetails(@RequestParam String mobileNumber);
}
