package com.eduardomcb.discord.webhook.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Message {

    private String username;
    private String avatarUrl;
    private String content;

    public Message() {
    }

    public String getUsername() {
        return username;
    }

    public Message setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Message setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public JSONObject get() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("username", username);
            obj.put("avatar_url", avatarUrl);
            obj.put("content", content);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
