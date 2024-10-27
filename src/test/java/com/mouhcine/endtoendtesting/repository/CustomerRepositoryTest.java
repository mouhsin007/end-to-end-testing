package com.mouhcine.endtoendtesting.repository;

import com.mouhcine.endtoendtesting.entities.Customer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@ActiveProfiles("test")
@DataJpaTest
class CustomerRepositoryTest {
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
    public void shoudFindCustomerByFirstName(){
        String firstName= "mouhcine";
        Optional<Customer> result = customerRepository.findByFirstName((firstName));
        assertThat(result).isPresent();

    }

    @Test
    public void shoudNotFindCustomerByFirstName(){
        String firstName= "ikram";
        Optional<Customer> result = customerRepository.findByFirstName((firstName));
        assertThat(result).isEmpty();

    }

    @Test
    public void shoudFindCustomerByFirstNameContainingKeyword(){
        String keyword= "e";
        List<Customer> expected = List.of(Customer.builder()
                .firstName("mouhcine")
                .lastName("elqadiri")
                .email("mouhcine@gmail.com")
                .build(),
                Customer.builder()
                        .firstName("abdelkader")
                        .lastName("archid")
                        .email("abdelkader@gmail.com")
                        .build()
                );
        List<Customer> result = customerRepository.findByFirstNameContainingIgnoreCase(keyword);
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(expected.size());
        assertThat(result).usingRecursiveComparison().ignoringFields("id").isEqualTo(expected);

    }
}