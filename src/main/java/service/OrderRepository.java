package service;
import dto.Order;

import java.util.List;

public interface OrderRepository {
    Order getOrderById(int id);
    List<Order> getAllOrders();
    void addOrder(Order order);
}