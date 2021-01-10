package com.dev.msscbeerinventoryservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    public static final String INVENTORY_QUEUE ="inventory-request" ;
    public static final String ALLOCATE_ORDER = "allocate-order";
    public static final String ALLOCATE_ORDER_RESPONSE = "allocate-order-response";

    @Bean
    public MessageConverter messageConverter(ObjectMapper mapper){
        MappingJackson2MessageConverter converter=new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
converter.setObjectMapper(mapper);
        return converter;
    }
}
