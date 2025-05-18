package net.houssam.bankaccountservice;

import net.houssam.bankaccountservice.entities.BankAccount;
import net.houssam.bankaccountservice.entities.Customer;
import net.houssam.bankaccountservice.enums.AccountType;
import net.houssam.bankaccountservice.repositories.BankAccountRepository;
import net.houssam.bankaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }
@Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository,
                                        CustomerRepository customerRepository) {
        return args -> {
            Stream.of("Mohamed","Yassine","Hanae","Imane").forEach(c -> {
               Customer customer = Customer.builder()
                       .name(c)
                       .build();
               customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    bankAccountRepository.save(BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .createdAt(new Date())
                            .balance(10000 + Math.random() * 900000)
                            .currency(Math.random() > 0.5 ? "USD" : "MAD")
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .customer(customer)
                            .build());

                }
            });

        };
    }
}
