package com.devdeolho.cleanarch.dataprovider.repository;

import com.devdeolho.cleanarch.dataprovider.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
