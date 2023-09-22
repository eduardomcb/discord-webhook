package com.eduardomcb.discord.webhook.models;

import org.json.JSONObject;
import org.json.JSONException;

public class Author {
	
	private String name;
	private String url;
	private String icon;
	
	public Author(String name, String url, String icon) {
		this.name = name;
		this.url = url;
		this.icon = icon;
	}
	
	public JSONObject get() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", this.name);
			obj.put("url", this.url);
			obj.put("icon_url", this.icon);
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
