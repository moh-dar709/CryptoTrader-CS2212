package cryptoTrader.gui;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class StratA implements Strategy{

	@Override
	public void doStrat(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		// switch to select broker
				switch(broker) {
					case "Broker-1":
						// if bitcoin is under 50000 and cardano is over 2, buy 10 cardano
						// get coins
						Coin btc = coinMap.get("bitcoin");
						Coin ada = coinMap.get("cardano");
						// do calculations
						if(btc != null && ada != null) {
							if((btc.getPrice() <= 50000) && (ada.getPrice() > 2)) {
								successfulTrade(broker, "Strategy-A", "ADA", "Buy", "10", truncate(ada.getPrice()), getDate(), database);
							}
							else {
								failedTrade(broker, "Strategy-A", "ADA",getDate(),database);
							}
						}
						else {
							badInput(broker,"Strategy-A",getDate(),database);
						}
						break;

					case "Broker-2"	:
						// If ethereum is over 3300 and litecoin is under 90, sell 15 litecoin.
						Coin eth = coinMap.get("ethereum");
						Coin ltc = coinMap.get("litecoin");
						
						if ((eth != null) && (ltc != null)) {
							if ((eth.getPrice() > 3300) && (ltc.getPrice() < 90)) {
								successfulTrade(broker, "Strategy-A", "LTC", "Sell", "15", truncate(ltc.getPrice()), getDate(), database);
							}
							else {
								failedTrade(broker, "Strategy-A", "LTC",getDate(),database);
							}
						}
						else {
							badInput(broker,"Strategy-A",getDate(),database);
						}
						break;


					case "Broker-3" :
						// if tether is over 1 and terra is under 100, sell 3 terra
						Coin tether = coinMap.get("tether");
						Coin terra = coinMap.get("terrausd");

						if ((tether!=null) && (terra!=null)){
							if ((tether.getPrice() > 1) && (terra.getPrice()<100)){
								successfulTrade(broker, "Strategy-A", "Terra", "Sell", "3", truncate(terra.getPrice()), getDate(), database);
							}
							else{
								failedTrade(broker, "Strategy-A", "Terra", getDate(), database);
							}
						}
						else{
							badInput(broker, "Strategy-A", getDate(), database);
						}
						break;


					case "Broker-4":
						//if dogecoin is over 0.10 and Solana is under 150, buy 5 Solana
						Coin doge = coinMap.get("dogecoin");
						Coin sol = coinMap.get("solana");
						if((doge!= null) && (sol!= null)){
							if((doge.getPrice()>0.1) && (sol.getPrice() < 150)){
								successfulTrade(broker, "Strategy-A", "SOL", "Buy", "5", truncate(sol.getPrice()), getDate(), database);
							}
							else {
								failedTrade(broker, "Strategy-A", "SOL", getDate(), database);
							}
						}
						else {
							badInput(broker, "Strategy-A", getDate(), database);
						}

				} // end of switch
		
	} // end of do
	
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
	
	/**
	 * This method gets today's date
	 * @return a string of today's date
	 */
	private String getDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return (formatter.format(date));
	}

} // end of file