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
			// If ethereum is over 3300 and litecoin is under 90, sell 15 litecoin.
			case "Broker-2"	:
				Coin eth = coinMap.get("ethereum");
				Coin ltc = coinMap.get("litecoin");

				if ((eth != null) && (ltc != null)) {
					if ((eth.getPrice() > 3300) && (ltc.getPrice() < 90)) {
						successfulTrade(broker, "Strategy-A", "LTC", "Sell", "15", Double.toString(ltc.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-A", "LTC","1-April-2022",database);
					}
				}
				else {
					badInput(broker,"Strategy-A","1-April-2022",database);
				}
				break;


			//TODO Broker-3 Tether
			// if tether is over 1 and terra is under 100, sell 3 terra
			case "Broker=3" :
				Coin usdt = coinMap.get("tether");
				Coin luna = coinMap.get("terra");

				if ((usdt!=null) && (luna!=null)){
					if ((usdt.getPrice() > 1) && (luna.getPrice()<100)){
						successfulTrade(broker, "Strategy-A", "LUNA", "Sell", "3", Double.toString(luna.getPrice()), "1-April-2022", database);
					}
					else{
						failedTrade(broker, "Strategy-A", "LUNA", "1-April-2022", database);
					}
				}
				else{
					badInput(broker, "Strategy-A", "1-April=2022", database);
				}
				break;

			//TODO Broker-4 Dogecoin
			//if dogecoin is over 0.10 and Solana is under 150, buy 5 Solana
			case "Broker-4":
				Coin doge = coinMap.get("dogecoin");
				Coin sol = coinMap.get("solana");
				if((doge!= null) && (sol!= null)){
					if((doge.getPrice()>0.1) && (sol.getPrice() < 150)){
						successfulTrade(broker, "Strategy-A", "SOL", "Buy", "5", Double.toString(sol.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-A", "SOL", "1-April-2022", database);
					}
				}
				else {
					badInput(broker, "Strategy-A", "1-April=2022", database);
				}

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

		switch(broker) {
			//TODO Broker-1 Bitcoin

			//TODO Broker-2 Ethereum
			case "Broker-2"	:
				// If ethereum is under 3300 and solana is over 100, buy 4 solana.
				Coin eth = coinMap.get("ethereum");
				Coin sol = coinMap.get("solana");

				if ((eth != null) && (sol != null)) {
					if ((eth.getPrice() < 3300) && (sol.getPrice() > 100)) {
						successfulTrade(broker, "Strategy-B", "SOL", "Buy", "4", Double.toString(sol.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-B", "SOL","1-April-2022",database);
					}
				}
				else {
					badInput(broker,"Strategy-B","1-April-2022",database);
				}
				break;


			//TODO Broker-3 Tether
			//if tether is under 1 and avalanche is over 7000, buy 6 avalanche
			case "Broker-3" :
				Coin usdt = coinMap.get("tether");
				Coin avax = coinMap.get("avalanche");

				if ((usdt != null) && (avax != null)) {
					if ((usdt.getPrice() < 1) && (avax.getPrice() > 7000)) {
						successfulTrade(broker, "Strategy-B", "AVAX", "Buy", "6", Double.toString(avax.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-B", "AVAX","1-April-2022", database );
					}
				}
				else {
					badInput(broker, "Strategy-B", "1-April-2022", database);
				}
				break;



			//TODO Broker-4 Dogecoin
			//if dogecoin under 0.2 and bitcoin is over 55000, sell 1 bitcoin
			case "Broker-4":
				Coin doge = coinMap.get("dogecoin");
				Coin btc = coinMap.get("bitcoin");
				if((doge!= null) && (btc!= null)){
					if((doge.getPrice()<0.2) && (btc.getPrice() > 55000)){
						successfulTrade(broker, "Strategy-B", "BTC", "Sell", "1", Double.toString(btc.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-B", "BTC", "1-April-2022", database);
					}
				}
				else {
					badInput(broker, "Strategy-B", "1-April=2022", database);
				}
		}
		return true;// dummy
	} // end of stratB

	private boolean stratC(String broker, HashMap<String, Coin> coinMap, ActionLog database) {

		switch (broker) {
			//TODO Broker-1 Bitcoin

			//TODO Broker-2 Ethereum
			case "Broker-2"	:
				// If ethereum is under 4500 and polkadot is over 20, buy 10 polkadot.
				Coin eth = coinMap.get("ethereum");
				Coin dot = coinMap.get("polkadot");

				if ((eth != null) && (dot != null)) {
					if ((eth.getPrice() < 4500) && (dot.getPrice() > 20)) {
						successfulTrade(broker, "Strategy-C", "DOT", "Buy", "4", Double.toString(dot.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-C", "DOT","1-April-2022",database);
					}
				}
				else {
					badInput(broker,"Strategy-C","1-April-2022",database);
				}
				break;

			//TODO Broker-3 Tether

			case "Broker-3" :
				// if tether is under 2 and EOS is over 3, buy 10 EOS
				Coin usdt = coinMap.get("tether");
				Coin eos = coinMap.get("eos");

				if ((usdt != null) && (eos != null)) {
					if ((usdt.getPrice() < 2) && (eos.getPrice() > 3)) {
						successfulTrade(broker, "Strategy-C", "EOS", "Buy", "10", Double.toString(eos.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-C", "EOS","1-April-2022",database);
					}
				}
				else {
					badInput(broker,"Strategy-C","1-April-2022",database);
				}
				break;


			//TODO Broker-4 Dogecoin
			//if dogecoin is over 0.15 and cronos is above 0.4, buy 27 cronos
			case "Broker-4":
				Coin doge = coinMap.get("dogecoin");
				Coin cro = coinMap.get("cronos");
				if((doge!= null) && (cro!= null)){
					if((doge.getPrice()>0.1) && (cro.getPrice() < 150)){
						successfulTrade(broker, "Strategy-C", "CRO", "Buy", "27", Double.toString(cro.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-C", "CRO", "1-April-2022", database);
					}
				}
				else {
					badInput(broker, "Strategy-C", "1-April=2022", database);
				}
		}

		return true;// dummy
	}

	private boolean stratD(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		switch(broker) {

			//TODO Broker-1 Bitcoin

			//TODO Broker-2 Ethereum
			case "Broker-2"	:
				// If ethereum is over 3000 and EOS is under 3, sell 15 EOS.
				Coin eth = coinMap.get("ethereum");
				Coin eos = coinMap.get("eos");

				if ((eth != null) && (eos != null)) {
					if ((eth.getPrice() > 3000) && (eos.getPrice() < 3)) {
						successfulTrade(broker, "Strategy-D", "EOS", "Sell", "15", Double.toString(eos.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-D", "EOS","1-April-2022",database);
					}
				}
				else {
					badInput(broker,"Strategy-D","1-April-2022",database);
				}
				break;

			//TODO Broker-3 Tether
			case "Broker-3" :
				//if tether is over 3 and polkadot is under 20, sell 3 polkadot
				Coin usdt = coinMap.get("tether");
				Coin dot = coinMap.get("polkadot");

				if ((usdt != null) && (dot != null)) {
					if ((usdt.getPrice() > 3) && (dot.getPrice() < 20)) {
						successfulTrade(broker, "Strategy-D", "DOT", "Sell", "3", Double.toString(dot.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-D", "DOT","1-April-2022",database);
					}
				}
				else {
					badInput(broker,"Strategy-D","1-April-2022",database);
				}
				break;

			//TODO Broker-4 Dogecoin
			//if Dogecoin is above 0.12 and terrausd is over 1, sell 10 terrausd
			case "Broker-4":
				Coin doge = coinMap.get("dogecoin");
				Coin ust = coinMap.get("terrausd");
				if((doge!= null) && (ust!= null)){
					if((doge.getPrice()>0.1) && (ust.getPrice() < 150)){
						successfulTrade(broker, "Strategy-D", "UST", "Sell", "10", Double.toString(ust.getPrice()), "1-April-2022", database);
					}
					else {
						failedTrade(broker, "Strategy-D", "UST", "1-April-2022", database);
					}
				}
				else {
					badInput(broker, "Strategy-D", "1-April=2022", database);
				}

		}

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


}


// end of file