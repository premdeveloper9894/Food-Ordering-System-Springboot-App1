package OnlineFoodOrder.HelloWorldRepository;

import OnlineFoodOrder.HelloWorldEntity.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepository
        extends JpaRepository<Kitchen, Long> {

}