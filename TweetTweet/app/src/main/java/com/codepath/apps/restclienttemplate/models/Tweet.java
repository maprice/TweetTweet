package com.codepath.apps.restclienttemplate.models;

/**
 * Created by mprice on 2/18/16.
 */

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@Table(name = "Tweets")
public class Tweet extends Model {
    // Define database columns and associated fields
    @Column(name = "userId")
    public String userId;
    @Column(name = "userHandle")
    public String userHandle;
    @Column(name = "timestamp")
    public String timestamp;
    @Column(name = "body")
    public String body;

    public User user;

    public Tweet(JSONObject object){
        super();

        try {
            this.userId = object.getString("id");
//            this.userHandle = object.getString("user_username");
//            this.timestamp = object.getString("timestamp");
            this.body = object.getString("text");
            this.user = User.fromJson(object.getJSONObject("user"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Tweet> fromJson(JSONArray jsonArray) {
        ArrayList<Tweet> tweets = new ArrayList<Tweet>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject tweetJson = null;
            try {
                tweetJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Tweet tweet = new Tweet(tweetJson);
            tweet.save();
            tweets.add(tweet);
        }

        return tweets;
    }
}
