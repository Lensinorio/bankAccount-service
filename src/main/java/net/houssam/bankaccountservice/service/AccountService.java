package net.houssam.bankaccountservice.service;

import net.houssam.bankaccountservice.dto.BankAccountRequestDTO;
import net.houssam.bankaccountservice.dto.BankAccountResponseDTO;

import java.util.List;

public interface AccountService {
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
    List<BankAccountResponseDTO> getAllAccounts();
    BankAccountResponseDTO getAccount(String id);
    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO dto);
    void deleteAccount(String id);
}
