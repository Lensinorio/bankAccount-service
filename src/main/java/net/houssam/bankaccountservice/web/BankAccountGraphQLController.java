package net.houssam.bankaccountservice.web;

import net.houssam.bankaccountservice.dto.BankAccountRequestDTO;
import net.houssam.bankaccountservice.dto.BankAccountResponseDTO;
import net.houssam.bankaccountservice.entities.BankAccount;
import net.houssam.bankaccountservice.entities.Customer;
import net.houssam.bankaccountservice.repositories.BankAccountRepository;
import net.houssam.bankaccountservice.repositories.CustomerRepository;
import net.houssam.bankaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private CustomerRepository CustomerRepository;
    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id)
   .orElseThrow(() -> new RuntimeException(String.format("Bank account with id %s not found", id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        return accountService.updateAccount(id,bankAccount);
    }

    @MutationMapping
    public boolean deleteAccount(@Argument String id) {
         accountService.deleteAccount(id);
         return true;
    }
    @QueryMapping
    public List<Customer> customers() {
        return CustomerRepository.findAll();
    }


//    record BankAccountDTO(Double balance,String type,String currency) {
//
//    }
}
