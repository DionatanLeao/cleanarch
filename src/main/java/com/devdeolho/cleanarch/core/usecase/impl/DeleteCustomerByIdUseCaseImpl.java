package com.devdeolho.cleanarch.core.usecase.impl;

import com.devdeolho.cleanarch.core.dataprovider.DeleteCustomerById;
import com.devdeolho.cleanarch.core.usecase.DeleteCustomerByIdUseCase;
import com.devdeolho.cleanarch.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

    private FindCustomerByIdUseCase findCustomerByIdUseCase;
    private DeleteCustomerById deleteCustomerById;

    public DeleteCustomerByIdUseCaseImpl(DeleteCustomerById deleteCustomerById,
                                         FindCustomerByIdUseCase findCustomerByIdUseCase) {
        this.findCustomerByIdUseCase = findCustomerByIdUseCase;
        this.deleteCustomerById = deleteCustomerById;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdUseCase.find(id);
        deleteCustomerById.delete(id);
    }
}
