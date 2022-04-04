/**
 * This method contains information about each Broker, including their name, their coins of interest, and their strategies.
 * @author Mohammed Al-Darwish, Disha Puri, Anusha Sheikh, Dexter Yan
 */
package cryptoTrader.gui;

import java.util.*;

public class Broker {

	/**
	 * The following variables hold different aspects of a Broker's information
	 */
	private String brokerName;
	private String[] coins;
	private ArrayList<String> strategies;
	private String selectedStrategy;

	/**
	 * coinMap is a hash map that stores required objects of type Coin
	 */
	private HashMap<String, Coin> coinMap = new HashMap<String, Coin>();


	/**
	 * This constructor initializes a new Broker object
	 * @param name represents the name of the Broker
	 * @param coinsSelected represents the coins the user has inputted
	 * @param strat represents the strategy the user has selected
	 */
	public Broker(String name, String[] coinsSelected, String strat) {
		this.brokerName = name;
		this.coins = coinsSelected;
		this.selectedStrategy = strat;
	}

	/**
	 * Getter method that returns the Broker's name
	 * @return the name of the Broker
	 */
	public String getName() {
		return brokerName;
	}

	/**
	 * Getter method that returns the list of coins
	 * @return the list of coins the user has inputted
	 */
	public String[] getCoins() {
		return coins;
	}

	/**
	 * Getter method returns the list of strategies associated with the Broker
	 * @return the list of strategies associated with the Broker
	 */
	public ArrayList<String> getStrategies() {
		return strategies;
	}

	/**
	 * Getter method returns the strategy that the user has selected
	 * @return the strategy that the user has selected
	 */
	public String getSelectedStrategy() {
		return selectedStrategy;
	}

	/**
	 * Getter method that returns the hash map of required coins
	 * @return the hash map of required coins
	 */
	public HashMap<String,Coin> getCoinMap(){
		return coinMap;
	}

	/**
	 * Setter method that sets a hash map as the coinMap variable
	 * @param newMap represents the new hash map we would like to integrate into a Broker object
	 */
	public void setCoinMap(HashMap<String,Coin> newMap){
		this.coinMap = newMap;
	}

	/**
	 * This method calls on the Trading Strategies class to calculate a trade based on the user's input
	 * @param database represents the an ActionLog object containing all trading information for the user's session
	 */
	public void calculateStrat(ActionLog database) {
		TradingStrategies calcStrat = new TradingStrategies( this.brokerName, this.selectedStrategy, this.coinMap,database);
	}
	
} // end of file