package com.waragade.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class ThirdPartyClient {

	private static final String URL_TREND = "https://api..covid19api.com/country/india/status/confirmed";

	private static final String URL_GLOBAL = "https://api.thevirustracker.com/free-api?global=stats";

	private static final String URL_STATE = "https://api.covid19india.org/state_district_wise.json";

	private static ThirdPartyClient tpClient;

	private javax.ws.rs.client.Client client;

	public static ThirdPartyClient getInstance() {
		if (tpClient == null) {
			tpClient = new ThirdPartyClient();
		}
		return tpClient;
	}

	private Client getClient() {
		if (client == null) {
			client = ClientBuilder.newClient();
		}
		return client;
	}

	public String getTrend() {
		String response = null;
		try {
			response = getClient().target(URL_TREND).request(MediaType.APPLICATION_JSON).get(String.class);
		} catch (Exception e) {
			System.out.println("Exception: Could not connect to India API");
		}
		return response;
	}

	public String getGlobal() {
		String response = null;
		try {
			response = getClient().target(URL_GLOBAL).request(MediaType.APPLICATION_JSON).get(String.class);
		} catch (Exception e) {
			System.out.println("Exception: Could not connect to GLOBAL API");
		}
		return response;
	}

	public String getState() {
		String response = null;
		try {
			response = getClient().target(URL_STATE).request(MediaType.APPLICATION_JSON).get(String.class);
		} catch (Exception e) {
			System.out.println("Exception: Could not connect to STATE API");
		}
		return response;
	}

}
