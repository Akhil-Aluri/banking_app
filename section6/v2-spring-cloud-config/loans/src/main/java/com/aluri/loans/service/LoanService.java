package com.aluri.loans.service;

import com.aluri.loans.dto.LoansDto;
import jakarta.validation.constraints.Pattern;

public interface LoanService {

    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);


    boolean updateLoan(LoansDto loansDto);


    boolean closeLoan(String mobileNumber);
}
