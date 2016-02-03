package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by hegberg on 1/12/16.
 * @author hegberg
 * @see HappyMood
 * @see SadMood
 */
public abstract class AbstractMood {
    //protected String mood;

    protected Date date;

    public abstract String mood();

    public AbstractMood() {
        this.date = new Date(System.currentTimeMillis());
    }

    public AbstractMood(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
