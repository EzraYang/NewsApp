package com.example.android.news;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private String mFakeUrl = "http://content.guardianapis.com/search?q=programmer&api-key=test";

    private NewsAdapter mAdapter;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

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

        getLoaderManager().initLoader(0, null, this);

    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {

        return new NewsLoader(this, mFakeUrl);
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
