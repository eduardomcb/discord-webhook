package com.eduardomcb.discord.webhook.models;

import org.json.JSONObject;
import org.json.JSONException;

public class Footer {
	
	private String text;
	private String icon_url;
	
	public Footer(String text, String icon_url) {
		this.text = text;
		this.icon_url = icon_url;
	}
	
	public JSONObject get() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("text", this.text);
			obj.put("icon_url", this.icon_url);
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
