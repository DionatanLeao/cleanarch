package com.devdeolho.cleanarch.dataprovider.repository.mapper;

import com.devdeolho.cleanarch.core.domain.Customer;
import com.devdeolho.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
}
