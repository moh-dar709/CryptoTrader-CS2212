package cryptoTrader.gui;

public class Coin {

	// instance variables
	private String name;
	private double price;
	private double marketCap;
	private double volume;
	
	// constructor
	public Coin(String name, double p, double mCap, double vol) {
		this.name = name;
		this.price = p;
		this.marketCap = mCap;
		this.volume = vol;
	} // end of constructor
	
	// getter name
	public String getName() {
		return this.name;
	}
	
	 // getter price
	public double getPrice() {
		return this.price;
	}
	
	public double getMarketCap() {
		return this.marketCap;
	}
	
	public double getVolume() {
		return this.volume;
	}
	
} // end of file