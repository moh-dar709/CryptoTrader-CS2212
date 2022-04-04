/**
 * TradeAction class
 * This is where we define a trading action object
 * @author Mohammed Al-Darwish, Disha Puri, Anusha Sheikh, Dexter Yan
 */
package cryptoTrader.gui;

public class TradeAction {

	/**
	 * Instance variables
	 */
	private String trader;
	private String strategy;
	private String cryptocoin;
	private String action;
	private String quantity;
	private String price;
	private String date;

	/**
	 * Constructor for tradeAction object
	 * @param trader trader name
	 * @param strategy strategy name
	 * @param cryptocoin name of coin
	 * @param action trade status
	 * @param quantity number of coins traded
	 * @param price coin price
	 * @param date trade date
	 */
	public TradeAction(String trader, String strategy, String cryptocoin, String action, String quantity, String price, String date) {
		this.trader = trader;
		this.strategy = strategy;
		this.cryptocoin = cryptocoin;
		this.action = action;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		
	} // end of constructor

	/**
	 * getTrader method
	 * @return trader name
	 */
	public String getTrader() {
		return this.trader;
	}

	/**
	 * getStrategy method
	 * @return strategy name
	 */
	public String getStrategy() {
		return this.strategy;
	}

	/**
	 * getCryptocoin method
	 * @return coin name
	 */
	public String getCryptocoin() {
		return this.cryptocoin;
	}

	/**
	 * getAction method
	 * @return action status
	 */
	public String getAction() {
		return this.action;
	}

	/**
	 * getQuantity method
	 * @return number of coins traded
	 */
	public String getQuantity() {
		return this.quantity;
	}

	/**
	 * getPrice method
	 * @return price of coin
	 */
	public String getPrice() {
		return this.price;
	}

	/**
	 * getDate method
	 * @return date of trade
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * Creates object array storing all the trade action info
	 * @return object array
	 */
	public Object[] asArray() {
		Object arr[] = {this.trader,this.strategy,this.cryptocoin,this.action,this.quantity,this.price,this.date};
		return arr;
	}
	
}// end of file