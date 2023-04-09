package md.vlad.mobile.app.service;

import md.vlad.mobile.app.dao.AccountRepository;
import md.vlad.mobile.app.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalField;
import java.util.List;
import java.util.Optional;

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

    public List<Account> getAccountByOperationDate(LocalDate localDate){
        Timestamp opDate = Timestamp.valueOf(localDate.atTime(LocalTime.MIDNIGHT));
        return accountRepository.findAccountsByOperationDate(opDate);
    }

    public Optional<Account> getAccountById(Long id){
        return accountRepository.findAccountById(id);
    }

    public Optional<Account> getAccountByNumber(String accountNumber){
        return accountRepository.findAccountByAccountNumber(accountNumber);
    }
}
