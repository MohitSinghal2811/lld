package PaymentService;

public class Upi implements PaymentMethod {

	private String UpiId;

	public Upi(String UpiId) {
		this.UpiId = UpiId;
	}

	public void pay() {
		System.out.println("Payment via UPI " + this.UpiId);
	}


}
