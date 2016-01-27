package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.List;

/**
 * Created by hegberg on 1/12/16.
 */
public class ImportantTweet extends Tweet implements Tweetable{
    @Override
    public Boolean isImportantAsWell() {
        return true;
    }

    public ImportantTweet(Date date, String message, List mood) {

        super(date, message, mood);
    }

    public ImportantTweet(String message) {

        super(message);
    }

    public ImportantTweet(Date date, String message) {
        super(date, message);
    }
}
