package com.ganesh.orders.model;
import java.math.BigDecimal; import java.time.Instant; import java.util.UUID;
public record Order(String id, String customerId, String productId, int quantity, BigDecimal amount, OrderStatus status, Instant createdAt) {
  public static Order create(String customerId,String productId,int quantity,BigDecimal amount){
    return new Order(UUID.randomUUID().toString(),customerId,productId,quantity,amount,OrderStatus.CREATED,Instant.now());
  }
}
