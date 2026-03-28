package com.devdeolho.cleanarch.config;

import com.devdeolho.cleanarch.core.dataprovider.DeleteCustomerById;
import com.devdeolho.cleanarch.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import com.devdeolho.cleanarch.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.devdeolho.cleanarch.dataprovider.DeleteCustomerByIdImpl;
import com.devdeolho.cleanarch.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCaseImpl deleteCustomerByIdUseCase(
            FindCustomerByIdUseCaseImpl findCustomerByIdUseCase,
            DeleteCustomerByIdImpl deleteCustomerById
    ) {
        return new DeleteCustomerByIdUseCaseImpl(deleteCustomerById, findCustomerByIdUseCase);
    }
}
