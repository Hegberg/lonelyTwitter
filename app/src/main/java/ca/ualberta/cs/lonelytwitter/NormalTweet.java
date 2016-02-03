package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by hegberg on 1/12/16.
 * @author hegberg
 * @see Tweet
 */
public class NormalTweet extends Tweet implements Tweetable{
    public NormalTweet(Date date, String message, List mood) {

        super(date, message, mood);
    }

    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportantAsWell() {
        return false;
    }
}
