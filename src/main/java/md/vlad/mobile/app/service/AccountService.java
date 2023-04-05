package md.vlad.mobile.app.service;

import md.vlad.mobile.app.dao.AccountRepository;
import md.vlad.mobile.app.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountsFromFunction(){
        return accountRepository.readAccountsFromFunction();
    }
}
