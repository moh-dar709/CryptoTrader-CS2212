package cryptoTrader.gui;

import java.util.HashMap;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StratB implements Strategy{

	@Override
	public void doStrat(String broker, HashMap<String, Coin> coinMap, ActionLog database) {
		switch(broker) {
		case "Broker-1" :
			//if bitcoin is under 59200 and polkadot is over 25, buy 6 polkadot
			Coin btc = coinMap.get("bitcoin");
			Coin dot = coinMap.get("polkadot");

			if ((btc != null) && (dot != null)) {
				if ((btc.getPrice() < 59200) && (dot.getPrice() > 25)) {
					successfulTrade(broker, "Strategy-B", "DOT", "Buy", "6", truncate(dot.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-B", "DOT",getDate(), database );
				}
			}
			else {
				badInput(broker, "Strategy-B", getDate(), database);
			}
			break;

		case "Broker-2"	:
			// If ethereum is under 3300 and solana is over 100, buy 4 solana.
			Coin eth = coinMap.get("ethereum");
			Coin sol = coinMap.get("solana");

			if ((eth != null) && (sol != null)) {
				if ((eth.getPrice() < 3300) && (sol.getPrice() > 100)) {
					successfulTrade(broker, "Strategy-B", "SOL", "Buy", "4", truncate(sol.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-B", "SOL",getDate(),database);
				}
			}
			else {
				badInput(broker,"Strategy-B",getDate(),database);
			}
			break;

		case "Broker-3" :
			//if tether is over 1 and dogecoin is under 2, buy 69 dogecoin
			Coin tether = coinMap.get("tether");
			Coin dogecoin = coinMap.get("dogecoin");

			if ((tether != null) && (dogecoin != null)) {
				if ((tether.getPrice() > 1) && (dogecoin.getPrice() < 0.2)) {
					successfulTrade(broker, "Strategy-B", "DOGE", "Buy", "69", truncate(dogecoin.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-B", "DOGE",getDate(), database );
				}
			}
			else {
				badInput(broker, "Strategy-B", getDate(), database);
			}
			break;


		case "Broker-4":
			//if dogecoin under 0.2 and bitcoin is over 55000, sell 1 bitcoin
			Coin doge = coinMap.get("dogecoin");
			btc = coinMap.get("bitcoin");
			if((doge!= null) && (btc!= null)){
				if((doge.getPrice()<0.2) && (btc.getPrice() > 55000)){
					successfulTrade(broker, "Strategy-B", "BTC", "Sell", "1", truncate(btc.getPrice()), getDate(), database);
				}
				else {
					failedTrade(broker, "Strategy-B", "BTC", getDate(), database);
				}
			}
			else {
				badInput(broker, "Strategy-B", getDate(), database);
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