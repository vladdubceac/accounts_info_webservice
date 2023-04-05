package md.vlad.mobile.app.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name="balance")
    private BigDecimal balance;

    @Column(name="currency")
    private String currency;

    @Column(name="operation_date")
    private Timestamp operationDate;
}
