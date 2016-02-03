package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hegberg on 1/26/16.
 * @author hegberg
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet) {
        if(tweets.contains(tweet)){
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public void deleteTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public ArrayList getTweets(){
        ArrayList<Tweet> chronoTweets = tweets;
        Tweet temp = new NormalTweet("temp");
        for(int i = 0; i < chronoTweets.size(); i++){
            for(int j = 0; j < chronoTweets.size(); j++){
                if(chronoTweets.get(i).getDate().before(chronoTweets.get(j).getDate())){
                    temp = chronoTweets.get(i);
                    chronoTweets.set(i,chronoTweets.get(j));
                    chronoTweets.set(j, temp);
                }
            }
        }
        return chronoTweets;
    }

    public int getCount() {
        return tweets.size();
    }


}
