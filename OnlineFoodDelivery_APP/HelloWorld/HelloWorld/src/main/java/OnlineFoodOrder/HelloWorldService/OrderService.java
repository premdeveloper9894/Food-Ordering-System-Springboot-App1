package OnlineFoodOrder.HelloWorldService;

import OnlineFoodOrder.HelloWorldEntity.Order;
import OnlineFoodOrder.HelloWorldRepository.OrderRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final KitchenService kitchenService;
    private final DeliveryService deliveryService;
    private final JmsTemplate jmsTemplate;

    public OrderService(OrderRepository orderRepository,
                        PaymentService paymentService,
                        KitchenService kitchenService,
                        DeliveryService deliveryService,
                        JmsTemplate jmsTemplate) {

        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.kitchenService = kitchenService;
        this.deliveryService = deliveryService;
        this.jmsTemplate = jmsTemplate;
    }

    public Order createOrder(Order order) {

        order.setStatus("PLACED");

        Order savedOrder = orderRepository.save(order);

        jmsTemplate.convertAndSend(
                "order.created",
                savedOrder.getId()
        );

        System.out.println(
                "Order Sent To Queue : " + savedOrder.getId()
        );

        return savedOrder;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(Long id, Order updatedOrder) {

        Order existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder != null) {

            existingOrder.setCustomerName(updatedOrder.getCustomerName());
            existingOrder.setItem(updatedOrder.getItem());
            existingOrder.setAmount(updatedOrder.getAmount());
            existingOrder.setStatus(updatedOrder.getStatus());

            return orderRepository.save(existingOrder);
        }

        return null;
    }

    public String deleteOrder(Long id) {

        orderRepository.deleteById(id);

        return "Order Deleted Successfully";
    }
}