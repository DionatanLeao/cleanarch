package com.devdeolho.cleanarch.core.dataprovider;

import com.devdeolho.cleanarch.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerById {

    Optional<Customer>  find(final String id);
}
