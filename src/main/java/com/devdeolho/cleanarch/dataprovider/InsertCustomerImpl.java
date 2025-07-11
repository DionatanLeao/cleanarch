package com.devdeolho.cleanarch.dataprovider;

import com.devdeolho.cleanarch.core.dataprovider.InsertCustomer;
import com.devdeolho.cleanarch.core.domain.Customer;
import com.devdeolho.cleanarch.dataprovider.repository.CustomerRepository;
import com.devdeolho.cleanarch.dataprovider.repository.mapper.CustomerEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerImpl implements InsertCustomer {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public void insert(Customer customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
    }
}
