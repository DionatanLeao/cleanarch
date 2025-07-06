package com.devdeolho.cleanarch.core.usecase;

import com.devdeolho.cleanarch.core.domain.Customer;

public interface InsertCustomerUseCase {
    void insert(Customer customer, String zipCode);
}
