package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hegberg on 1/12/16.
 */
public class HappyMood extends AbstractMood {
    private String isMood = "Happy!";

    public HappyMood(Date date, String isMood) {
        super(date);
        this.isMood = isMood;
    }

    @Override
    public String mood() {
        return isMood;
    }
}
