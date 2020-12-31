package com.dev.msscbeerinventoryservice;

import org.jgroups.blocks.locking.AwaitInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

@SpringBootApplication
public class MsscbeerinventoryserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsscbeerinventoryserviceApplication.class, args);
    }

}
