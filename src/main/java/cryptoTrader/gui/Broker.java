package cryptoTrader.gui;

import java.util.*;

public class Broker {
	
	// instance variables
	private String brokerName;
	private String[] coins;
	private ArrayList<String> strategies;
	private String selectedStrategy;
	
	private HashMap<String, Coin> coinMap = new HashMap<String, Coin>();
	
	
	//constructor to initialize broker object
	public Broker(String name, String[] coinsSelected, String strat) {
		this.brokerName = name;
		this.coins = coinsSelected;
		this.selectedStrategy = strat;
	}
	
	public String getName() {
		return brokerName;
	}
	
	public String[] getCoins() {
		return coins;
	}

	public ArrayList<String> getStrategies() {
		return strategies;
	}
	
	public String getSelectedStrategy() {
		return selectedStrategy;
	}
	
	public HashMap<String,Coin> getCoinMap(){
		return coinMap;
	}
	
	public void setCoinMap(HashMap<String,Coin> newMap){
		this.coinMap = newMap;
	}
	
	public void calculateStrat(ActionLog database) {
		// calls TradingStrategies class to calculate strat
		TradingStrategies calcStrat = new TradingStrategies( this.brokerName, this.selectedStrategy, this.coinMap,database);
	}
	
} // end of file