package com.devdeolho.cleanarch.config;

import com.devdeolho.cleanarch.core.impl.FindCustomerByIdUseCaseImpl;
import com.devdeolho.cleanarch.core.impl.UpdateCustomerUseCaseImpl;
import com.devdeolho.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.devdeolho.cleanarch.dataprovider.UpdateCustomerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCaseImpl updateCustomerUseCase(
        FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
        FindAddressByZipCodeImpl findAddressByZipCode,
        UpdateCustomerImpl updateCustomer
    ) {
        return new UpdateCustomerUseCaseImpl(
                findCustomerByIdUseCase,
                findAddressByZipCode,
                updateCustomer
        );
    }
}
