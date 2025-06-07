package com.multishop.service;

import com.multishop.entity.OrderEntity;

import jakarta.mail.MessagingException;

public interface OrderService {

	void placeOrder(OrderEntity order) throws MessagingException;
}
