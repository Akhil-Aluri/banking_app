package com.aluri.accounts.mapper;

import com.aluri.accounts.dto.AccountsDto;
import com.aluri.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto){
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        accountsDto.setAccountType(accounts.getAccountType());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts){
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        accounts.setAccountType(accountsDto.getAccountType());
        return accounts;
    }
}
