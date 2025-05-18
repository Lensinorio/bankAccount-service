package net.houssam.bankaccountservice.dto;

import lombok.*;
import net.houssam.bankaccountservice.enums.AccountType;


@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDTO {

    private Double balance;
    private String currency;
    private AccountType type;
}
