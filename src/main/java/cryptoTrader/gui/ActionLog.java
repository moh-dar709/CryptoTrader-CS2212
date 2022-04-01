package cryptoTrader.gui;

import java.util.*;

public class ActionLog {

	// instance variables
	private HashMap<String, TradeAction> actionsMap; // to store trade actions
	private int count = 0;
	
	// constructor
	public ActionLog() {
		this.actionsMap = new HashMap<String, TradeAction>(); // initialize action map
		
	} // end of constructor
	
	public void addActionLog(String key, TradeAction log) {
		// add log to map
		this.actionsMap.put(key, log);
		count++;
	}
	
	public TradeAction getActionLog(String key) {
		return this.actionsMap.get(key);
	}
	
	public int size() {
		return count;
	}
	
	public Object[][] retrieveDataLogs(){
		Object[][] dataLog = new Object[7][7]; // TODO fix size
		
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