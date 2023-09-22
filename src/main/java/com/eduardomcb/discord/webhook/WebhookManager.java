package com.eduardomcb.discord.webhook;

import com.eduardomcb.discord.webhook.models.Embed;
import com.eduardomcb.discord.webhook.models.Message;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.eduardomcb.discord.webhook.WebhookClient.Callback;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WebhookManager {

    private String webhookUrl = "";
    private String channelId = "";
    private String token = "";
    private Embed[] embeds = null;

    Callback callback;
    private Message message;

    public WebhookManager() {
    }

    /**
     * Sets the webhook URL for a channel.
     *
     * @param webhookUrl The webhook URL to be set for the channel.
     * @return An instance of WebhookManager with the updated webhook URL if the provided URL is valid.
     */
    public WebhookManager setChannelUrl(String webhookUrl) {
        /**
         * Checks if the provided webhook URL is in a valid format.
         * The valid format is "https://discord.com/api/webhooks/{CHANNEL_ID}/{TOKEN}".
         *
         * @param webhookUrl The webhook URL to be checked.
         * @return true if the URL is in a valid format, false otherwise.
         */
        boolean isValidUrl = webhookUrl.matches("https://discord\\.com/api/webhooks/[0-9]+/[A-Za-z0-9_\\-]+");

        // If the provided URL is valid, update the channel's webhook URL.
        if (isValidUrl) {
            this.webhookUrl = webhookUrl;
        }

        // Return the updated instance of WebhookManager.
        return this;
    }

    /**
     * Sets the message content and other details.
     *
     * @param message The message object containing username, avatar URL, and content.
     * @return An instance of WebhookManager with the updated message details.
     */
    public WebhookManager setMessage(Message message) {
        this.message = message;
        return this;
    }

    /**
     * Sets a listener for webhook response callbacks.
     *
     * @param callback The callback to be invoked upon successful or failed webhook execution.
     * @return An instance of WebhookManager with the updated callback listener.
     */
    public WebhookManager setListener(Callback callback) {
        this.callback = callback;
        return this;
    }

    public Embed[] getEmbeds() {
        return embeds;
    }

    /**
     * Sets the array of embeds for the webhook message.
     *
     * @param embeds The array of embeds to be attached to the message.
     * @return An instance of WebhookManager with the updated array of embeds.
     */
    public WebhookManager setEmbeds(Embed[] embeds) {
        this.embeds = embeds;
        return this;
    }

    /**
     * Executes the sending of the message to the specified webhook.
     *
     * @return An instance of WebhookManager.
     */
    public WebhookManager exec() {
        JSONObject obj = createJsonObject();

        WebhookClient wc = new WebhookClient(callback);
        wc.send(webhookUrl, obj);

        return this;
    }

    /**
     * Creates a JSON object representing the message content and embeds.
     *
     * @return The JSON object containing the message details.
     */
    private JSONObject createJsonObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("username", message.getUsername());
            obj.put("avatar_url", message.getAvatarUrl());
            obj.put("content", message.getContent());

            JSONArray embedsArr = new JSONArray();

            if (embeds != null) {
                for (Embed item : this.embeds) {
                    embedsArr.put(item.get());
                }

                if (embedsArr.length() != 0) {
                    obj.put("embeds", embedsArr);
                }
            }
        } catch (JSONException e) {
            handleJsonException(e);
        }
        return obj;
    }

    /**
     * Handles JSON-related exceptions by logging them and invoking the onFailure callback.
     *
     * @param e The JSONException that occurred.
     */
    private void handleJsonException(JSONException e) {
        Logger logger = Logger.getLogger(WebhookManager.class.getName());
        logger.log(Level.SEVERE, "Erro JSON: ", e);

        if (callback != null) {
            callback.onFailure(-1, e.getMessage());
        }
    }
}
