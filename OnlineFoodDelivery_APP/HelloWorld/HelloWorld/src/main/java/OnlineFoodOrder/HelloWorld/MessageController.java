package OnlineFoodOrder.HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/send")
    public String send() {

        jmsTemplate.convertAndSend(
                "order.created",
                "Hello ActiveMQ"
        );

        return "Message Sent Successfully";
    }
}