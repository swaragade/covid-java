package com.waragade.coronamh;

import static spark.Spark.get;
import static spark.Spark.post;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;

@SpringBootApplication
public class CoronamhApplication implements ApplicationRunner {

	private final static String ACCOUNT_SID = "ACbc4a604fbfde78726d7acbddfa7fb467";
	private final static String AUTH_ID = "35d58b6a2a56d378e7709688858c5056";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(CoronamhApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		get("/", (req, res) -> "Hello Web");
		post("/sms", (req, res) -> {
			
			System.out.println("incoming body "+req.body().toString());
			
			res.type("application/xml");
			Body body = new Body.Builder("The Robots are coming! Head for the hills!").build();
			Message sms = new Message.Builder().body(body).build();
			MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
			return twiml.toXml();
		});
	}

}
