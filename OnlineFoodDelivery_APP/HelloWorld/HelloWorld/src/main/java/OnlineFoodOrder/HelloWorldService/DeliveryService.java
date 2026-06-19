package OnlineFoodOrder.HelloWorldService;

import OnlineFoodOrder.HelloWorldEntity.Delivery;
import OnlineFoodOrder.HelloWorldRepository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public String deliverOrder(Long orderId) {

        Delivery delivery = new Delivery();

        delivery.setOrderId(orderId);
        delivery.setDeliveryStatus("DELIVERED");

        deliveryRepository.save(delivery);

        return "DELIVERED";
    }
}