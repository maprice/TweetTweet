package com.codepath.apps.mptweettweet.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ComposeDialogFragment extends DialogFragment {

    @Bind(R.id.btnClose)
    Button btnClose;

    @Bind(R.id.btnTweet)
    Button btnTweet;

    @Bind(R.id.tvCharacterCount)
    TextView tvCharacterCount;

    @Bind(R.id.tvUsername)
    TextView tvUsername;

    @Bind(R.id.etTweet)
    EditText etTweet;

    @Bind(R.id.ivProfileImage)
    ImageView ivProfileImage;

    private String mCurrentUserName;
    private String mCurrentUserUrl;


    private final int MAX_CHARACTER_COUNT = 142;

    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //This sets a textview to the current length
            int newCount = MAX_CHARACTER_COUNT - s.length();
            tvCharacterCount.setText(String.valueOf(newCount));
        }

        public void afterTextChanged(Editable s) {
        }
    };

    private static final String ARG_USER_NAME = "username";
    private static final String ARG_USER_PROFILE = "profileurl";


    private OnFragmentInteractionListener mListener;



    public interface OnFragmentInteractionListener {
        void onTweetSelected(String tweet);
    }

    public static ComposeDialogFragment newInstance(String currentUserName, String currentUserUrl) {
        ComposeDialogFragment fragment = new ComposeDialogFragment();
        Bundle args = new Bundle();

        args.putString(ARG_USER_NAME, currentUserName);
        args.putString(ARG_USER_PROFILE, currentUserUrl);
        fragment.setArguments(args);

        return fragment;
    }


    public ComposeDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCurrentUserName = getArguments().getString(ARG_USER_NAME);
            mCurrentUserUrl = getArguments().getString(ARG_USER_PROFILE);
        }
    }

    private void configureView() {

        tvUsername.setText(mCurrentUserName);
        Glide.with(getContext()).load(mCurrentUserUrl).into(ivProfileImage);



        etTweet.addTextChangedListener(mTextEditorWatcher);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onTweetSelected(etTweet.getText().toString());
                getDialog().dismiss();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compose_dialog, container, false);
        ButterKnife.bind(this, view);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        this.configureView();

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
