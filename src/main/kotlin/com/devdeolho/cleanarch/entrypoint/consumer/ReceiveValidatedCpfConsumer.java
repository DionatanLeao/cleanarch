package com.devdeolho.cleanarch.entrypoint.consumer;

import com.devdeolho.cleanarch.core.impl.UpdateCustomerUseCaseImpl;
import com.devdeolho.cleanarch.core.usecase.UpdateCustomerUseCase;
import com.devdeolho.cleanarch.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.devdeolho.cleanarch.entrypoint.consumer.message.CustomerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {
    @Autowired
    private UpdateCustomerUseCase updateCustomerUseCase;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "devdeolho")
    public void receive(CustomerMessage customerMessage) {
        updateCustomerUseCase.update(customerMessageMapper.toCustomer(customerMessage), customerMessage.getZipCode());
    }
}
