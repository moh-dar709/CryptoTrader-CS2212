package cryptoTrader.gui;

import java.util.HashMap;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StratD implements Strategy{

	@Override
	public void doStrat(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		
		switch(broker) {
		case "Broker-1" :
			// If bitcoin is over 59000 and cardano is under 3, sell 15 cardano.
			Coin btc = coinMap.get("bitcoin");
			Coin ada = coinMap.get("cardano");

			if ((btc != null) && (ada != null)) {
				if ((btc.getPrice() > 59000) && (ada.getPrice() < 3)) {
					successfulTrade(broker, "Strategy-D", "ADA", "Sell", "15", truncate(ada.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-D", "ADA",getDate(),database);
				}
			}
			else {
				badInput(broker,"Strategy-D",getDate(),database);
			}
			break;


		case "Broker-2"	:
			// If ethereum is over 3000 and EOS is under 3, sell 15 EOS.
			Coin eth = coinMap.get("ethereum");
			Coin eos = coinMap.get("eos");

			if ((eth != null) && (eos != null)) {
				if ((eth.getPrice() > 3000) && (eos.getPrice() < 3)) {
					successfulTrade(broker, "Strategy-D", "EOS", "Sell", "15",truncate(eos.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-D", "EOS",getDate(),database);
				}
			}
			else {
				badInput(broker,"Strategy-D",getDate(),database);
			}
			break;


		case "Broker-3" :
			//if tether is over 3 and polkadot is under 20, sell 3 polkadot
			Coin usdt = coinMap.get("tether");
			Coin dot = coinMap.get("polkadot");

			if ((usdt != null) && (dot != null)) {
				if ((usdt.getPrice() > 3) && (dot.getPrice() < 20)) {
					successfulTrade(broker, "Strategy-D", "DOT", "Sell", "3", truncate(dot.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-D", "DOT",getDate(),database);
				}
			}
			else {
				badInput(broker,"Strategy-D",getDate(),database);
			}
			break;


		case "Broker-4":
			//if Dogecoin is above 0.12 and terrausd is over 1, sell 10 terrausd
			Coin doge = coinMap.get("dogecoin");
			Coin ust = coinMap.get("terrausd");
			if((doge!= null) && (ust!= null)){
				if((doge.getPrice()>0.1) && (ust.getPrice() < 150)){
					successfulTrade(broker, "Strategy-D", "UST", "Sell", "10", truncate(ust.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-D", "UST", getDate(), database);
				}
			}
			else {
				badInput(broker, "Strategy-D", getDate(), database);
			}
		}
		
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