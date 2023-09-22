package com.eduardomcb.discord.webhook.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Embed {

    private String title;
    private int color;
    private String description;
    private String timestamp;
    private String url;

    private Author author = null;
    private Image thumbnail = null;
    private Image image = null;
    private Footer footer = null;
    private Field[] fields = null;

    public Embed() {
    }

    public Embed setTitle(String title) {
        this.title = title;
        return this;
    }

    public Embed setColor(int color) {
        this.color = color;
        return this;
    }

    public Embed setDescription(String description) {
        this.description = description;
        return this;
    }

    public Embed setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Embed setUrl(String url) {
        this.url = url;
        return this;
    }

    public Embed setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Embed setImage(Image image) {
        this.image = image;
        return this;
    }

    public Embed setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public Embed setFooter(Footer footer) {
        this.footer = footer;
        return this;
    }

    public Embed setFields(Field[] fields) {
        this.fields = fields;
        return this;
    }


    public JSONObject get() {
        JSONObject obj = new JSONObject();
        JSONArray fieldsArr = new JSONArray();
        try {
            obj.put("title", this.title);
            obj.put("color", this.color);
            obj.put("description", this.description);
            obj.put("timestamp", this.timestamp);
            obj.put("url", this.url);

            if (this.author != null) obj.put("author", this.author.get());
            if (this.image != null) obj.put("image", this.image.get());
            if (this.thumbnail != null) obj.put("thumbnail", this.thumbnail.get());
            if (this.footer != null) obj.put("footer", this.footer.get());

            if (fields != null) {
                for (Field item : this.fields) {
                    fieldsArr.put(item.get());
                }

                if (fieldsArr.length() != 0) {
                    obj.put("fields", fieldsArr);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
