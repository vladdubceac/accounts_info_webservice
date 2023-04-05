package md.vlad.mobile.app.controller;

import md.vlad.mobile.app.entity.Account;
import md.vlad.mobile.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts(){
        return accountService.getAccountsFromFunction();
    }
}
