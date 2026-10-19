package com.ganesh.orders.kafka;
import com.ganesh.orders.model.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Component
public class OrderEventProducer {
  private final KafkaTemplate<String, Order> kafka;
  @Value("${app.topic.order-created}") private String topic;
  public OrderEventProducer(KafkaTemplate<String, Order> kafka){ this.kafka=kafka; }
  public void publishOrderCreated(Order order){ kafka.send(topic, order.id(), order); }
}
