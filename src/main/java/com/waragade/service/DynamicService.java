package com.waragade.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waragade.beans.Global;
import com.waragade.beans.Trend;
import com.waragade.client.ThirdPartyClient;
import com.waragade.util.Utility;

public class DynamicService {

	public String stateService(String stateCode) {

		String stateName = Utility.getInstance().getFullName(stateCode);
		String clientResponse = null;
		StringBuilder sbDist = new StringBuilder();
		StringBuilder sbState = new StringBuilder();
		if (stateName != null) {
			try {
				clientResponse = ThirdPartyClient.getInstance().getState();
			} catch (Exception e) {
				System.out.println("Exception : State client failed to retrieve data");
				return null;
			}
			if (clientResponse != null) {
				JSONObject stateJson = new JSONObject(clientResponse);
				String stateString = stateJson.get(stateName).toString();

				JSONObject distJson = new JSONObject(stateString);
				String distString = distJson.get("districtData").toString();

				JSONObject subDistJson = new JSONObject(distString);

				Integer sum = 0;
				for (String district : subDistJson.keySet()) {

					String subDistString = subDistJson.get(district).toString();
					JSONObject confirmJson = new JSONObject(subDistString);
					String confirmString = confirmJson.get("confirmed").toString();

					if ((confirmString != null || confirmString != "")) {
						Integer cases = Integer.parseInt(confirmString);
						sbDist.append("\n" + district + " : " + cases);
					}
					sum += Integer.parseInt(confirmString);
				}
				System.out.println("sum = " + sum);

				sbState.append("🇮🇳 *");
				sbState.append(stateName + "* : " + sum);
				if (sbDist.length() > 0) {
					sbState.append(sbDist);
				}
				return sbState.toString();
			}
		}
		return null;
	}

	private List<JSONObject> mapTrend() {
		String clientResponse = null;
		try {
			clientResponse = ThirdPartyClient.getInstance().getTrend();

		} catch (Exception e) {
			System.out.println("Exception : State client failed to retrieve data");
			return null;
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<Trend> listFromJackson = null;
		try {
			listFromJackson = mapper.readValue(clientResponse, new TypeReference<ArrayList<Trend>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		List<JSONObject> jsonList = new ArrayList<>();

		for (Trend t : listFromJackson) {
			JSONObject formDetailsJson = new JSONObject();
			formDetailsJson.put("Cases", t.getCases());
			formDetailsJson.put("Date", t.getDate());
			jsonList.add(formDetailsJson);
		}
		return jsonList;
	}

	public String indiaService() {

		List<JSONObject> jsonList = mapTrend();
		if (!jsonList.isEmpty()) {
			String cases = "0";
			if (jsonList != null && !jsonList.isEmpty()) {
				JSONObject india = jsonList.get(jsonList.size() - 1);
				if (india != null) {
					cases = india.get("Cases").toString();
					if (cases != null || cases != "") {

						return "🇮🇳  *India* " + "\nTotal Cases : " + cases;
					}
				}
			}
		}

		return null;
	}

	public String globalService() {

		String response1 = ThirdPartyClient.getInstance().getGlobal();
		if (response1 != null) {
			JSONObject responseJson1 = new JSONObject(response1);

			System.out.println(responseJson1.get("Global result :-").toString());

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			List<Global> listFromJackson = null;
			try {
				listFromJackson = mapper.readValue(responseJson1.get("results").toString(),
						new TypeReference<ArrayList<Global>>() {
						});
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			StringBuilder sb = new StringBuilder();
			for (Global t : listFromJackson) {

				sb.append("🌍 *Global Impact* ");
				sb.append("\nTotal Cases : " + t.getTotalCases());
				sb.append("\nDeaths : " + t.getTotalDeaths());
				sb.append("\nRecovered : " + t.getTotalRecovered());
				sb.append("\nAffected Countries : " + t.getTotalAffectedCountries());

			}
			return sb.toString();

		} else {
			return null;
		}
	}

}
