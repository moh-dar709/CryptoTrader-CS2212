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

	/**
	 * The perform trade constructor takes in three parameters which are all array lists
	 * @param traderList : contains the list of traders
	 * @param coinList : contains the list of coins
	 * @param stratList : contains the list of strategies to be used
	 *
	 */
	public PerformTrade(List<String> traderList, List<String[]> coinList, List<String> stratList) {
		
		this.date = getDate(); // get today's date
		System.out.println(this.date);
		// create broker objects
		/**
		 * a for loop is used to traverse through these three lists simultaneously to extract information for each trader to create a broker object
		 * 	 *  the broker object is inserted into the brokerMap hashMap defined above.
		 */
		for(int b=0;b<traderList.size();b++) {
			
			// get current entry data
			String name = traderList.get(b);
			String[] coinsSelected = coinList.get(b);
			String strat = stratList.get(b);
			
			// create Broker object
			Broker newBroker = new Broker(name, coinsSelected, strat);
			
			// add broker to map
			this.brokerMap.put(Integer.toString(b), newBroker); // this overwrites same key value if it exists already
		}
		
		/**
		 * Next a fetcher object is created to fetch coin data from the api. The coin information for each coin in the coin list for each broker is fetched and sent to the respective broker that the coins belonged to
		 */
		// create fetcher object
		DataFetcher fetcher = new DataFetcher();
		
		// loops through traders, gets data for chosen coins from api, and sends it to the respective broker
		for(int k=0; k<traderList.size(); k++) {
			Broker currBroker = this.brokerMap.get(Integer.toString(k)); // gets current broker
			String[] currBrokerCoinList = currBroker.getCoins(); // gets the current broker's coin list
			HashMap<String,Coin> currCoinMap = new HashMap<String, Coin>(); // makes a temporary coin map
			/**
			 * The coin list is then traversed through using a for loop and a coin object is created using the information fetched from the api
			 */
			// loops through coin list
			for(int i=0; i<currBrokerCoinList.length; i++) {
				// send a call for coin
				String name = currBrokerCoinList[i].toLowerCase();
				double price = fetcher.getPriceForCoin(name, this.date);
				double marketCap = fetcher.getMarketCapForCoin(name, this.date);
				double volume = fetcher.getVolumeForCoin(name, this.date);
				
				// create coin
				Coin currCoin = new Coin(name,price,marketCap,volume);

				/**
				 * each coin object is then added to the coinMap hashMap defined above
				 */
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
			/**
			 * using the information from the coin list and the current coin information the strategy for each broker is calculated
			 */
			// calculate strat
			currBroker.calculateStrat(this.database);
			
		} // end of for brokers
		
	} // end of constructor

	/**
	 * Displays the Action Log table to the UI
	 * @return
	 */
	public ActionLog getDataToVisual() {
		return this.database;
	}

	/**
	 * this method is used to get the current date in order to fetch the most up to date information from the api about each coin
	 * @return : the method returns a string which has the date in the format "dd-MM-YYYY".
	 */
	private String getDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return (formatter.format(date));
	}
	
} // end of file