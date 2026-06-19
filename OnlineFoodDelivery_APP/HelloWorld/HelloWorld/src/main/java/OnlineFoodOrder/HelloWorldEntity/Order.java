package OnlineFoodOrder.HelloWorldEntity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
	
	// This class used to Mapping MySQl DataBase and store datavalue
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String customerName;
	    private String item;
	    private Double amount;
	    private String status;

	    public Order() {}

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getItem() {
	        return item;
	    }

	    public void setItem(String item) {
	        this.item = item;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

}
