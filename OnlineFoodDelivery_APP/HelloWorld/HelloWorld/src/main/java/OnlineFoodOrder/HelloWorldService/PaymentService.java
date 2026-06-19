package OnlineFoodOrder.HelloWorldService;

import OnlineFoodOrder.HelloWorldEntity.Payment;
import OnlineFoodOrder.HelloWorldRepository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public String processPayment(Long orderId, Double amount) {

        Random random = new Random();

        boolean success = random.nextBoolean();

        Payment payment = new Payment();

        payment.setOrderId(orderId);
        payment.setAmount(amount);

        if(success) {
            payment.setPaymentStatus("SUCCESS");
        } else {
            payment.setPaymentStatus("FAILED");
        }

        paymentRepository.save(payment);

        return payment.getPaymentStatus();
    }
}