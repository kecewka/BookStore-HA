package kz.halykacademy.bookstore.controller;

import kz.halykacademy.bookstore.dto.order.OrderDto;
import kz.halykacademy.bookstore.dto.order.OrderPostDto;
import kz.halykacademy.bookstore.dto.order.OrderPutDto;
import kz.halykacademy.bookstore.mapper.MapStructMapper;
import kz.halykacademy.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;
    private final MapStructMapper mapStructMapper;

    @Autowired
    public OrderController(OrderService orderService, MapStructMapper mapStructMapper) {
        this.orderService = orderService;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping("/orders")
    public List<OrderDto> showAllOrders() {
        List<OrderDto> allOrders = mapStructMapper.orderToDtos(orderService.getAllOrders());

        return allOrders;
    }

    @GetMapping("/orders/{id}")
    public OrderDto getOrder(@PathVariable int id) {
        OrderDto order = mapStructMapper.orderToDto(orderService.getOrder(id));

        return order;
    }

    @PostMapping("/orders")
    public OrderPostDto addNewOrder(@RequestBody OrderPostDto order) {
        orderService.saveOrder(mapStructMapper.dtoToOrder(order));

        return order;
    }

    @PutMapping("/orders")
    public OrderPutDto updateOrder(@RequestBody OrderPutDto order) {
        orderService.updateOrder(mapStructMapper.putDtoToOrder(order));

        return order;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable int id) {
        OrderDto order = mapStructMapper.orderToDto(orderService.getOrder(id));
        orderService.deleteOrder(id);
        return "order: " + order.getId() + " was deleted";
    }

}
