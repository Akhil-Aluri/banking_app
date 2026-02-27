package com.aluri.accounts.service.impl;

import com.aluri.accounts.dto.AccountsDto;
import com.aluri.accounts.dto.CardsDto;
import com.aluri.accounts.dto.CustomerDetailsDto;
import com.aluri.accounts.dto.LoansDto;
import com.aluri.accounts.entity.Accounts;
import com.aluri.accounts.entity.Customer;
import com.aluri.accounts.exception.CustomerNotFoundException;
import com.aluri.accounts.mapper.AccountsMapper;
import com.aluri.accounts.mapper.CustomerMapper;
import com.aluri.accounts.repository.AccountsRepository;
import com.aluri.accounts.repository.CustomerRepository;
import com.aluri.accounts.service.CustomerService;
import com.aluri.accounts.service.client.CardsFeignClient;
import com.aluri.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new CustomerNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new CustomerNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.getLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.getCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        return customerDetailsDto;
    }
}
