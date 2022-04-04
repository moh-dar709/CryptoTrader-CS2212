/**
 * Coin defines what a coin is
 * @author Mohammed Al-Darwish, Disha Puri, Anusha Sheikh, Dexter Yan
 */
package cryptoTrader.gui;

public class Coin {

	/**
	 * Instance variables
	 */
	private String name;
	private double price;
	private double marketCap;
	private double volume;

	/**
	 * Constructor for coin
	 * @param name name of coin
	 * @param p price of coin
	 * @param mCap market cap of coin
	 * @param vol volume trade of coin
	 */
	public Coin(String name, double p, double mCap, double vol) {
		this.name = name;
		this.price = p;
		this.marketCap = mCap;
		this.volume = vol;
	} // end of constructor

	/**
	 * getName method
	 * @return coin name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getPrice method
	 * @return coin price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * marketCap method
	 * @return coin market cap
	 */
	public double getMarketCap() {
		return this.marketCap;
	}

	/**
	 * getVolume method
	 * @return coin volume trade
	 */
	public double getVolume() {
		return this.volume;
	}
	
} // end of file