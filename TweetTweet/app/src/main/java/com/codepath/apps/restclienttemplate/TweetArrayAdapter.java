package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.ArrayList;

/**
 * Created by mprice on 2/18/16.
 */
public class TweetArrayAdapter extends ArrayAdapter<Tweet> {


    public TweetArrayAdapter(Context context, ArrayList<Tweet> tweets) {
        super(context, android.R.layout.simple_list_item_1, tweets);
    }
}


