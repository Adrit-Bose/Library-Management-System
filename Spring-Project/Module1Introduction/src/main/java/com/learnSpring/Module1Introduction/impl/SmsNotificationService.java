package com.learnSpring.Module1Introduction.impl;

import com.learnSpring.Module1Introduction.NotificationService;


public class SmsNotificationService implements NotificationService{
    
    @Override
    public void send(String message) {
        System.out.println("SMS Sending");
    }
}
