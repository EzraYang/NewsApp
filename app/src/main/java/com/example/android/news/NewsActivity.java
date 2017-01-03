package com.example.android.news;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class NewsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private String mFakeJsonResponse = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":5205,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":521,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"music/2016/oct/09/jenny-hval-blood-bitch-review\",\"type\":\"article\",\"sectionId\":\"music\",\"sectionName\":\"Music\",\"webPublicationDate\":\"2016-10-09T07:00:05Z\",\"webTitle\":\"Jenny Hval: Blood Bitch review – intriguing experimental pop\",\"webUrl\":\"https://www.theguardian.com/music/2016/oct/09/jenny-hval-blood-bitch-review\",\"apiUrl\":\"https://content.guardianapis.com/music/2016/oct/09/jenny-hval-blood-bitch-review\",\"isHosted\":false},{\"id\":\"music/2016/dec/22/gfoty-call-him-a-doctor-review-pc-music-basic-bitch\",\"type\":\"article\",\"sectionId\":\"music\",\"sectionName\":\"Music\",\"webPublicationDate\":\"2016-12-22T21:45:02Z\",\"webTitle\":\"GFOTY: Call Him a Doctor review – irreverent pastiche of a 'basic bitch'\",\"webUrl\":\"https://www.theguardian.com/music/2016/dec/22/gfoty-call-him-a-doctor-review-pc-music-basic-bitch\",\"apiUrl\":\"https://content.guardianapis.com/music/2016/dec/22/gfoty-call-him-a-doctor-review-pc-music-basic-bitch\",\"isHosted\":false},{\"id\":\"books/2016/nov/22/shelf-life-the-bitch-is-back-rachel-cooke-cathi-hanauer-essays-feminism-debora-spar-sarah-crichton\",\"type\":\"article\",\"sectionId\":\"books\",\"sectionName\":\"Books\",\"webPublicationDate\":\"2016-11-22T09:00:31Z\",\"webTitle\":\"The Bitch Is Back: How Cathi Hanauer’s female contributors have mellowed\",\"webUrl\":\"https://www.theguardian.com/books/2016/nov/22/shelf-life-the-bitch-is-back-rachel-cooke-cathi-hanauer-essays-feminism-debora-spar-sarah-crichton\",\"apiUrl\":\"https://content.guardianapis.com/books/2016/nov/22/shelf-life-the-bitch-is-back-rachel-cooke-cathi-hanauer-essays-feminism-debora-spar-sarah-crichton\",\"isHosted\":false},{\"id\":\"tv-and-radio/2016/jun/21/farewell-penny-dreadful-you-great-fertile-bitch-of-evil\",\"type\":\"article\",\"sectionId\":\"tv-and-radio\",\"sectionName\":\"Television & radio\",\"webPublicationDate\":\"2016-06-21T15:46:21Z\",\"webTitle\":\"Farewell Penny Dreadful, you 'great fertile bitch of evil'\",\"webUrl\":\"https://www.theguardian.com/tv-and-radio/2016/jun/21/farewell-penny-dreadful-you-great-fertile-bitch-of-evil\",\"apiUrl\":\"https://content.guardianapis.com/tv-and-radio/2016/jun/21/farewell-penny-dreadful-you-great-fertile-bitch-of-evil\",\"isHosted\":false},{\"id\":\"tv-and-radio/2016/apr/05/charity-dingle-returns-to-emmerdale\",\"type\":\"article\",\"sectionId\":\"tv-and-radio\",\"sectionName\":\"Television & radio\",\"webPublicationDate\":\"2016-04-05T08:00:31Z\",\"webTitle\":\"The bitch is back: Charity Dingle returns to Emmerdale\",\"webUrl\":\"https://www.theguardian.com/tv-and-radio/2016/apr/05/charity-dingle-returns-to-emmerdale\",\"apiUrl\":\"https://content.guardianapis.com/tv-and-radio/2016/apr/05/charity-dingle-returns-to-emmerdale\",\"isHosted\":false},{\"id\":\"tv-and-radio/2016/jul/21/son-of-a-bitch-knockabout-brazilian-football-comedy-drama-plays-a-blinder\",\"type\":\"article\",\"sectionId\":\"tv-and-radio\",\"sectionName\":\"Television & radio\",\"webPublicationDate\":\"2016-07-21T17:40:56Z\",\"webTitle\":\"Son of a Bitch – knockabout Brazilian football comedy-drama plays a blinder\",\"webUrl\":\"https://www.theguardian.com/tv-and-radio/2016/jul/21/son-of-a-bitch-knockabout-brazilian-football-comedy-drama-plays-a-blinder\",\"apiUrl\":\"https://content.guardianapis.com/tv-and-radio/2016/jul/21/son-of-a-bitch-knockabout-brazilian-football-comedy-drama-plays-a-blinder\",\"isHosted\":false},{\"id\":\"stage/2016/aug/18/bitches-review-finborough-theatre-london-bola-agbaje\",\"type\":\"article\",\"sectionId\":\"stage\",\"sectionName\":\"Stage\",\"webPublicationDate\":\"2016-08-18T10:18:37Z\",\"webTitle\":\"Bitches review – Bola Agbaje reveals the private lives of vloggers\",\"webUrl\":\"https://www.theguardian.com/stage/2016/aug/18/bitches-review-finborough-theatre-london-bola-agbaje\",\"apiUrl\":\"https://content.guardianapis.com/stage/2016/aug/18/bitches-review-finborough-theatre-london-bola-agbaje\",\"isHosted\":false},{\"id\":\"media/mind-your-language/2015/oct/30/power-grab-reclaiming-words-can-be-such-a-bitch\",\"type\":\"article\",\"sectionId\":\"media\",\"sectionName\":\"Media\",\"webPublicationDate\":\"2015-10-30T07:00:08Z\",\"webTitle\":\"Power grab: reclaiming words can be such a bitch\",\"webUrl\":\"https://www.theguardian.com/media/mind-your-language/2015/oct/30/power-grab-reclaiming-words-can-be-such-a-bitch\",\"apiUrl\":\"https://content.guardianapis.com/media/mind-your-language/2015/oct/30/power-grab-reclaiming-words-can-be-such-a-bitch\",\"isHosted\":false},{\"id\":\"sport/2016/apr/28/shane-sutton-british-cycling-dirty-terrorist-alleged-remark\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2016-04-28T18:05:58Z\",\"webTitle\":\"Shane Sutton accused of ‘dirty terrorist’ and ‘bitches’ remarks by British cyclists\",\"webUrl\":\"https://www.theguardian.com/sport/2016/apr/28/shane-sutton-british-cycling-dirty-terrorist-alleged-remark\",\"apiUrl\":\"https://content.guardianapis.com/sport/2016/apr/28/shane-sutton-british-cycling-dirty-terrorist-alleged-remark\",\"isHosted\":false},{\"id\":\"music/2015/dec/16/madonna-calls-complaining-fans-diva-bitches-after-arriving-late-on-stage\",\"type\":\"article\",\"sectionId\":\"music\",\"sectionName\":\"Music\",\"webPublicationDate\":\"2015-12-16T10:38:47Z\",\"webTitle\":\"Madonna calls complaining fans 'diva bitches' after arriving late on stage\",\"webUrl\":\"https://www.theguardian.com/music/2015/dec/16/madonna-calls-complaining-fans-diva-bitches-after-arriving-late-on-stage\",\"apiUrl\":\"https://content.guardianapis.com/music/2015/dec/16/madonna-calls-complaining-fans-diva-bitches-after-arriving-late-on-stage\",\"isHosted\":false}]}}";

    private String mFakeUrl = "http://content.guardianapis.com/search?q=bitch&api-key=test";

    private NewsAdapter mAdapter;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mListView = (ListView) findViewById(R.id.list);

        getLoaderManager().initLoader(0, null, this);

    }

    // using mFakeJsonResponse
//    private void updateUi(){
//        List<News> newsList = QueryUtils.extractNewsData(mFakeJsonResponse);
//        mAdapter = new NewsAdapter(NewsActivity.this, newsList);
//        mListView.setAdapter(mAdapter);
//
//    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {

        return new NewsLoader(this, mFakeUrl);
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> data) {

    }
}
