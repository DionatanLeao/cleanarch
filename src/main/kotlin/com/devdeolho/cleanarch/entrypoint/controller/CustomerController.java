package com.devdeolho.cleanarch.entrypoint.controller;

import com.devdeolho.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.devdeolho.cleanarch.core.usecase.InsertCustomerUseCase;
import com.devdeolho.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.devdeolho.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.devdeolho.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.devdeolho.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        insertCustomerUseCase.insert(customerMapper.toCustomer(customerRequest),
                customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable final String id) {
        return ResponseEntity.ok(customerMapper.toCustomerResponse(findCustomerByIdUseCase.find(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid CustomerRequest customerRequest,
                                       @PathVariable final String id) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerUseCase.update(customer, id);
        return ResponseEntity.noContent().build();
    }
}
