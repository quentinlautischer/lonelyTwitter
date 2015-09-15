package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by lautisch on 9/14/15.
 */
public class ImportantTweet extends Tweet implements Tweetable{

    public ImportantTweet(String text, Date date) throws IOException{
        super(text, date);
    }

    public ImportantTweet(String text) throws IOException{
        super(text);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

}
