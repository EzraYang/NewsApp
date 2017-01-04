package com.example.android.news;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private String mFakeUrlString = "http://content.guardianapis.com/search?q=programmer&api-key=test";

    private String mBaseUrlString = "http://content.guardianapis.com/search?api-key=test";

    private NewsAdapter mAdapter;

    private ListView mListView;

    private EditText mTopicField;

    private int loaderId = 0;

    private String mTopic = "";

    private TextView mEmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mListView = (ListView) findViewById(R.id.list);
        mAdapter = new NewsAdapter(NewsActivity.this, new ArrayList<News>());
        mListView.setAdapter(mAdapter);

        mEmptyTextView = (TextView) findViewById(R.id.text_when_empty);
        mListView.setEmptyView(mEmptyTextView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                News currentNews = (News) mAdapter.getItem(position);

                Uri newsUri = Uri.parse(currentNews.getmUrl());

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(browserIntent);
            }
        });

        ImageView searchBtn = (ImageView) findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clear up mAdapter leads to clear listView
                mAdapter.clear();
                // set mEmptyTextView an empty String
                // in case it was showing no_key_word or no_conn warning previously
                mEmptyTextView.setText("");

                // check the internet connection on the device
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()){
                    // find out what user's key search word
                    mTopicField = (EditText) findViewById(R.id.topic_field) ;

                    // check if user has enter a key word
                    if (!mTopicField.getText().toString().isEmpty() && mTopicField.getText().toString() != mTopic){

                        mTopic = mTopicField.getText().toString();

                        // if topic changes,
                        // init a new loader with loaderId increment 1
                        mAdapter.clear();
                        loaderId += 1;

                        getLoaderManager().initLoader(loaderId, null, NewsActivity.this);

                    } else {
                        mEmptyTextView.setText(R.string.new_topic_needed);
                    }
                } else {
                    mEmptyTextView.setText(R.string.no_conn);
                }
            }
        });
    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {

        mTopic = mTopicField.getText().toString();

        Uri baseUrl = Uri.parse(mBaseUrlString);
        Uri.Builder urlBuilder = baseUrl.buildUpon();
        urlBuilder.appendQueryParameter("q", mTopic);

        String queryUrl = urlBuilder.toString();

        return new NewsLoader(this, queryUrl);
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {


        if ( data != null & !data.isEmpty()){
            mAdapter.addAll(data);
        }

    }
}
