package net.bank.service;

import net.bank.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private List<Account> accounts = new ArrayList<>();

    public Account createAccount(Account account) {
        accounts.add(account);
        return account;
    }

    public Account getAccount(String accountId) {
        return accounts.stream()
                .filter(account -> account.getAccountId().equals(accountId))
                .findFirst()
                .orElse(null);
    }
}
