package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hegberg on 1/12/16.
 */
public class SadMood extends AbstractMood{
    private String isMood = "Sad.";

    public SadMood(Date date, String isMood) {
        super(date);
        this.isMood = isMood;
    }

    @Override
    public String mood() {
        return isMood;
    }
}
