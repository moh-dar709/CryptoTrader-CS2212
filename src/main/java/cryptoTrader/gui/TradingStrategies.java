/**
 * TradingStrategies holds the trading algorithms for each broker and updates the trade action log accordingly
 * @author Mohammed Al-Darwish, Disha Puri, Anusha Sheikh, Dexter Yan
 */

package cryptoTrader.gui;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TradingStrategies {
	
	/**
	 * String variable that holds today's date
	 */
	private String date;
	
	/**
	 * This method is the TradingStrategies constructor. It directs the trade call to the appropriate broker.
	 * 
	 * @param broker represents the name of the broker that wants to do the trade
	 * @param strat represents the strategy which the broker wants to do
	 * @param coinMap represents the HashMap of coins that the broker has access to
	 * @param database represents the action log database where all current actions are logged
	 */
	public TradingStrategies(String broker, String strat, HashMap<String, Coin> coinMap, ActionLog database) {
		
//		this.date = getDate(); // set date
//		Context context = new Context(new StratA());
		
		// switch to determine which strategy is requested
		switch (strat) {
			case "Strategy-A":
				Context contextA = new Context(new StratA());
				contextA.executeStrategy(broker, coinMap, database); // do A
				System.out.println("Trader: "+broker+" used strategy: "+"A");
				break;
			case "Strategy-B":
				Context contextB = new Context(new StratB());
				contextB.executeStrategy(broker, coinMap,database); // do B
				System.out.println("Trader: "+broker+" used strategy: "+"B");
				break;
			case "Strategy-C":
				Context contextC = new Context(new StratC());
				contextC.executeStrategy(broker, coinMap,database); // do C
				System.out.println("Trader: "+broker+" used strategy: "+"C");
				break;
			case "Strategy-D":
				Context contextD = new Context(new StratD());
				contextD.executeStrategy(broker, coinMap,database); // do D
				System.out.println("Trader: "+broker+" used strategy: "+"D");
				break;
		} // end of switch

	} // end of constructor
	
} // end of file