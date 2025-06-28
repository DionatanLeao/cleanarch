package com.devdeolho.cleanarch.dataprovider.repository.entity;

import com.devdeolho.cleanarch.core.domain.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "customers")
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String cpf;
    private Address address;
    private Boolean isValidCpf;
}
