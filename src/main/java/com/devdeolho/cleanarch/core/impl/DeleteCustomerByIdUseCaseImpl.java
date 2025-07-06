package com.devdeolho.cleanarch.core.impl;

import com.devdeolho.cleanarch.core.dataprovider.DeleteCustomerById;
import com.devdeolho.cleanarch.core.dataprovider.FindCustomerById;
import com.devdeolho.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.devdeolho.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {
    private final FindCustomerByIdUseCase findCustomerByIdUseCase;

    private final DeleteCustomerById deleteCustomerById;

    public DeleteCustomerByIdUseCaseImpl(
        FindCustomerByIdUseCase findCustomerByIdUseCase,
        DeleteCustomerById deleteCustomerById
    ) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.deleteCustomerById = deleteCustomerById;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdUseCase.find(id);
        deleteCustomerById.delete(id);
    }
}
