package com.eduardomcb.discord.webhook;

import com.eduardomcb.discord.webhook.models.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Message message = new Message()
                .setUsername("NewsApi")
                .setContent("Hello World!")
                .setAvatarUrl("https://cdn-icons-png.flaticon.com/512/2965/2965879.png");

        Field field1 = new Field("field-name1", "field-value1", false);
        Field field2 = new Field("field-name2", "field-value2", true);
        Field field3 = new Field("field-name3", "field-value3", true);
        Field field4 = new Field("field-name4", "field-value4", false);

        Image image = new Image("https://bgr.com/wp-content/uploads/2023/07/mercedes-supercharger.jpeg?quality=82&strip=all");
        Image thumbnail = new Image("https://bgr.com/wp-content/uploads/2023/07/mercedes-supercharger.jpeg?quality=82&strip=all");

        // timestamp
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formattedTimestamp = formatter.format(currentDate);

        Embed embed01 = new Embed()
                .setAuthor(new Author("eduardomcb", "", "https://avatars.githubusercontent.com/u/116934175?v=4"))
                .setTitle("This new mind-blowing battery tech could add up to 250 miles of range in just 10 minutes")
                .setUrl("https://bgr.com/tech/this-new-mind-blowing-battery-tech-could-add-up-to-250-miles-of-range-in-just-10-minutes/")
                .setColor(14177041)
                .setThumbnail(thumbnail)
                .setDescription("Electric vehicles have gotten a lot of hype over the past several years, especially as more and more companies have started to offer electric options. …\\nThe post This new mind-blowing battery tech could add up to 250 miles of range in just 10 minutes appeared…")
                .setImage(image)
                .setFooter(new Footer("author: eduardomcb", "https://avatars.githubusercontent.com/u/116934175?v=4"))
                .setTimestamp(formattedTimestamp)
                .setFields(new Field[]{field1, field2, field3, field4});


        new WebhookManager()
                .setChannelUrl("https://discord.com/api/webhooks/1234567890/abcdefghijklmno")
                .setMessage(message)
                .setEmbeds(new Embed[]{embed01})
                .setListener(new WebhookClient.Callback() {
                    @Override
                    public void onSuccess(String response) {
                        System.out.println("Message sent successfully");
                    }

                    @Override
                    public void onFailure(int statusCode, String errorMessage) {
                        System.out.println("Code: " + statusCode + " error: " + errorMessage);
                    }
                })
                .exec();

    }
}