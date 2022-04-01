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
			  stratC(broker, coinMap,database); // do C
			  System.out.println("Trader: "+broker+" used strategy: "+"C"); //TODO remove
		      break;
		  case "Strategy-D":
			  stratD(broker, coinMap,database); // do D
		      System.out.println("Trader: "+broker+" used strategy: "+"D"); //TODO remove
		      break;
		  case "None":
			  stratN(broker, coinMap,database); // do N
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
//		TradeAction act = new TradeAction("Trader-1", "Strategy-A", "ETH", "Buy", "500", "150.3","1-April-2022");
//		int index = database.size();
//		database.addActionLog(Integer.toString(index), act);
		
//		TradeAction tst = database.getActionLog(Integer.toString(index));
//		System.out.println("-----------"+tst.getTrader());
//		logCount++;
		
		// implement if or switch to select broker
		switch(broker) {
		//TODO Broker-1 Bitcoin
		case "Broker-1":
			// get coins
			Coin btc = coinMap.get("bitcoin");
			Coin ada = coinMap.get("cardano");
			// do calculations
			if(btc != null && ada != null) {
				if((btc.getPrice() <= 50000) && (ada.getPrice() > 2)) {
					successfulTrade(broker, "Strategy-A", "ADA", "Buy", "10", Double.toString(ada.getPrice()), "1-April-2022", database);
				}
				else {
					failedTrade(broker, "Strategy-A", "ADA","1-April-2022",database);
				}
			}
			else {
				badInput(broker,"Strategy-A","1-April-2022",database);
			}
			break;
		//TODO Broker-2 Ethereum
		
		//TODO Broker-3 Tether
		
		//TODO Broker-4 BNB
			
		} // end of switch
		
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
	
	private boolean stratC(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		//TODO Broker-1 Bitcoin
		
		//TODO Broker-2 Ethereum
		
		//TODO Broker-3 Tether
		
		//TODO Broker-4 BNB
		
		
		return true;// dummy
	}
	
	private boolean stratD(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		//TODO Broker-1 Bitcoin
		
		//TODO Broker-2 Ethereum
		
		//TODO Broker-3 Tether
		
		//TODO Broker-4 BNB
		
		
		return true;// dummy
	}
	
	private boolean stratN(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		//TODO no strat selected
		
		
		return true;// dummy
	}
	
	private void successfulTrade(String broker, String Strat, String coin, String action, String amount, String price,String date,ActionLog database) {
		TradeAction act = new TradeAction(broker, Strat, coin, action, amount, price,date);
		int index = database.size();
		database.addActionLog(Integer.toString(index), act);
		System.out.println("----------performed successfully----------");
	}
	
	private void failedTrade(String broker, String strat, String coin,String date,ActionLog database) {
		TradeAction act = new TradeAction(broker, strat, coin, "Fail", "Null", "Null",date);
		int index = database.size();
		database.addActionLog(Integer.toString(index), act);
		System.out.println("----------failed successfully----------");
	}
	
	private void badInput(String broker, String strat,String date,ActionLog database) {
		TradeAction act = new TradeAction(broker, strat, "Null", "Fail", "Null", "Null",date);
		int index = database.size();
		database.addActionLog(Integer.toString(index), act);
		System.out.println("----------failed successfully (BI)----------");
	}
	
	
} // end of file