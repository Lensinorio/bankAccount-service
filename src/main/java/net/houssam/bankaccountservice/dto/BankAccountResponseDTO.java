package net.houssam.bankaccountservice.dto;

import lombok.*;
import net.houssam.bankaccountservice.enums.AccountType;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
