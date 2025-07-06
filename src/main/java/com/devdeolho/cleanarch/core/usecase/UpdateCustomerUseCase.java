package com.devdeolho.cleanarch.core.usecase;

import com.devdeolho.cleanarch.core.domain.Customer;

public interface UpdateCustomerUseCase {
    void update(Customer customer, String zipCode);
}
