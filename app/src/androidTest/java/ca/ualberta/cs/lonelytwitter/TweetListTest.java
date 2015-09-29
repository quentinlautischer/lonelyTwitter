package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lautisch on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testGetCount() {
        //    getCount() -- should accurately count up the tweets
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertEquals(1, list.getCount());
        list.add(new NormalTweet("test 2"));
        assertEquals(2, list.getCount());
    }

    public void testRemoveTweet(){
        //    removeTweet() -- should remove a tweet
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.remove(tweet);
        assertFalse(list.hasTweet(tweet));
    }


    public void testHasTweet() {
        //    hasTweet() -- should return true if there is a tweet that equals() another tweet
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
        assertFalse(list.hasTweet(new NormalTweet("FAIL")));
    }

    public void testAddTweet() {

        //    addTweet() -- should throw an IllegalArgumentException when one tries to add a duplicate tweet
        boolean thrown = false;

        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertEquals(list.size(), 1);
        try {
            list.add(tweet);
        } catch (IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(thrown);
    }

    public void testGetTweets(){
    //    getTweets() -- sould return a list of tweets in chronological order
        TweetList list = new TweetList();
        Tweet tweet1 = new NormalTweet("test1");
        Tweet tweet2 = new NormalTweet("test2");
        list.add(tweet1);
        list.add(tweet2);
        ArrayList<Tweet> rList = list.getTweets();
        assertEquals(tweet1, rList.get(0));
        assertEquals(tweet2, rList.get(1));
    }

    public void testDelete() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.contains(tweet));
    }

    public void testContains() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.contains(tweet));
    }



}