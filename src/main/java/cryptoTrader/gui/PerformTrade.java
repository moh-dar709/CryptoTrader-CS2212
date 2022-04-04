package cryptoTrader.gui;

import java.text.SimpleDateFormat;
import java.util.*;

import cryptoTrader.utils.DataFetcher;

public class PerformTrade {

	// instance variables
	private HashMap<String, Broker> brokerMap = new HashMap<String, Broker>();
	private ActionLog database = new ActionLog();
	private String date;
	
	// constructor
	public PerformTrade(List<String> traderList, List<String[]> coinList, List<String> stratList) {
		
		this.date = getDate(); // get today's date
		System.out.println(this.date);
		// create broker objects
		for(int b=0;b<traderList.size();b++) {
			
			// get current entry data
			String name = traderList.get(b);
			String[] coinsSelected = coinList.get(b);
			String strat = stratList.get(b);
			
			// create Broker object
			Broker newBroker = new Broker(name, coinsSelected, strat);
			
			// add broker to map
			this.brokerMap.put(name, newBroker); // this overwrites same key value if it exists already
		}
		
		// call api and fetch data and store in data structure 
		
		// create fetcher object
		DataFetcher fetcher = new DataFetcher();
		
		// loops through traders, gets data for chosen coins from api, and sends it to the respective broker
		for(int k=0; k<traderList.size(); k++) {
			Broker currBroker = this.brokerMap.get(traderList.get(k)); // gets current broker
			String[] currBrokerCoinList = currBroker.getCoins(); // gets the current broker's coin list
			HashMap<String,Coin> currCoinMap = new HashMap<String, Coin>(); // makes a temporary coin map
			
			// loops through coin list
			for(int i=0; i<currBrokerCoinList.length; i++) {
				// send a call for coin
				String name = currBrokerCoinList[i].toLowerCase();
				double price = fetcher.getPriceForCoin(name, this.date);
				double marketCap = fetcher.getMarketCapForCoin(name, this.date);
				double volume = fetcher.getVolumeForCoin(name, this.date);
				
				// create coin
				Coin currCoin = new Coin(name,price,marketCap,volume);
				// add coin to temp coin map
				currCoinMap.put(name, currCoin);
				
				//-----------------------test code for fetched data-----------------------------
				System.out.println(currBrokerCoinList[i].toLowerCase()+"=>\tPrice: " + price + 
						"\n\t\tMarket Cap: " + marketCap + 
						"\n\t\tVolume: "+ volume);
				//------------------------------------------------------------------------------
			} // end of for coins
			
			// send data to broker
			currBroker.setCoinMap(currCoinMap);
			
			// calculate strat
			currBroker.calculateStrat(this.database);
			
		} // end of for brokers
		
	} // end of constructor
	
	public ActionLog getDataToVisual() {
		return this.database;
	}
	
	private String getDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return (formatter.format(date));
	}
	
} // end of file