package md.vlad.mobile.app.dao;

import md.vlad.mobile.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "select * from test_schema.get_accounts()", nativeQuery = true)
    public List<Account> readAccountsFromFunction();

    public Optional<Account> findAccountById(Long id);

    @Query(value = "select a from Account a where a.accountNumber = :accountNumber")
    public Optional<Account> findAccountByAccountNumber(@Param("accountNumber") String accountNumber);

    @Query(value = "select a.* from accounts a where date(a.operation_date) = date(:opDate)", nativeQuery = true)
    public List<Account> findAccountsByOperationDate(@Param("opDate") Timestamp opDate);
}
