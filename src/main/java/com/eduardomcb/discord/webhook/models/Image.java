package com.eduardomcb.discord.webhook.models;

import org.json.JSONObject;
import org.json.JSONException;

public class Image {
	
	private String url;
	
	public Image(String url) {
		this.url = url;
	}
	
	public JSONObject get() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("url", this.url);
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
