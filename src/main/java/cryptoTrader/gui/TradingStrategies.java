package cryptoTrader.gui;

import java.util.*;

public class TradingStrategies {
	
	// instance variables
//	ActionLog database = new ActionLog();
//	int logCount = 0;
	
	// constructor
	public TradingStrategies(String broker, String strat, HashMap<String, Coin> coinMap, ActionLog database) {
		// commence trade
		
		// switch to determine which strat
		switch (strat) {
		  case "Strategy-A":
			  stratA(broker, coinMap, database); // do A
		      System.out.println("Trader: "+broker+" used strategy: "+"A"); //TODO remove
		      break;
		  case "Strategy-B":
			  stratB(broker, coinMap,database); // do B
		      System.out.println("Trader: "+broker+" used strategy: "+"B"); //TODO remove
		      break;
		  case "Strategy-C":
			  stratC(broker, coinMap); // do C
			  System.out.println("Trader: "+broker+" used strategy: "+"C"); //TODO remove
		      break;
		  case "Strategy-D":
			  stratD(broker, coinMap); // do D
		      System.out.println("Trader: "+broker+" used strategy: "+"D"); //TODO remove
		      break;
		  case "None":
			  stratN(broker, coinMap); // do N
			  System.out.println("Trader: "+broker+" used strategy: "+"N"); //TODO remove
			  break;
		} // end of switch
		
	} // end of constructor
	
	// getter method to get the corresponding strat for a certain broker
	  // switch to get appropriate strat for desired broker
	//TODO process the coin map somewhere	
	
	//Broker strats below
	private boolean stratA(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		System.out.println("im in A");
		TradeAction act = new TradeAction("Trader-1", "Strategy-A", "ETH", "Buy", "500", "150.3","1-April-2022");
		int index = database.size();
		database.addActionLog(Integer.toString(index), act);
		
		TradeAction tst = database.getActionLog(Integer.toString(index));
		System.out.println("-----------"+tst.getTrader());
//		logCount++;
		// implement if or switch to select broker
		//TODO Broker-1 Bitcoin
		
		//TODO Broker-2 Ethereum
		
		//TODO Broker-3 Tether
		
		//TODO Broker-4 BNB
		
		return true;// dummy
	} // end of stratA
	
	private boolean stratB(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		System.out.println("im in B");
		TradeAction act = new TradeAction("Trader-2", "Strategy-B", "ETH", "Buy", "500", "150.3","1-April-2022");
		int index = database.size();
		database.addActionLog(Integer.toString(index), act);
		
		TradeAction tst = database.getActionLog(Integer.toString(index));
		System.out.println("-----------"+tst.getTrader());
		
		//TODO Broker-1 Bitcoin
		
		//TODO Broker-2 Ethereum
		
		//TODO Broker-3 Tether
		
		//TODO Broker-4 BNB
		
		
		return true;// dummy
	} // end of stratB
	
	private boolean stratC(String broker, HashMap<String, Coin> coinMap) {
		//TODO Broker-1 Bitcoin
		
		//TODO Broker-2 Ethereum
		
		//TODO Broker-3 Tether
		
		//TODO Broker-4 BNB
		
		
		return true;// dummy
	}
	
	private boolean stratD(String broker, HashMap<String, Coin> coinMap) {
		//TODO Broker-1 Bitcoin
		
		//TODO Broker-2 Ethereum
		
		//TODO Broker-3 Tether
		
		//TODO Broker-4 BNB
		
		
		return true;// dummy
	}
	
	private boolean stratN(String broker, HashMap<String, Coin> coinMap) {
		//TODO no strat selected
		
		
		return true;// dummy
	}
	
	
} // end of file