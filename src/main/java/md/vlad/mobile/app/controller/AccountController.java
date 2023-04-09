package md.vlad.mobile.app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import md.vlad.mobile.app.entity.Account;
import md.vlad.mobile.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Get data for all accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found accounts data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))}),
            @ApiResponse(responseCode = "404", description = "No accounts found",
                    content = @Content)})
    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.getAccountsFromFunction();
    }

    @Operation(summary = "Get account by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found account",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No account found with provided id!",
                    content = @Content)})
    @GetMapping()
    public ResponseEntity getAccountById(@Parameter(description = "id of acount to be searched") @RequestParam("id") Long id) throws Exception {
        Account account = accountService.getAccountById(id).orElse(new Account());
        if (account.getId() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(account);

    }

    @GetMapping("/number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found account",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Account.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid account number supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No account found with provided number!",
                    content = @Content)})
    public ResponseEntity getAccountByNumber(@Parameter(description = "Number (text value) of the account to be searched") @RequestParam("number") String number) throws Exception {
        Account account = accountService.getAccountByNumber(number).orElse(new Account());
        if(account.getId()==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(account);
    }
}
