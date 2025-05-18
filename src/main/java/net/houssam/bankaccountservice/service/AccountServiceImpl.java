package net.houssam.bankaccountservice.service;

import net.houssam.bankaccountservice.dto.BankAccountRequestDTO;
import net.houssam.bankaccountservice.dto.BankAccountResponseDTO;
import net.houssam.bankaccountservice.entities.BankAccount;
import net.houssam.bankaccountservice.mappers.AccountMapper;
import net.houssam.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());

        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(savedBankAccount);
    }

    @Override
    public List<BankAccountResponseDTO> getAllAccounts() {
        return bankAccountRepository.findAll()
                .stream()
                .map(accountMapper::fromBankAccount)
                .collect(Collectors.toList());
    }

    @Override
    public BankAccountResponseDTO getAccount(String id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return accountMapper.fromBankAccount(bankAccount);
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO dto) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (dto.getBalance() != null) bankAccount.setBalance(dto.getBalance());
        if (dto.getCurrency() != null) bankAccount.setCurrency(dto.getCurrency());
        if (dto.getType() != null) bankAccount.setType(dto.getType());

        bankAccount.setCreatedAt(new Date()); // Mise à jour automatique de la date

        BankAccount updatedAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(updatedAccount);
    }

    @Override
    public void deleteAccount(String id) {
        bankAccountRepository.deleteById(id);
    }
}
