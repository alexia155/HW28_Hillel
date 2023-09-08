package service;
import dto.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {
    private Map<Integer, Order> orders = new HashMap<>();
    private int nextId = 1;

    @Override
    public Order getOrderById(int id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void addOrder(Order order) {
        order.setId(nextId);
        orders.put(nextId, order);
        nextId++;
    }
}
