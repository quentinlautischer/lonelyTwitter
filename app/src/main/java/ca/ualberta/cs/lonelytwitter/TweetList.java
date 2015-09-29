package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lautisch on 9/28/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

//    public TweetList(){
//
//    }
    public void add(Tweet tweet) throws IllegalArgumentException{
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweets.add(tweet);
        }
    }

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public void remove(Tweet tweet){
        tweets.remove(tweet);
    }

    public int size() {
        return tweets.size();
    }

    public int getCount(){
        return tweets.size();
    }

    public Boolean contains(Tweet tweet){
        return tweets.contains(tweet);
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

    public Boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

}
