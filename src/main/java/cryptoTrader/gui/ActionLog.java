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
	
	public Object[][] retrieveDataLogs(){
		Object[][] dataLog = new Object[7][7];
		
		
		for(int j=0; j<this.actionsMap.size(); j++) {
			TradeAction log = this.actionsMap.get(Integer.toString(j)); // gets current action log
			Object[] data = log.asArray();
			for(int k=0;k<7;k++) {
				dataLog[j][k] = data[k];
				
//				String trader = log.getTrader();
//				String strategy = log.getStrategy();
//				String cryptocoin = ;
//				String action;
//				String quantity;
//				String price;
//				String date;
			}
		}
		
		
		
//		List<Object> database = new ArrayList<Object>();
//		
//		for (TradeAction action : this.actionsMap.values()) {
//			database.add(action.asArray());
////			System.out.println(action);
//		}
//		
////		Object[] dataLog = new Object[this.actionsMap.size()];
//		Object[] dataLog = database.toArray();
//		
//		// TODO MOH STOPPED HERE - 3:00am :)
//		
		return dataLog;
	}
	
} // end of file