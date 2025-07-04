package com.devdeolho.cleanarch.config;

import com.devdeolho.cleanarch.core.impl.InsertCustomerUseCaseImpl;
import com.devdeolho.cleanarch.dataprovider.FindAddressByZipCodeImpl;
import com.devdeolho.cleanarch.dataprovider.InsertCustomerImpl;
import com.devdeolho.cleanarch.dataprovider.SendCpfForValidationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUseCaseImpl insertCustomerUseCase(
        FindAddressByZipCodeImpl findAddressByZipCode,
        InsertCustomerImpl insertCustomer,
        SendCpfForValidationImpl sendCpfForValidationImpl
    ) {
        return new InsertCustomerUseCaseImpl(
                findAddressByZipCode,
                insertCustomer,
                sendCpfForValidationImpl
        );
    }
}
