package md.vlad.mobile.app.dao;

import md.vlad.mobile.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select * from get_accounts()", nativeQuery = true)
    public List<Account> readAccountsFromFunction();

    public Optional<Account> findAccountById(Long id);

    public List<Account> findAccountsByAccountNumber(String accountNumber);
}
