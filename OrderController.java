package com.ganesh.orders.controller;
import com.ganesh.orders.dto.CreateOrderRequest; import com.ganesh.orders.model.Order; import com.ganesh.orders.service.OrderService;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/orders")
public class OrderController {
  private final OrderService service; public OrderController(OrderService s){this.service=s;}
  @PostMapping public ResponseEntity<Order> create(@RequestBody CreateOrderRequest req){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(req.customerId(),req.productId(),req.quantity(),req.amount())); }
  @GetMapping("/{id}") public ResponseEntity<Order> get(@PathVariable String id){
    return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
}
