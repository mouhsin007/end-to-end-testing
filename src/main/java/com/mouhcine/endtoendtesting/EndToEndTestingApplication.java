package com.mouhcine.endtoendtesting;

import com.mouhcine.endtoendtesting.entities.Customer;
import com.mouhcine.endtoendtesting.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class EndToEndTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndToEndTestingApplication.class, args);
    }

    @Bean
    @Profile("!test")
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
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
        };

    }
}
