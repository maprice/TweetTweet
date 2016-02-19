package com.codepath.apps.restclienttemplate.models;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mprice on 2/18/16.
 */
@Table(name = "User")
public class User {
    @Column(name = "name")
    String name;
    @Column(name = "uid")
    Long uid;
    @Column(name = "profileImageUrl")
    String profileImageUrl;
    @Column(name = "screenName")
    String screenName;

    User user;

    public static User fromJson(JSONObject json) {
        User u = new User();

        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.profileImageUrl = json.getString("profile_image_url");
            u.screenName = json.getString("screen_name");
            u.user = User.fromJson(json.getJSONObject("user"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return u;
    }

}
