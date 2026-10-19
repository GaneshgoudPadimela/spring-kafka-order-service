package com.ganesh.orders.kafka;
import com.ganesh.orders.model.Order;
import org.slf4j.*; import org.springframework.kafka.annotation.KafkaListener; import org.springframework.stereotype.Component;
@Component
public class OrderEventConsumer {
  private static final Logger log = LoggerFactory.getLogger(OrderEventConsumer.class);
  @KafkaListener(topics="${app.topic.order-created}", groupId="order-service")
  public void onOrderCreated(Order order){ log.info("Order created: {} customer={} amount={}", order.id(), order.customerId(), order.amount()); }
}
