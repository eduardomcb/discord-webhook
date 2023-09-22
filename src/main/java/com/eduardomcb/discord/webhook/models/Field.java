package com.eduardomcb.discord.webhook.models;

import org.json.JSONObject;
import org.json.JSONException;

public class Field {
	
	private String name;
	private String value;
	private boolean inline = false;
	
	public Field(String name, String value, boolean inline) {
		this.name = name;
		this.value = value;
		this.inline = inline;
	}
	
	public JSONObject get() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", this.name);
			obj.put("value", this.value);
			obj.put("inline", this.inline);
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
