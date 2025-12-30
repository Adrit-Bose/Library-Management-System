package com.learnSpring.Module1Introduction.impl;

import com.learnSpring.Module1Introduction.NotificationService;

public class EmailNotificationService implements NotificationService{
    
    @Override
    public void send(String message) {
        System.out.println("Email Sending");
    }
}
