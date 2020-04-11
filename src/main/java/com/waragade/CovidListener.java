package com.waragade;

import static spark.Spark.get;
import static spark.Spark.post;

import com.twilio.Twilio;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.waragade.router.Router;
import com.waragade.util.Utility;

public class CovidListener {

	private final static String ACCOUNT_SID = "ACbc4a604fbfde78726d7acbddfa7fb467";
	private final static String AUTH_ID = "35d58b6a2a56d378e7709688858c5056";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public static void main(String[] args) {

		get("/", (req, res) -> "Hello Web");
		post("/sms", (req, res) -> {

			System.out.println("incoming body " + req.body().toString());

			String returnString = Utility.getInstance().defaultMessage();

			if (req.body() != null) {
				String input = req.body().toString().trim();

				int startIdx = 0;
				int endIdx = 0;
				String wholeMessage = null;
				String[] messageArray = null;

				if (input.contains("&Body") && input.contains("&To")) {
					startIdx = input.indexOf("&Body") + 6;
					endIdx = input.indexOf("&To");

					if (startIdx != 0 && endIdx != 0) {
						wholeMessage = input.substring(startIdx, endIdx);
						messageArray = wholeMessage.trim().split("\\+");
						
						returnString = Router.getInstance().route(messageArray);
					} else {
						// return
					}
				} else {
					// return
				}
			} else {
				// null response
			}

			/// ignore for now
			res.type("application/xml");
			Body body = new Body.Builder(returnString).build();
			Message sms = new Message.Builder().body(body).build();
			MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
			return twiml.toXml();
		});

	}

}
