package cryptoTrader.gui;

import java.util.*;

public class Broker {
	
	// instance variables
	private String brokerName;
	private String[] coins;
	private ArrayList<String> strategies;
	private String selectedStrategy;
	
	
	
	
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
	
	
}
