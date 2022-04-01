package cryptoTrader.gui;

import java.util.List;

import cryptoTrader.utils.DataFetcher;

public class PerformTrade {

	// constructor
	public PerformTrade(List<String> traderList, List<String[]> coinList, List<String> stratList) {
		
		// testing arraylist
//		for(int i=0;i<traderList.size();i++) {
//			System.out.println(traderList.get(i));
//			
////			System.out.println(coinList.get(i));
//			
//			System.out.println(stratList.get(i));
//		}
		
		// create broker objects
//		Brokers brokerList = new Brokers(traderList,coinList,stratList);
		
	
		DataFetcher fetcher = new DataFetcher();
		// call api and fetch data and store in data structure 
		for(int k=0;k<coinList.size();k++) {
			String[] tmp = coinList.get(k); // get array of coins
			
			for(int i=0;i<tmp.length;i++) {
				// send a call for each coin
				double price = fetcher.getPriceForCoin(tmp[i], "30-03-2022");
				double marketCap = fetcher.getMarketCapForCoin(tmp[i], "30-03-2022");
				double volume = fetcher.getVolumeForCoin(tmp[i], "30-03-2022");
				
				System.out.println(tmp[i]+"=>\tPrice: " + price + 
						"\n\t\tMarket Cap: " + marketCap + 
						"\n\t\tVolume: "+ volume);
				
				// send data to broker
				
				
				
			}

			
		}
			
		
		
		// pass data to broker
	
	
	
	
	
	
	
	} // end of constructor
	
} // end of file