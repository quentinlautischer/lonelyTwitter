package ca.ualberta.cs.lonelytwitter;

/**
 * Created by lautisch on 10/16/15.
 */
public class ApplicationState {

    private static ApplicationState mInstance = null;

    private Tweet tweet;

    private ApplicationState(){
    }

    public static ApplicationState getInstance(){
        if(mInstance == null)
        {
            mInstance = new ApplicationState();
        }
        return mInstance;
    }

    public Tweet getTweet(){
        return this.tweet;
    }

    public void setTweet(Tweet tweet){
        this.tweet = tweet;
    }
}
