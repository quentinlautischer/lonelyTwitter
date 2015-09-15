package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lautisch on 9/14/15.
 */

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;

public abstract class Tweet {

    protected String text;
    private Date date;

    private ArrayList<Mood> tweetMoods;

    public ArrayList<Mood> getMoods() {
        return tweetMoods;
    }

    public void addMood(Mood mood) {
        this.tweetMoods.add(mood);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws IOException {
        if (text.length() <= 140){
            this.text = text;
        } else {
            throw new IOException("Tweet was too long!");
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tweet(String text, Date date) throws IOException{
        this.setText(text);
        this.setDate(date);
        this.tweetMoods = new ArrayList<Mood>();

    }

    public Tweet(String text) {
        this.text = text;
        this.date = new Date();
        this.tweetMoods = new ArrayList<Mood>();
    }

    public Tweet() {
        this.date = new Date();
        this.text = "";
        this.tweetMoods = new ArrayList<Mood>();
    }

    public abstract Boolean isImportant();
}
