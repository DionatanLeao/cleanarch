package com.devdeolho.cleanarch.entrypoint.controller;

import com.devdeolho.cleanarch.core.usecase.FindCustomerByIdUseCase;
import com.devdeolho.cleanarch.core.usecase.InsertCustomerUseCase;
import com.devdeolho.cleanarch.entrypoint.controller.mapper.CustomerMapper;
import com.devdeolho.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.devdeolho.cleanarch.entrypoint.controller.response.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerUseCase insertCustomerUseCase;

    @Autowired
    private FindCustomerByIdUseCase findCustomerByIdUseCase;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        insertCustomerUseCase.insert(customerMapper.toCustomer(customerRequest),
                customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        return ResponseEntity.ok().body(customerMapper.toCustomerResponse(findCustomerByIdUseCase.find(id)));
    }
}
