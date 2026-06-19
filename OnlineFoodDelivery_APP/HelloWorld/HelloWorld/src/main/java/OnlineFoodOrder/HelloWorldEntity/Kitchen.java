package OnlineFoodOrder.HelloWorldEntity;

import jakarta.persistence.*;

@Entity
public class Kitchen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private String kitchenStatus;

    public Kitchen() {
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getKitchenStatus() {
        return kitchenStatus;
    }

    public void setKitchenStatus(String kitchenStatus) {
        this.kitchenStatus = kitchenStatus;
    }
}