package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    //TODO: A function that gets tweets
    public static ArrayList<Tweet> getTweet() {
        verifyClient();
        return null;
    }

    public static class SearchTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        private String searchTerm;

        public SearchTweetsTask(String text){
            searchTerm = text;
        }

        @Override
        protected ArrayList<Tweet> doInBackground(String... search_strings){
            verifyClient();

            ArrayList<Tweet> tweets = new ArrayList<Tweet>();

            //Search search = new Search.Builder(search_strings[0]).addIndex("testing").addType("tweet").build();

            //figure out how to use this
            String query = "{\n" +
                    "    \"id\": \"myTemplateId\"," +
                    "    \"params\": {\n" +
                    "        \"query_string\" : \"search for this\"" +
                    "    }\n" +
                    " \"size\" : 1000"+
                    "}";

            Search search = new Search.Builder(query).addIndex("testing").addType("tweet").build();

            try {
                SearchResult execute = client.execute(search);
                if(execute.isSucceeded()) {
                    List<NormalTweet> returned_tweets = execute.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(returned_tweets);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return tweets;
        }
    }

    public static class GetTweetsTask extends AsyncTask<String, Void, ArrayList<Tweet>> {
        @Override
        protected ArrayList<Tweet> doInBackground(String... search_strings){
            verifyClient();

            ArrayList<Tweet> tweets = new ArrayList<Tweet>();

            Search search = new Search.Builder(search_strings[0]).addIndex("testing").addType("tweet").build();

            try {
                SearchResult execute = client.execute(search);
                if(execute.isSucceeded()) {
                    List<NormalTweet> returned_tweets = execute.getSourceAsObjectList(NormalTweet.class);
                    tweets.addAll(returned_tweets);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return tweets;
        }
    }

    //TODO: A function that adds a tweet
    public static void addTweet(Tweet tweet){
        verifyClient();

        Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
        try {
            DocumentResult result = client.execute(index);
            if(result.isSucceeded()){
                //set tweet id that elastic created for it
                tweet.setId(result.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class AddTweetTask extends AsyncTask<NormalTweet, Void, Void>{

        @Override
        protected Void doInBackground(NormalTweet... tweets) {
            verifyClient();

            for (int i=0; i<tweets.length; i++){
                NormalTweet tweet = tweets[i];

                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if(result.isSucceeded()){
                        //set tweet id that elastic created for it
                        tweet.setId(result.getId());
                    } else {
                        //TODO and an error message
                        //TODO Right here it will trigger if insert fails
                        //Log.i("fails here");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }
    }

    public static void verifyClient() {
        // verify client exists
        // if not make it
        if(client == null){
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config = builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }
    }
}
