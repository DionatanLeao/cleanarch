package com.devdeolho.cleanarch.dataprovider;

import com.devdeolho.cleanarch.core.dataprovider.FindAddressByZipCode;
import com.devdeolho.cleanarch.core.domain.Address;
import com.devdeolho.cleanarch.dataprovider.client.FindAddressByZipCodeClient;
import com.devdeolho.cleanarch.dataprovider.client.mapper.AddressResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class FindAddressByZipCodeImpl implements FindAddressByZipCode {
    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        return addressResponseMapper.toAddress(findAddressByZipCodeClient.find(zipCode));
    }
}
