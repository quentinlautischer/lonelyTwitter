package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lautisch on 9/14/15.
 */

import java.util.Date;

public class Tweet {

    protected String text;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text.length() <= 140){
            this.text = text;
        }

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tweet(String text, Date date) {
        this.text = text;
        this.date = date;

    }

    public Tweet(String text) {
        this.text = text;
        this.date = new Date();
    }
}
