/**
 * ActionLog class holds all the trade actions performed
 * @author Mohammed Al-Darwish, Disha Puri, Anusha Sheikh, Dexter Yan
 */
package cryptoTrader.gui;

import java.util.*;

public class ActionLog {

	/**
	 * Instance variables
	 */
	private HashMap<String, TradeAction> actionsMap;
	private int count = 0;

	/**
	 * Constructor
	 * Initializes an action map
	 */
	public ActionLog() {
		this.actionsMap = new HashMap<String, TradeAction>();
		
	}

	/**
	 * addActionlog method
	 * adds log to map
	 * @param key Index of the action log
	 * @param log Puts in trade action object at index key
	 */
	public void addActionLog(String key, TradeAction log) {
		this.actionsMap.put(key, log);
		count++;
	}

	/**
	 * Gets what is stored at the key index within the action log
	 * @param key Index of the action log
	 * @return Trade action object at the key index
	 */
	public TradeAction getActionLog(String key) {
		return this.actionsMap.get(key);
	}

	/**
	 * Size method
	 * @return size of action log
	 */
	public int size() {
		return count;
	}

	/**
	 * Retrieves everything within action log map and turns it into an object array
	 * @return Object array dataLog
	 */
	public Object[][] retrieveDataLogs(){
		Object[][] dataLog = new Object[this.actionsMap.size()][7]; // TODO fix size
		
		for(int j=0; j<this.actionsMap.size(); j++) {
			TradeAction log = this.actionsMap.get(Integer.toString(j)); // gets current action log
			Object[] data = log.asArray();
			for(int k=0;k<7;k++) {
				dataLog[j][k] = data[k];
			}
		}
		
		return dataLog;
	}
	
} // end of file