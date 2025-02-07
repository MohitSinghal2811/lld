package PaymentService;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
	
	private Map<String, PaymentMethod> paymentMethods;
	
	public PaymentService() {
		this.paymentMethods = new HashMap<String, PaymentMethod>();
	}

	public void addPaymentMethod(String name, PaymentMethod paymentMethod) {
		paymentMethods.put(name, paymentMethod);
	}

	public void makePayment(String name){
		PaymentMethod paymentMethod = paymentMethods.get(name);
		paymentMethod.pay(); // runtime polymorphism
	}
}
