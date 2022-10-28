
public class Payment
{
		private String cardNumber;
		private String expMon;
		private String expYear;
		private String ccv; 
		
		public Payment(String cardNumber, String expMon, String expYear, String ccv)
		{
			this.cardNumber = cardNumber;
			this.expMon = expMon;
			this.expYear = expYear;
			this.ccv = ccv;
		}
		
		public void setCardNumber(String cardNumber)
		{
			this.cardNumber = cardNumber;
		}
		
		public void setExpMon(String expMon)
		{
			this.expMon = expMon;
		}
		
		public void setExpYear(String expYear)
		{
			this.expYear = expYear;
		}
		
		public void setCcv(String ccv)
		{
			this.ccv = ccv;
		}
		
		public String getCardNumber()
		{
			return this.cardNumber;
		}
		
		public String getExpMon()
		{
			return this.expMon;
		}
		
		public String getExpYear()
		{
			return this.expYear;
		}
		
		public String getCcv()
		{
			return this.ccv;
		}
		
}
