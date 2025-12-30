package com.learnSpring.Module1Introduction;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void pay() {
        System.out.println("Paying...");
    }

}
