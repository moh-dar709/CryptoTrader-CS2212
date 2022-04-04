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
		
		this.date = getDate(); // set date
		
		// switch to determine which strategy is requested
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
		} // end of switch

	} // end of constructor
	
	/**
	 * This method is responsible for all Strategy-A broker algorithms.
	 * 
	 * @param broker represents the broker name
	 * @param coinMap represents the map of coins associated with the broker
	 * @param database represents the action log database where the action will be logged
	 */
	private void stratA(String broker, HashMap<String, Coin> coinMap, ActionLog database) {

		// switch to select broker
		switch(broker) {
			//TODO Broker-1 Bitcoin
			// if bitcoin is under 50000 and cardano is over 2, buy 10 cardano
			case "Broker-1":
				// get coins
				Coin btc = coinMap.get("bitcoin");
				Coin ada = coinMap.get("cardano");
				// do calculations
				if(btc != null && ada != null) {
					if((btc.getPrice() <= 50000) && (ada.getPrice() > 2)) {
						successfulTrade(broker, "Strategy-A", "ADA", "Buy", "10", truncate(ada.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-A", "ADA",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-A",this.date,database);
				}
				break;

			//TODO Broker-2 Ethereum
			// If ethereum is over 3300 and litecoin is under 90, sell 15 litecoin.
			case "Broker-2"	:
				Coin eth = coinMap.get("ethereum");
				Coin ltc = coinMap.get("litecoin");
				
				if ((eth != null) && (ltc != null)) {
					if ((eth.getPrice() > 3300) && (ltc.getPrice() < 90)) {
						successfulTrade(broker, "Strategy-A", "LTC", "Sell", "15", truncate(ltc.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-A", "LTC",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-A",this.date,database);
				}
				break;

			//TODO Broker-3 Tether 
			// if tether is over 1 and terra is under 100, sell 3 terra
			case "Broker-3" :
				Coin tether = coinMap.get("tether");
				Coin terra = coinMap.get("terrausd");

				if ((tether!=null) && (terra!=null)){
					if ((tether.getPrice() > 1) && (terra.getPrice()<100)){
						successfulTrade(broker, "Strategy-A", "Terra", "Sell", "3", truncate(terra.getPrice()), this.date, database);
					}
					else{
						failedTrade(broker, "Strategy-A", "Terra", this.date, database);
					}
				}
				else{
					badInput(broker, "Strategy-A", this.date, database);
				}
				break;

			//TODO Broker-4 Dogecoin
			//if dogecoin is over 0.10 and Solana is under 150, buy 5 Solana
			case "Broker-4":
				Coin doge = coinMap.get("dogecoin");
				Coin sol = coinMap.get("solana");
				if((doge!= null) && (sol!= null)){
					if((doge.getPrice()>0.1) && (sol.getPrice() < 150)){
						successfulTrade(broker, "Strategy-A", "SOL", "Buy", "5", truncate(sol.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-A", "SOL", this.date, database);
					}
				}
				else {
					badInput(broker, "Strategy-A", this.date, database);
				}

		} // end of switch
	} // end of stratA

	/**
	 * This method is responsible for all Strategy-B broker algorithms.
	 * 
	 * @param broker represents the broker name
	 * @param coinMap represents the map of coins associated with the broker
	 * @param database represents the action log database where the action will be logged
	 */
	private void stratB(String broker, HashMap<String, Coin> coinMap, ActionLog database) {

		switch(broker) {
			//TODO Broker-1 Bitcoin
			case "Broker-1" :
				//if bitcoin is under 59200 and polkadot is over 25, buy 6 polkadot
				Coin btc = coinMap.get("bitcoin");
				Coin dot = coinMap.get("polkadot");

				if ((btc != null) && (dot != null)) {
					if ((btc.getPrice() < 59200) && (dot.getPrice() > 25)) {
						successfulTrade(broker, "Strategy-B", "DOT", "Buy", "6", truncate(dot.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-B", "DOT",this.date, database );
					}
				}
				else {
					badInput(broker, "Strategy-B", this.date, database);
				}
				break;

			//TODO Broker-2 Ethereum
			case "Broker-2"	:
				// If ethereum is under 3300 and solana is over 100, buy 4 solana.
				Coin eth = coinMap.get("ethereum");
				Coin sol = coinMap.get("solana");

				if ((eth != null) && (sol != null)) {
					if ((eth.getPrice() < 3300) && (sol.getPrice() > 100)) {
						successfulTrade(broker, "Strategy-B", "SOL", "Buy", "4", truncate(sol.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-B", "SOL",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-B",this.date,database);
				}
				break;

			//TODO Broker-3 Tether
			//if tether is under 1 and avalanche is over 7000, buy 6 avalanche
			case "Broker-3" :
				Coin usdt = coinMap.get("tether");
				Coin avax = coinMap.get("avalanche");

				if ((usdt != null) && (avax != null)) {
					if ((usdt.getPrice() < 1) && (avax.getPrice() > 7000)) {
						successfulTrade(broker, "Strategy-B", "AVAX", "Buy", "6", truncate(avax.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-B", "AVAX",this.date, database );
					}
				}
				else {
					badInput(broker, "Strategy-B", this.date, database);
				}
				break;

			//TODO Broker-4 Dogecoin
			//if dogecoin under 0.2 and bitcoin is over 55000, sell 1 bitcoin
			case "Broker-4":
				Coin doge = coinMap.get("dogecoin");
				btc = coinMap.get("bitcoin");
				if((doge!= null) && (btc!= null)){
					if((doge.getPrice()<0.2) && (btc.getPrice() > 55000)){
						successfulTrade(broker, "Strategy-B", "BTC", "Sell", "1", truncate(btc.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-B", "BTC", this.date, database);
					}
				}
				else {
					badInput(broker, "Strategy-B", this.date, database);
				}
		}
	} // end of stratB

	/**
	 * This method is responsible for all Strategy-C broker algorithms.
	 * 
	 * @param broker represents the broker name
	 * @param coinMap represents the map of coins associated with the broker
	 * @param database represents the action log database where the action will be logged
	 */
	private void stratC(String broker, HashMap<String, Coin> coinMap, ActionLog database) {

		switch (broker) {
			//TODO Broker-1 Bitcoin
			// If Bitcoin is under 59400 and solana is over 130, buy 5 solana.
			case "Broker-1" :
				Coin btc = coinMap.get("bitcoin");
				Coin sol = coinMap.get("solana");

				if ((btc != null) && (sol != null)) {
					if ((btc.getPrice() < 59400) && (sol.getPrice() > 130)) {
						successfulTrade(broker, "Strategy-C", "SOL", "Buy", "5", truncate(sol.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-C", "SOL",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-C",this.date,database);
				}
				break;

			//TODO Broker-2 Ethereum
			case "Broker-2"	:
				// If ethereum is under 4500 and polkadot is over 20, buy 10 polkadot.
				Coin eth = coinMap.get("ethereum");
				Coin dot = coinMap.get("polkadot");

				if ((eth != null) && (dot != null)) {
					if ((eth.getPrice() < 4500) && (dot.getPrice() > 20)) {
						successfulTrade(broker, "Strategy-C", "DOT", "Buy", "4", truncate(dot.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-C", "DOT",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-C",this.date,database);
				}
				break;

			//TODO Broker-3 Tether
			case "Broker-3" :
				// if tether is under 2 and EOS is over 3, buy 10 EOS
				Coin usdt = coinMap.get("tether");
				Coin eos = coinMap.get("eos");

				if ((usdt != null) && (eos != null)) {
					if ((usdt.getPrice() < 2) && (eos.getPrice() > 3)) {
						successfulTrade(broker, "Strategy-C", "EOS", "Buy", "10", truncate(eos.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-C", "EOS",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-C",this.date,database);
				}
				break;

			//TODO Broker-4 Dogecoin
			//if dogecoin is over 0.15 and cardano is above 1.2, buy 27 cardano
			case "Broker-4":
				Coin doge = coinMap.get("dogecoin");
				Coin ada = coinMap.get("cardano");
				if((doge!= null) && (ada!= null)){
					if((doge.getPrice()>0.1) && (ada.getPrice() < 150)){
						successfulTrade(broker, "Strategy-C", "ADA", "Buy", "27", truncate(ada.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-C", "ADA", this.date, database);
					}
				}
				else {
					badInput(broker, "Strategy-C", this.date, database);
				}
		}
	} // end of strat C

	/**
	 * This method is responsible for all Strategy-D broker algorithms.
	 * 
	 * @param broker represents the broker name
	 * @param coinMap represents the map of coins associated with the broker
	 * @param database represents the action log database where the action will be logged
	 */
	private void stratD(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		switch(broker) {
			//TODO Broker-1 Bitcoin
			case "Broker-1" :
				// If bitcoin is over 59000 and cardano is under 3, sell 15 cardano.
				Coin btc = coinMap.get("bitcoin");
				Coin ada = coinMap.get("cardano");

				if ((btc != null) && (ada != null)) {
					if ((btc.getPrice() > 59000) && (ada.getPrice() < 3)) {
						successfulTrade(broker, "Strategy-D", "ADA", "Sell", "15", truncate(ada.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-D", "ADA",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-D",this.date,database);
				}
				break;

			//TODO Broker-2 Ethereum
			case "Broker-2"	:
				// If ethereum is over 3000 and EOS is under 3, sell 15 EOS.
				Coin eth = coinMap.get("ethereum");
				Coin eos = coinMap.get("eos");

				if ((eth != null) && (eos != null)) {
					if ((eth.getPrice() > 3000) && (eos.getPrice() < 3)) {
						successfulTrade(broker, "Strategy-D", "EOS", "Sell", "15",truncate(eos.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-D", "EOS",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-D",this.date,database);
				}
				break;

			//TODO Broker-3 Tether
			case "Broker-3" :
				//if tether is over 3 and polkadot is under 20, sell 3 polkadot
				Coin usdt = coinMap.get("tether");
				Coin dot = coinMap.get("polkadot");

				if ((usdt != null) && (dot != null)) {
					if ((usdt.getPrice() > 3) && (dot.getPrice() < 20)) {
						successfulTrade(broker, "Strategy-D", "DOT", "Sell", "3", truncate(dot.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-D", "DOT",this.date,database);
					}
				}
				else {
					badInput(broker,"Strategy-D",this.date,database);
				}
				break;

			//TODO Broker-4 Dogecoin
			//if Dogecoin is above 0.12 and terrausd is over 1, sell 10 terrausd
			case "Broker-4":
				Coin doge = coinMap.get("dogecoin");
				Coin ust = coinMap.get("terrausd");
				if((doge!= null) && (ust!= null)){
					if((doge.getPrice()>0.1) && (ust.getPrice() < 150)){
						successfulTrade(broker, "Strategy-D", "UST", "Sell", "10", truncate(ust.getPrice()), this.date, database);
					}
					else {
						failedTrade(broker, "Strategy-D", "UST", this.date, database);
					}
				}
				else {
					badInput(broker, "Strategy-D", this.date, database);
				}
		}
	} // end of strat D

	/**
	 * This method creates a successful trade action and adds it to the action log database 
	 * 
	 * @param broker represents the broker name
	 * @param strat represents the selected strategy
	 * @param coin represents the selected coin
	 * @param action represents the selected action
	 * @param amount represents the selected amount
	 * @param price represents the selected price
	 * @param date represents the trade date
	 * @param database represents the action log database
	 */
	private void successfulTrade(String broker, String strat, String coin, String action, String amount, String price,String date,ActionLog database) {
		TradeAction act = new TradeAction(broker, strat, coin, action, amount, price,date);
		int index = database.size();
		database.addActionLog(Integer.toString(index), act);
		System.out.println("----------performed successfully----------");
	}

	/**
	 * This method creates a failed trade and adds it to the action log database
	 * 
	 * @param broker represents the broker name
	 * @param strat represents the selected strategy
	 * @param coin represents the selected coin
	 * @param date represents the trade date
	 * @param database represents the action log database
	 */
	private void failedTrade(String broker, String strat, String coin,String date,ActionLog database) {
		TradeAction act = new TradeAction(broker, strat, coin, "Fail", "Null", "Null",date);
		int index = database.size();
		database.addActionLog(Integer.toString(index), act);
		System.out.println("----------failed successfully----------");
	}

	/**
	 * This method creates a failed trade due to bad input and adds it to the action log database
	 * 
	 * @param broker represents the broker name
	 * @param strat represents the selected strategy
	 * @param date represents the trade date 
	 * @param database represents the action log database
	 */
	private void badInput(String broker, String strat,String date,ActionLog database) {
		TradeAction act = new TradeAction(broker, strat, "Null", "Fail", "Null", "Null",date);
		int index = database.size();
		database.addActionLog(Integer.toString(index), act);
		System.out.println("----------failed successfully (Bad Input)----------");
	}

	/**
	 * This method truncates the price to 5 decimal places
	 * 
	 * @param price as a double with many digits after the decimal 
	 * @return price as a string truncated to 5 decimal places
	 */
	private String truncate(Double price) {
		return new DecimalFormat("#.#####").format(price);
	}
	
	private String getDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return (formatter.format(date));
	}

} // end of file