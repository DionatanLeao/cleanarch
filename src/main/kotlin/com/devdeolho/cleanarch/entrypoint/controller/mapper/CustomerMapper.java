package com.devdeolho.cleanarch.entrypoint.controller.mapper;

import com.devdeolho.cleanarch.core.domain.Customer;
import com.devdeolho.cleanarch.entrypoint.controller.request.CustomerRequest;
import com.devdeolho.cleanarch.entrypoint.controller.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomerRequest(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
