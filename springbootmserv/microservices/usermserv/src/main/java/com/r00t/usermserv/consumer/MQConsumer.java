package com.r00t.usermserv.consumer;

import java.math.BigInteger;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.r00t.usermserv.mappers.UserMapper;
import com.r00t.usermserv.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Service
@Slf4j
public class MQConsumer {
    private static final String QUEUE_CREATE_ORDER = "q.checkUser";
    @Autowired
    UserRepository uRepository;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    private UserMapper mapper;

    @RabbitListener(queues = QUEUE_CREATE_ORDER)
    public void createOrderValidation(int userID) throws Exception {
        log.info("CREATE_ORDER_EVENT_ID: {} ", userID);
         BigInteger bigint = new BigInteger(String.valueOf(userID));
        try {
            // ValidateUser(bigint);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }
}