package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by lautisch on 9/21/15.
 */
public class FullScreenTweetActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        Intent intent = getIntent();

        setContentView(R.layout.main);
    }

}
