package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TimelineActivity extends AppCompatActivity {

    private TwitterClient twitterClient;
    private ArrayList<Tweet> tweets;
    private TweetArrayAdapter adapter;

    @Bind(R.id.lvTweets)
    ListView lvTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);

        twitterClient = RestApplication.getRestClient();
        tweets = new ArrayList<>();
        adapter = new TweetArrayAdapter(this, tweets);
        lvTweets.setAdapter(adapter);
        populateTimeline();


    }

    private void populateTimeline() {
        twitterClient.getHomeTimeline(1, new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONArray jsonArray) {
                tweets.addAll(Tweet.fromJson(jsonArray));
                Log.d("DEBUG", "timeline: " + jsonArray.toString());

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {


                Log.d("DEBUG", "timeline Failed: " + responseString);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                //super.onFailure(statusCode, headers, throwable, errorResponse);

                Log.d("DEBUG", "timeline Failed: " + errorResponse.toString());
            }
        });
    }
}
