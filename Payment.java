
/**
 * 
 * @author Jaztin T
 * Date of Code: Nov. 7, 2022
 * <p>
 * Programmer's Names: Alondra, Omar, Jesse, Jaztin
 * <p>
 * Brief Description of the Class/Module:
 * <p> 
 * This class is used to store the payment method details. It will store the cardNumber, expMon, expYear, and ccv of a payment method.
 * It would most likely be accessed through the makeReservation window and the ReviewReservation window. 
 * The makeReservation window would store the payment information while the ReviewReservation window will store finalize the data.
 */

public class Payment
{
		private String cardNumber;
		private String expMon;
		private String expYear;
		private String ccv; 
		
		/**
		 * 
		 * @param cardNumber
		 * @param expMon
		 * @param expYear
		 * @param ccv
		 * 
		 * The Payment class constructor will be used to quickly store the cardNumber, expMMon, expYear, and ccv to the Payment class object's respective fields.
		 * 
		 */
		
		public Payment(String cardNumber, String expMon, String expYear, String ccv)
		{
			this.cardNumber = cardNumber;
			this.expMon = expMon;
			this.expYear = expYear;
			this.ccv = ccv;
		}
		
		/**
		 * 
		 * @param cardNumber
		 * The setCardNumber method sets the cardNumber field of the Payment class to the passed in value
		 * 
		 */
		
		public void setCardNumber(String cardNumber)
		{
			this.cardNumber = cardNumber;
		}
		
		/**
		 * @param expMon
		 * The setExpMon method sets the expMon field of the Payment class to the passed in value
		 */
		
		public void setExpMon(String expMon)
		{
			this.expMon = expMon;
		}
		
		/**
		 * @param expYear
		 * The setExpYear method sets the expYear field of the Payment class to the passed in value
		 */
		
		public void setExpYear(String expYear)
		{
			this.expYear = expYear;
		}
		
		/**
		 * @param ccv
		 * The setCcv method sets the ccv field of the Payment class to the passed in value
		 */
		
		public void setCcv(String ccv)
		{
			this.ccv = ccv;
		}
		
		/**
		 * @return cardNumber
		 * The getCardNumber method is called whenever you need to get the cardNumber field of a Payment Class instance
		 */
		
		public String getCardNumber()
		{
			return this.cardNumber;
		}
		
		/**
		 * @return expMon
		 * The getExpMon method is called whenever you need to get the expMon field of a Payment Class instance
		 */
		
		public String getExpMon()
		{
			return this.expMon;
		}
		
		/**
		 * @return expYear
		 * The getExpYear method is called whenever you need to get the expYear field of a Payment Class instance
		 */
		
		public String getExpYear()
		{
			return this.expYear;
		}
		
		/**
		 * @return ccv
		 * The getCcv method is called whenever you need to get the ccv field of a Payment Class instance
		 */
		
		public String getCcv()
		{
			return this.ccv;
		}
		
}
