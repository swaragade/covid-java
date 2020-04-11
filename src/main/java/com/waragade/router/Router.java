package com.waragade.router;

import com.waragade.service.DynamicService;
import com.waragade.service.StaticService;
import com.waragade.util.Utility;

public class Router {

	static Router router;
	
	private DynamicService dynamicService = new DynamicService();

	public static Router getInstance() {
		if (router == null) {
			router = new Router();
		}
		return router;
	}

	public String route(String[] messageArray) {

		int msgCount = messageArray.length;

		String returnString = Utility.getInstance().defaultMessage();

		if (msgCount > 0 && msgCount < 3) {

			if (msgCount == 1) {
				String message = messageArray[0];
				
				if (message.equalsIgnoreCase("help")) {
					// return response for help
					return StaticService.getInstance().helpService();

				} else if (message.equalsIgnoreCase("symptoms")) {
					// return response for sym
					return StaticService.getInstance().symptompsService();

				} else if (message.equalsIgnoreCase("india") || message.equalsIgnoreCase("ind")
						|| message.equalsIgnoreCase("in")) {

					String temp = dynamicService.indiaService();
					if (temp != null) {
						return temp;
					}
					
					return returnString;
				} else if (message.equalsIgnoreCase("global") || message.equalsIgnoreCase("world") || message.equalsIgnoreCase("globe")) {

					String temp = dynamicService.globalService();
					if (temp != null) {
						return temp;
					}
				} else if (message.equalsIgnoreCase("states")) {
					// list of states
					return StaticService.getInstance().stateListService();
				}

			} else {
				String message1 = messageArray[0];
				String message2 = messageArray[1];

				if (message1.equalsIgnoreCase("state")) {
					String temp = dynamicService.stateService(message2);
					if (temp != null) {
						return temp;
					}
				}
				return returnString;
			}
		}
		return returnString;

	}
}
