package OnlineFoodOrder.HelloWorld;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {
	
	 @JmsListener(destination = "order.created")
	    public void receive(String message) {

	        System.out.println("Received Message : " + message);

	    }

}
