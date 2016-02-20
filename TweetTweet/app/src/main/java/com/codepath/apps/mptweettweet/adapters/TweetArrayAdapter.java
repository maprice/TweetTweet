package com.codepath.apps.mptweettweet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mptweettweet.models.Tweet;
import com.codepath.apps.restclienttemplate.R;
import com.codepath.apps.mptweettweet.models.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mprice on 2/18/16.
 */
public class TweetArrayAdapter extends RecyclerView.Adapter<TweetArrayAdapter.TweetViewHolder> {

    private List<Tweet> mTweets;

    public class TweetViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tvBody)
        TextView tvBody;

        @Bind(R.id.ivProfileImage)
        ImageView ivProfileImage;

        @Bind(R.id.tvUsername)
        TextView tvUsername;

        public TweetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public TweetArrayAdapter(List<Tweet> tweets) {
        mTweets = tweets;
    }

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.item_tweet, parent, false);
        return new TweetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TweetViewHolder holder, int position) {
        Tweet tweet = mTweets.get(position);


        holder.tvBody.setText(tweet.body);
        User user = tweet.user;
        if (user != null) {
            holder.tvUsername.setText(user.name);

            holder.ivProfileImage.setImageResource(0);
            Picasso.with(holder.ivProfileImage.getContext()).load(user.profileImageUrl).into(holder.ivProfileImage);
        }
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }
}


