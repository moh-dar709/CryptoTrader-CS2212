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

	/**
	 * Constructor for coin
	 * @param name name of coin
	 * @param p price of coin
	 * @param mCap market cap of coin
	 * @param vol volume trade of coin
	 */
	public Coin(String name, double p) {
		this.name = name;
		this.price = p;
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
	
} // end of file