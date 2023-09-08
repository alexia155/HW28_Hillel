import com.google.gson.Gson;
import dto.Order;
import dto.Product;
import service.OrderRepository;
import service.OrderRepositoryImpl;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepositoryImpl();
        port(8080);  //sparkjava initialization

        post("/orders", (req, res) -> {
            Order order = new Gson().fromJson(req.body(), Order.class);
            orderRepository.addOrder(order);
            return "Order added successfully!";
        });

        get("/orders", (req, res) -> {
            res.type("application/json");
            return new Gson().toJson(orderRepository.getAllOrders());
        });

        get("/orders/:id", (req, res) -> {
            int orderId = Integer.parseInt(req.params(":id"));
            Order order = orderRepository.getOrderById(orderId);
            if (order != null) {
                res.type("application/json");
                return new Gson().toJson(order);
            } else {
                res.status(404);
                return "Order not found!";
            }
        });
    }
}