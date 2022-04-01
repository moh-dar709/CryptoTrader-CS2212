package cryptoTrader.gui;

import java.util.*;

public class Broker {
	
	// instance variables
	private String brokerName;
	private String[] coins;
	private ArrayList<String> strategies;
	private String selectedStrategy;
	
	
	//constructor
	public Broker() {
		
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
