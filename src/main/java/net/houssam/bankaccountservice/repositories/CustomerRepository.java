package net.houssam.bankaccountservice.repositories;

import net.houssam.bankaccountservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
