package com.waragade.util;

import java.util.HashMap;

public class Utility {

	static Utility utility;

	static HashMap<String, String> stateDict = new HashMap<>();

	static {
		stateDict.put("kl", "Kerala");
		stateDict.put("kerala", "Kerala");
		
		stateDict.put("dl", "Delhi");
		stateDict.put("delhi", "Delhi");
		
		stateDict.put("ts", "Telangana");
		stateDict.put("telangana", "Telangana");
		
		stateDict.put("rj", "Rajasthan");
		stateDict.put("rajasthan", "Rajasthan");
		
		stateDict.put("hr", "Haryana");
		stateDict.put("haryana", "Haryana");
		
		stateDict.put("up", "Uttar Pradesh");
		stateDict.put("uttar pradesh", "Uttar Pradesh");
		
		stateDict.put("la", "Ladakh");
		stateDict.put("ladakh", "Ladakh");
		
		stateDict.put("jk", "Jammu and Kashmir");
		stateDict.put("jammu and kashmir", "Jammu and Kashmir");
		
		stateDict.put("ka", "Karnataka");
		stateDict.put("karnataka", "Karnataka");
		
		stateDict.put("mh", "Maharashtra");
		stateDict.put("maharashtra", "Maharashtra");
		
		stateDict.put("pb", "Punjab");
		stateDict.put("Punjab", "Punjab");
		
		stateDict.put("ap", "Andhra Pradesh");
		stateDict.put("andhra pradesh", "Andhra Pradesh");
		
		stateDict.put("uk", "Uttarakhand");
		stateDict.put("uttarakhand", "Uttarakhand");

		stateDict.put("od", "Odisha");
		stateDict.put("odisha", "Odisha");

		stateDict.put("py", "Puducherry");
		stateDict.put("puducherry", "Puducherry");

		stateDict.put("wb", "West Bengal");
		stateDict.put("west bengal", "West Bengal");

		stateDict.put("ch", "Chandigarh");
		stateDict.put("chandigarh", "Chandigarh");

		stateDict.put("cg", "Chhattisgarh");
		stateDict.put("chhattisgarh", "Chhattisgarh");

		stateDict.put("gj", "Gujarat");
		stateDict.put("gujarat", "Gujarat");

		stateDict.put("hp", "Himachal Pradesh");
		stateDict.put("himachal pradesh", "Himachal Pradesh");

		stateDict.put("mp", "Madhya Pradesh");
		stateDict.put("madhya pradesh", "Madhya Pradesh");

		stateDict.put("br", "Bihar");
		stateDict.put("bihar", "Bihar");

		stateDict.put("mn", "Manipur");
		stateDict.put("manipur", "Manipur");

		stateDict.put("mz", "Mizoram");
		stateDict.put("mizoram", "Mizoram");

		stateDict.put("ga", "Goa");
		stateDict.put("goa", "Goa");

		stateDict.put("an", "Andaman and Nicobar Islands");
		stateDict.put("andaman and nicobar islands", "Andaman and Nicobar Islands");

		stateDict.put("jh", "Jharkhand");
		stateDict.put("jharkhand", "Jharkhand");

		stateDict.put("as", "Assam");
		stateDict.put("assam", "Assam");

		stateDict.put("ar", "Arunachal Pradesh");
		stateDict.put("arunachal pradesh", "Arunachal Pradesh");

		stateDict.put("dn", "Dadra and Nagar Haveli");
		stateDict.put("dadra and nagar haveli", "Dadra and Nagar Haveli");

		stateDict.put("tr", "Tripura");
		stateDict.put("Tripura", "Tripura");

		stateDict.put("tn", "Tamil Nadu");
		stateDict.put("tamil nadu", "Tamil Nadu");

		stateDict.put("sk", "Sikkim");
		stateDict.put("sikkim", "Sikkim");

		stateDict.put("dd", "Daman and Diu");
		stateDict.put("daman and diu", "Daman and Diu");

		stateDict.put("tr", "Tripura");
		stateDict.put("Tripura", "Tripura");

		stateDict.put("ml", "Meghalaya");
		stateDict.put("Meghalaya", "Meghalaya");

		stateDict.put("ld", "Lakshadweep");
		stateDict.put("lakshadweep", "Lakshadweep");

		stateDict.put("nl", "Nagaland");
		stateDict.put("nagaland", "Nagaland");
	}

	public static Utility getInstance() {
		if (utility == null) {
			utility = new Utility();
		}
		return utility;
	}
	
	public String defaultMessage() {
		return "Providing live updates on Corona.\r\n" + 
				"🔹 *Help* for more info.\r\n" + 
				"🔹 *India* for details about India.\r\n" + 
				"🔹 *State <State Code>* for details about State.\r\n" + 
				"🔹 *States* for list of  State & State Code.\r\n" + 
				"🔹 *Global* for Global stats.\r\n" + 
				"🔹 *Symptoms* for information about Symptoms.\r\n" + 
				"\r\n" + 
				"We are improvising, feedbacks are welcome\r\n" + 
				"Stay Tuned.\r\n" + 
				"-https://twitter.com/dontknowsuraj\r\n" + 
				"-https://instagram.com/swapnil_karale";
	}

	public String getFullName(String shortName) {
		String fullName = null;
		if (shortName != null) {
			fullName = stateDict.get(shortName.toLowerCase());
		}
		return fullName;
	}
}
