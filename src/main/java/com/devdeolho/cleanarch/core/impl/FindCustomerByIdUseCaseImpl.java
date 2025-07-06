package com.devdeolho.cleanarch.core.impl;

import com.devdeolho.cleanarch.core.dataprovider.FindCustomerById;
import com.devdeolho.cleanarch.core.domain.Customer;
import com.devdeolho.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {
    private final FindCustomerById findCustomerById;

    public FindCustomerByIdUseCaseImpl(FindCustomerById findCustomerById) {
        this.findCustomerById = findCustomerById;
    }

    @Override
    public Customer find(String id) {
        return findCustomerById.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
