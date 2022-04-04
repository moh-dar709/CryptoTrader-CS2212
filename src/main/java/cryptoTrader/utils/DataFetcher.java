/**
 * provided class that acts as a data fecher from the coingecko API
 * @author Unknown
 */
package cryptoTrader.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DataFetcher {

	/**
	 * This method calls the api and gets the data as a json object
	 * @param id represents the coin name
	 * @param date represents the date of market
	 * @return the json object
	 */
	private JsonObject getDataForCrypto(String id, String date) {

		String urlString = String.format(
				"https://api.coingecko.com/api/v3/coins/%s/history?date=%s", id, date);
		
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
				JsonObject jsonObject = new JsonParser().parse(inline).getAsJsonObject();
				return jsonObject;
			}

		} catch (IOException e) {
			System.out.println("Something went wrong with the API call.");
		}
		return null;
	}
	
	/**
	 * This method gets the price of a coin
	 * @param id represents the coin
	 * @param date represents the date
	 * @return coin price as double
	 */
	public double getPriceForCoin(String id, String date) {
		double price = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("current_price").getAsJsonObject();
			price = currentPrice.get("cad").getAsDouble();
		}
		
		return price;
	}
	
	/**
	 * This method gets the market cap of a coin
	 * @param id represents the coin
	 * @param date represents the date
	 * @return coin market cap as double
	 */
	public double getMarketCapForCoin(String id, String date) {
		double marketCap = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("market_cap").getAsJsonObject();
			marketCap = currentPrice.get("cad").getAsDouble();
		}
		
		return marketCap;
	}
	
	/**
	 * This method gets the volume of a coin
	 * @param id represents the coin
	 * @param date represents the date
	 * @return coin volume as double
	 */
	public double getVolumeForCoin(String id, String date) {
		double volume = 0.0;
		
		JsonObject jsonObject = getDataForCrypto(id, date);
		if (jsonObject != null) {
			JsonObject marketData = jsonObject.get("market_data").getAsJsonObject();
			JsonObject currentPrice = marketData.get("total_volume").getAsJsonObject();
			volume = currentPrice.get("cad").getAsDouble();
		}
		
		return volume;
	}
	
	// this is how this class works
//	public static void main(String[] args) {
//		DataFetcher fetcher = new DataFetcher();
//		double price = fetcher.getPriceForCoin("bitcoin", "30-03-2022");
//		double marketCap = fetcher.getMarketCapForCoin("bitcoin", "30-03-2022");
//		double volume = fetcher.getVolumeForCoin("bitcoin", "30-03-2022");
//		
//		System.out.println("Bitcoin=>\tPrice: " + price + 
//								"\n\t\tMarket Cap: " + marketCap + 
//								"\n\t\tVolume: "+volume);
//		
//	}
	
} // end of file