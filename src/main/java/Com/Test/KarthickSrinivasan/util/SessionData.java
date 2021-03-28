package Com.Test.KarthickSrinivasan.util;

import java.util.HashMap;

public class SessionData {
	
	private static HashMap<String,String> sessionData;
	
	public static void setSessionData(HashMap<String,String> sessionData) {
		SessionData.sessionData=sessionData;
	}
	
	public static void addData(String key,String value) {
		sessionData.put(key, value);
	}
	
	public static String getData(String key) {
		return sessionData.get(key);
	}
	
	public static void clearSessionData() {
		sessionData.clear();
	}
	

}
