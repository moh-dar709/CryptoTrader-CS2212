package cryptoTrader.gui;

public class TradeAction {

	// instance variables
	private String trader;
	private String strategy;
	private String cryptocoin;
	private String action;
	private String quantity;
	private String price;
	private String date;
	
	// constructor
	public TradeAction(String trader, String strategy, String cryptocoin, String action, String quantity, String price, String date) {
		this.trader = trader;
		this.strategy = strategy;
		this.cryptocoin = cryptocoin;
		this.action = action;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
		
	} // end of constructor
	
	public String getTrader() {
		return this.trader;
	}
	
	public String getStrategy() {
		return this.strategy;
	}
	
	public String getCryptocoin() {
		return this.cryptocoin;
	}
	
	public String getAction() {
		return this.action;
	}
	
	public String getQuantity() {
		return this.quantity;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public Object[] asArray() {
		Object arr[] = {this.trader,this.strategy,this.cryptocoin,this.action,this.quantity,this.price,this.date};
		return arr;
	}
	
}// end of file