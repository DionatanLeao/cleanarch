package com.devdeolho.cleanarch.config;

import com.devdeolho.cleanarch.core.impl.DeleteCustomerByIdUseCaseImpl;
import com.devdeolho.cleanarch.core.impl.FindCustomerByIdUseCaseImpl;
import com.devdeolho.cleanarch.dataprovider.DeleteCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(
        FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
        DeleteCustomerByIdImpl deleteCustomerById
    ) {
        return new DeleteCustomerByIdUseCaseImpl(
                findCustomerByIdUseCase,
                deleteCustomerById
        );
    }
}
