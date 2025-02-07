package PaymentService;

public class Client {
	public static void main(String[] args) {
		PaymentService paymentService = new PaymentService();
		paymentService.addPaymentMethod("UPI", new Upi("upiId"));
		paymentService.addPaymentMethod("DebitCard", new DebitCard("cardNo", "userName"));
		paymentService.addPaymentMethod("CreditCard", new CreditCard("cardNo", "userName"));
		paymentService.makePayment("UPI");
	}
}
