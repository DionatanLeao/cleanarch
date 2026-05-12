package com.devdeolho.cleanarch.core.usecase.impl;

import com.devdeolho.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.devdeolho.cleanarch.core.dataprovider.UpdateCustomer;
import com.devdeolho.cleanarch.core.domain.Address;
import com.devdeolho.cleanarch.core.domain.Customer;
import com.devdeolho.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.devdeolho.cleanarch.core.usecase.UpdateCustomerUseCase;

public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private UpdateCustomer updateCustomer;
    private FindCustomerByIdUseCase findCustomerByIdUseCase;
    private FindAddressByZipCode findAddressByZipCode;

    public UpdateCustomerUseCaseImpl(UpdateCustomer updateCustomer,
                                     FindCustomerByIdUseCase findCustomerByIdUseCase,
                                     FindAddressByZipCode findAddressByZipCode) {
        this.updateCustomer = updateCustomer;
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.findAddressByZipCode = findAddressByZipCode;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdUseCase.find(customer.getId());
        Address address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        updateCustomer.update(customer);
    }
}
