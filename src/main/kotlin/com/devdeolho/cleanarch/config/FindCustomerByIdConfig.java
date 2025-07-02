package com.devdeolho.cleanarch.config;

import com.devdeolho.cleanarch.core.impl.FindCustomerByIdUseCaseImpl;
import com.devdeolho.cleanarch.dataprovider.FindCustomerByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
    @Bean
    public FindCustomerByIdUseCaseImpl findCustomerByIdUseCase(
            FindCustomerByIdImpl findCustomerById
    ) {
        return new FindCustomerByIdUseCaseImpl(
                findCustomerById
        );
    }
}
