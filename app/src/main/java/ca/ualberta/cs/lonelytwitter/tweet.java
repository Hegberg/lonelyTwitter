package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hegberg on 1/12/16.
 */
public abstract class tweet {
    protected Date date;
    protected String message;
    private boolean isImportant;
    protected List moods = new ArrayList();

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }

    public abstract Boolean isImportantAsWell();

    public tweet(List moods) {
        this.moods = moods;
    }

    public List getMoods() {
        return moods;
    }

    public void setMoods(List moods) {
        this.moods = moods;
    }

    public tweet(Date date, String message, List moods) {
        this.date = date;
        this.message = message;
        this.moods = moods;
    }

    public tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    public void setMessage(String message) throws TooLong {
        if(message.length() > 140){
            throw new TooLong();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setIsImportant(boolean isImportant) {
        this.isImportant = isImportant;
    }
}
