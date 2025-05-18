package net.houssam.bankaccountservice.mappers;

import net.houssam.bankaccountservice.dto.BankAccountRequestDTO;
import net.houssam.bankaccountservice.dto.BankAccountResponseDTO;
import net.houssam.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount( BankAccount bankAccount) {
       BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
       BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
       return bankAccountResponseDTO;
    }
    // في AccountMapper.java
    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO dto) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(dto, bankAccount);
        return bankAccount;
    }

}
