package OnlineFoodOrder.HelloWorldService;

import OnlineFoodOrder.HelloWorldEntity.Kitchen;
import OnlineFoodOrder.HelloWorldRepository.KitchenRepository;
import org.springframework.stereotype.Service;

@Service
public class KitchenService {

    private final KitchenRepository kitchenRepository;

    public KitchenService(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    public String prepareFood(Long orderId) {

        Kitchen kitchen = new Kitchen();

        kitchen.setOrderId(orderId);
        kitchen.setKitchenStatus("READY");

        kitchenRepository.save(kitchen);

        return "READY";
    }
}