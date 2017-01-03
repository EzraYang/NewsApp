package com.example.android.news;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private String mFakeUrlString = "http://content.guardianapis.com/search?q=programmer&api-key=test";

    private String mBaseUrlString = "http://content.guardianapis.com/search?api-key=test";

    private NewsAdapter mAdapter;

    private ListView mListView;

    private EditText mTopicField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mTopicField = (EditText) findViewById(R.id.topic_field) ;

        mListView = (ListView) findViewById(R.id.list);
        mAdapter = new NewsAdapter(NewsActivity.this, new ArrayList<News>());
        mListView.setAdapter(mAdapter);

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
                getLoaderManager().initLoader(1, null, NewsActivity.this);
            }
        });


    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {

        String topic = mTopicField.getText().toString();

        Uri baseUrl = Uri.parse(mBaseUrlString);
        Uri.Builder urlBuilder = baseUrl.buildUpon();
        urlBuilder.appendQueryParameter("q", topic);

        String queryUrl = urlBuilder.toString();

        return new NewsLoader(this, queryUrl);
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {
        mAdapter.clear();

        if ( data != null & !data.isEmpty()){
            mAdapter.addAll(data);
        }

    }
}
