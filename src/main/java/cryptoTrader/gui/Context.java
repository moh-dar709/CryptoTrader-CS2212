package cryptoTrader.gui;

import java.util.HashMap;

public class Context {

	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void executeStrategy(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		strategy.doStrat(broker, coinMap, database);
	}
	
	
} // end of file