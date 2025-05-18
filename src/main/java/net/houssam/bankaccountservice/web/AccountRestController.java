package net.houssam.bankaccountservice.web;

import net.houssam.bankaccountservice.dto.BankAccountRequestDTO;
import net.houssam.bankaccountservice.dto.BankAccountResponseDTO;
import net.houssam.bankaccountservice.entities.BankAccount;
import net.houssam.bankaccountservice.mappers.AccountMapper;
import net.houssam.bankaccountservice.repositories.BankAccountRepository;
import net.houssam.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private AccountService accountService;
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository,
                                 AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO getAccountById(@PathVariable String id) {
        return accountService.getAccount(id);
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {

        return accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO update(@PathVariable String id, @RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.updateAccount(id, requestDTO);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        accountService.deleteAccount(id);
    }
}
