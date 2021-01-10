package com.dev.msscbeerinventoryservice.service;

import com.dev.brewery.model.event.AllocateOrderRequest;
import com.dev.brewery.model.event.AllocationOrderResult;
import com.dev.msscbeerinventoryservice.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AllocationListner {

    private final JmsTemplate jmsTemplate;
    private final AllocationService service;

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER)
    public void listen(AllocateOrderRequest allocateOrderRequest) {
        AllocationOrderResult.AllocationOrderResultBuilder builder = AllocationOrderResult.builder();
        builder.beerOrderDto(allocateOrderRequest.getBeerOrderDto());
        try {
            Boolean allocationResult = service.allocateOrder(allocateOrderRequest.getBeerOrderDto());

            if (allocationResult) {
                builder.pendingInventory(false);
            } else {
                builder.pendingInventory(true);
            }
        }
        catch (Exception e){
            log.error("Allocation Order failed for order Id:" +
                              ""+ allocateOrderRequest.getBeerOrderDto().getId());
        }

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_RESPONSE,builder.build());
    }

}
