package cryptoTrader.gui;

import java.util.*;

public class ActionLog {

	// instance variables
	private HashMap<String, TradeAction> actionsMap; // to store trade actions
	
	// constructor
	public ActionLog() {
		this.actionsMap = new HashMap<String, TradeAction>(); // initialize action map
		
	} // end of constructor
	
	public void addActionLog(String key, TradeAction log) {
		// add log to map
		this.actionsMap.put(key, log);
	}
	
	public TradeAction getActionLog(String key) {
		return this.actionsMap.get(key);
	}
	
	public Object[] retrieveDataLogs(){
		List<Object> database = new ArrayList<Object>();
		
		for (TradeAction action : this.actionsMap.values()) {
			database.add(action.asArray());
//			System.out.println(action);
		}
		
//		Object[] dataLog = new Object[this.actionsMap.size()];
		Object[] dataLog = database.toArray();
		
		// TODO MOH STOPPED HERE - 3:00am :)
		
		return dataLog;
	}
	
} // end of file