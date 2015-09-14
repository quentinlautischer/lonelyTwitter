package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by lautisch on 9/14/15.
 */
public abstract class Mood {

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mood(){
        this.date = new Date();
    }

    public Mood(Date date){
        this.date = date;
    }

    abstract String moodFormat();

}
