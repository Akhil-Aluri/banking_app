package com.aluri.accounts.service;

import com.aluri.accounts.dto.CustomerDto;

public interface AccountsService {

    void createAccount(CustomerDto customerDto);

    CustomerDto getAccountDetails(String mobileNumber);

    boolean updateAccountDetails(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
