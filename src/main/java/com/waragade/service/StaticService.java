package com.waragade.service;

public class StaticService {
	
	private static StaticService staticService;
	
	public static StaticService getInstance() {
		if (staticService == null) {
			staticService = new StaticService();
		}
		return staticService;
	}

	public String helpService() {
		return "*National Helplines*\r\n" + 
				"☎ *Police* : 100\r\n" + 
				"☎ *Ambulance* : 108\r\n" + 
				"☎ *Helpline* : +91-11-23978046\r\n" + 
				"☎ *Toll-Free* : 1075";
	}

	public String symptompsService() {
		return "Coronaviruses are a large family of viruses. Its symptoms in humans are\r\n" + 
				"\r\n" + 
				" 🤒 Fever\r\n" + 
				" 😐 Breathing problem\r\n" + 
				" 🤧 Coughing\r\n" + 
				" 😫 Tightness of chest\r\n" + 
				" 👃 Running Nose\r\n" + 
				" 😨 Headache\r\n" + 
				" 🌡️ Feeling unwell\r\n" + 
				" 😷 Pneumonia\r\n" + 
				" 💉 Kidney Failure ";
	}

	public String stateListService() {
		return "Send *state <state code>*\r\n" + 
				"\r\n" + 
				"*AP* : Andhra Pradesh\r\n" + 
				"*AR* : Arunachal Pradesh\r\n" + 
				"*AS* : Assam\r\n" + 
				"*BR* : Bihar\r\n" + 
				"*CG* : Chhattisgarh\r\n" + 
				"*CH* : Chandigarh\r\n" + 
				"*AN* : Andaman and Nicobar Islands\r\n" + 
				"*DL* : Delhi\r\n" + 
				"*DN* : Dadra and Nagar Haveli\r\n" + 
				"*DD* : Daman and Diu\r\n" + 
				"*GA* : Goa\r\n" + 
				"*GJ* : Gujarat\r\n" + 
				"*HP* : Himachal Pradesh\r\n" + 
				"*HR* : Haryana\r\n" + 
				"*JH* : Jharkhand\r\n" + 
				"*JK* : Jammu and Kashmir\r\n" + 
				"*KA* : Karnataka\r\n" + 
				"*KL* : Kerala\r\n" + 
				"*LD* : Lakshadweep\r\n" + 
				"*LA* : Ladakh\r\n" + 
				"*MH* : Maharashtra\r\n" + 
				"*ML* : Meghalaya\r\n" + 
				"*MN* : Manipur\r\n" + 
				"*MP* : Madhya Pradesh\r\n" + 
				"*MZ* : Mizoram\r\n" + 
				"*NL* : Nagaland\r\n" + 
				"*OD* : Odisha\r\n" + 
				"*PB* : Punjab\r\n" + 
				"*PY* : Puducherry\r\n" + 
				"*RJ* : Rajasthan\r\n" + 
				"*SK* : Sikkim\r\n" + 
				"*TN* : Tamil Nadu\r\n" + 
				"*TS* : Telangana\r\n" + 
				"*TR* : Tripura\r\n" + 
				"*UP* : Uttar Pradesh\r\n" + 
				"*UK* : Uttarakhand\r\n" + 
				"*WB* : West Bengal ";
	}

}
