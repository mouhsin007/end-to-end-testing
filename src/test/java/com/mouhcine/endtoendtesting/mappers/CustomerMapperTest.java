package com.mouhcine.endtoendtesting.mappers;

import com.mouhcine.endtoendtesting.dtos.CustomerDto;
import com.mouhcine.endtoendtesting.entities.Customer;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;


class CustomerMapperTest {
    CustomerMapper underTest= new CustomerMapper();

    @Test
    public void shouldMapCustomerToCustomerDto(){
       Customer givenCustomer= Customer.builder()
                .id(1L).firstName("mouhcine").lastName("elqadiri").email("mouhcine@gmail.com").build();
        CustomerDto expectedCustomer= CustomerDto.builder()
                .id(1L).firstName("mouhcine").lastName("elqadiri").email("mouhcine@gmail.com").build();
        CustomerDto result= underTest.fromCustomer(givenCustomer);
        assertThat(result).isNotNull();
        assertThat(result).usingRecursiveComparison().isEqualTo(expectedCustomer);
    }
    @Test
    public void shouldMapNullCustomerToCustomerDto(){
        Customer givenCustomer= null;
        assertThatThrownBy(() -> underTest.fromCustomer(givenCustomer)).isInstanceOf(IllegalArgumentException.class);
    }
}