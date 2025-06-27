package com.devdeolho.cleanarch.dataprovider.client.mapper;

import com.devdeolho.cleanarch.core.domain.Address;
import com.devdeolho.cleanarch.dataprovider.client.response.AddressResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
