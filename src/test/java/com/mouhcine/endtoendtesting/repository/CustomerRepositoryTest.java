package com.mouhcine.endtoendtesting.repository;

import com.mouhcine.endtoendtesting.entities.Customer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@ActiveProfiles("test")
@DataJpaTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setup(){
        customerRepository.save(Customer.builder()
                .firstName("mouhcine")
                .lastName("elqadiri")
                .email("mouhcine@gmail.com")
                .build());
        customerRepository.save(Customer.builder()
                .firstName("akram")
                .lastName("nekkab")
                .email("akram@gmail.com")
                .build());
        customerRepository.save(Customer.builder()
                .firstName("zakariya")
                .lastName("naaim")
                .email("zakariya@gmail.com")
                .build());
        customerRepository.save(Customer.builder()
                .firstName("abdelkader")
                .lastName("archid")
                .email("abdelkader@gmail.com")
                .build());

    }

    @Test
    public void shoudFoundCustomerByFirstName(){
        String firstName= "mouhcine";
        Optional<Customer> result = customerRepository.findByFirstName((firstName));
        assertThat(result).isPresent();

    }

    @Test
    public void shoudNotFoundCustomerByFirstName(){
        String firstName= "ikram";
        Optional<Customer> result = customerRepository.findByFirstName((firstName));
        assertThat(result).isEmpty();

    }
}