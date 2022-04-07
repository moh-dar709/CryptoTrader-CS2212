package cryptoTrader.gui;

import java.util.HashMap;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StratC implements Strategy{

	@Override
	public void doStrat(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		
		switch (broker) {
		case "Broker-1" :
			// If Bitcoin is under 59400 and solana is over 130, buy 5 solana.
			Coin btc = coinMap.get("bitcoin");
			Coin sol = coinMap.get("solana");

			if ((btc != null) && (sol != null)) {
				if ((btc.getPrice() < 59400) && (sol.getPrice() > 130)) {
					successfulTrade(broker, "Strategy-C", "SOL", "Buy", "5", truncate(sol.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-C", "SOL",getDate(),database);
				}
			}
			else {
				badInput(broker,"Strategy-C",getDate(),database);
			}
			break;


		case "Broker-2"	:
			// If ethereum is under 4500 and polkadot is over 20, buy 10 polkadot.
			Coin eth = coinMap.get("ethereum");
			Coin dot = coinMap.get("polkadot");

			if ((eth != null) && (dot != null)) {
				if ((eth.getPrice() < 4500) && (dot.getPrice() > 20)) {
					successfulTrade(broker, "Strategy-C", "DOT", "Buy", "4", truncate(dot.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-C", "DOT",getDate(),database);
				}
			}
			else {
				badInput(broker,"Strategy-C",getDate(),database);
			}
			break;


		case "Broker-3" :
			// if tether is under 2 and EOS is over 3, buy 10 EOS
			Coin usdt = coinMap.get("tether");
			Coin eos = coinMap.get("eos");

			if ((usdt != null) && (eos != null)) {
				if ((usdt.getPrice() < 2) && (eos.getPrice() > 3)) {
					successfulTrade(broker, "Strategy-C", "EOS", "Buy", "10", truncate(eos.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-C", "EOS",getDate(),database);
				}
			}
			else {
				badInput(broker,"Strategy-C",getDate(),database);
			}
			break;


		case "Broker-4":
			//if dogecoin is over 0.15 and cardano is above 1.2, buy 27 cardano
			Coin doge = coinMap.get("dogecoin");
			Coin ada = coinMap.get("cardano");
			if((doge!= null) && (ada!= null)){
				if((doge.getPrice()>0.1) && (ada.getPrice() < 150)){
					successfulTrade(broker, "Strategy-C", "ADA", "Buy", "27", truncate(ada.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-C", "ADA", getDate(), database);
				}
			}
			else {
				badInput(broker, "Strategy-C", getDate(), database);
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
	private void badInput(String broker,String strat,String date,ActionLog database) {
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