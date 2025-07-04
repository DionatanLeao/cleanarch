package com.devdeolho.cleanarch.core.impl;


import com.devdeolho.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.devdeolho.cleanarch.core.dataprovider.InsertCustomer;
import com.devdeolho.cleanarch.core.dataprovider.SendCpfForValidation;
import com.devdeolho.cleanarch.core.domain.Customer;
import com.devdeolho.cleanarch.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {
    private final FindAddressByZipCode findAddressByZipCode;
    private final InsertCustomer insertCustomer;

    private final SendCpfForValidation sendCpfForValidation;

    public InsertCustomerUseCaseImpl(
            FindAddressByZipCode findAddressByZipCode,
            InsertCustomer insertCustomer,
            SendCpfForValidation sendCpfForValidation
    ) {
        this.findAddressByZipCode = findAddressByZipCode;
        this.insertCustomer = insertCustomer;
        this.sendCpfForValidation = sendCpfForValidation;
    }
    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCode.find(zipCode);
        customer.setAddress(address);
        insertCustomer.insert(customer);
        sendCpfForValidation.send(customer.getCpf());
    }
}
