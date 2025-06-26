package com.devdeolho.cleanarch.core.dataprovider;

import com.devdeolho.cleanarch.core.domain.Address;

public interface FindAddressByZipCode {
    Address find(final String zipCode);
}
