package PaymentService;

public class CreditCard extends Card {

	public CreditCard(String cardNo, String userName) {
		super(cardNo, userName);
	}

	@Override
		public
		void pay() {
			System.out.println("Payment via Credit Card " + this.getCardNo());
		}

	
	
}
