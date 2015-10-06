package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Observer;


/**
 * Created by lautisch on 9/28/15.
 */
public class TweetList implements MyObservable, MyObserver{
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

    private  void notifyAllObservers(){
        for (MyObserver observer: observers){
            observer.myNotify(this);
        }
    }

    public void addObserver(MyObserver observer){
            observers.add(observer);
    }

    public void add(Tweet tweet) throws IllegalArgumentException{

        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException();
        } else {
            tweet.addObserver(this);
            tweets.add(tweet);

        }
        notifyAllObservers();
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

    public void myNotify(MyObservable observable) {
        notifyAllObservers();
    }
}
