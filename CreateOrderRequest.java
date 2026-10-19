package com.ganesh.orders.dto;
import java.math.BigDecimal;
public record CreateOrderRequest(String customerId, String productId, int quantity, BigDecimal amount) {}
