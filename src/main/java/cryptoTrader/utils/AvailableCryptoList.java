package cryptoTrader.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AvailableCryptoList {
	private static AvailableCryptoList instance = null;
	
	private Map<String, String> availableCryptosMap = new HashMap<>();
	private List<String> availableCryptosList = new ArrayList<>();
	
	public static AvailableCryptoList getInstance() {
		if (instance == null)
			instance = new AvailableCryptoList();
		
		return instance;
	}
	
	// constructor
	private AvailableCryptoList() {
		findAvailableCryptos();
	}
	
	public void call() {
		String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=VNEY4VV2AWF1EB51";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				System.out.println(inline);
//				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
//				int size = jsonArray.size();
//				
//				String name, id;
//				for (int i = 0; i < size; i++) {
//					JsonObject object = jsonArray.get(i).getAsJsonObject();
//					name = object.get("name").getAsString();
//					id = object.get("id").getAsString();
//					
//					availableCryptosMap.put(name, id);
//					availableCryptosList.add(name);
//				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
	
	private void findAvailableCryptos() {

		String urlString = 
				"https://api.coingecko.com/api/v3/coins/markets" + 
						"?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false";
//		ALPHAVANTAGE API KEY = VNEY4VV2AWF1EB51
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int size = jsonArray.size();
				
				String name, id;
				for (int i = 0; i < size; i++) {
					JsonObject object = jsonArray.get(i).getAsJsonObject();
					name = object.get("name").getAsString();
					id = object.get("id").getAsString();
					
					availableCryptosMap.put(name, id);
					availableCryptosList.add(name);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
	
	public String[] getAvailableCryptos() {
		return availableCryptosList.toArray(new String[availableCryptosList.size()]);
	}
	
	public String getCryptoID(String cryptoName) {
		return availableCryptosMap.get(cryptoName);
	}

	// test on what this class does
	public static void main(String[] args) {
		AvailableCryptoList cList = new AvailableCryptoList(); // creates crypto list object
		String[] tmp = cList.getAvailableCryptos(); // gets the list of available crypto coins from api
		
		// loops and prints available coins
//		for(int i=0; i<lst.length;i++) {
//			System.out.println(lst[i]);
//		}
		System.out.println("# of coins: " + tmp.length);
		
		DataFetcher fetcher = new DataFetcher();
		for(int i=0; i<tmp.length; i++) {
			// send a call for each coin
			double price = fetcher.getPriceForCoin(tmp[i].toLowerCase(), "30-03-2022");
			double marketCap = fetcher.getMarketCapForCoin(tmp[i].toLowerCase(), "30-03-2022");
			double volume = fetcher.getVolumeForCoin(tmp[i].toLowerCase(), "30-03-2022");
			
			// test code for fetched data
			System.out.println(tmp[i].toLowerCase()+"=>\tPrice: " + price + 
					"\n\t\tMarket Cap: " + marketCap + 
					"\n\t\tVolume: "+ volume);
		}
	}
}
