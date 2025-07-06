package com.devdeolho.cleanarch.core.usecase;

import com.devdeolho.cleanarch.core.domain.Customer;

public interface FindCustomerByIdUseCase {
    Customer find(final String id);
}
