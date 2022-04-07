package cryptoTrader.gui;

import java.util.HashMap;

public interface Strategy {

	public abstract void doStrat(String broker, HashMap<String, Coin> coinMap, ActionLog database);
	
} // end of file