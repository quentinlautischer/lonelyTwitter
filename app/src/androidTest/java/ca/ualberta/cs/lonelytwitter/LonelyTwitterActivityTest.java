package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import junit.framework.TestCase;

import javax.microedition.khronos.egl.EGLDisplay;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private String tweetText;
    private EditText bodyText;
    private Button saveButton;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testEditTweet() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) getActivity();

        activity.getTweetList().clear();

        tweetText = "Hello!";
        bodyText = activity.getBodyText();

        activity.runOnUiThread(new Runnable() {
            public void run() {
                bodyText.setText(tweetText);
            }
        });

        getInstrumentation().waitForIdleSync();

        saveButton = activity.getSaveButton();
        activity.runOnUiThread(new Runnable() {
            public void run() {
                saveButton.performClick();
            }
        });
        getInstrumentation().waitForIdleSync();

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet newestTweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals(tweetText, newestTweet.getText());

        //Code from https://developer.android.com/training/activity-testing/activity-functional-testing.html
        //Date: 2015-10-15
        // Set up an ActivityMonitor
        Instrumentation.ActivityMonitor receiverActivityMonitor =
                getInstrumentation().addMonitor(EditTweetActivity.class.getName(),
                        null, false);


        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetList.getChildAt(0);
                oldTweetList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();


        assertTrue(activity.getTweetList().get(0).getText().equals(tweetText));

        // Validate that ReceiverActivity is started
//        TouchUtils.clickView(this, sendToReceiverButton);
        EditTweetActivity receiverActivity = (EditTweetActivity)
                receiverActivityMonitor.waitForActivityWithTimeout(1000);
        assertNotNull("ReceiverActivity is null", receiverActivity);
        assertEquals("Monitor for ReceiverActivity has not been called",
                1, receiverActivityMonitor.getHits());
        assertEquals("Activity is of wrong type",
                EditTweetActivity.class, receiverActivity.getClass());



        /*######################## START LAB ASSIGNMENT ############################ */

        // test that the tweet editor starts up with the correct tweet


        activity.runOnUiThread(new Runnable() {
            public void run() {
                View v = oldTweetList.getChildAt(0);
                oldTweetList.performItemClick(v, 0, v.getId());
            }
        });
        getInstrumentation().waitForIdleSync();


        Tweet mainTweet = activity.getTweetList().get(0);
        assertEquals(tw,EditTweetActivity.getTweet());
        EditTweetActivity.tweet

        // test that we can edit a tweet

        // test that we can push a save button for the edited tweet

        // test that the modified tweet was saved

        // test that the modified tweet is in the tweet list
        /*######################## END LAB ASSIGNMENT ############################ */

        // Remove the ActivityMonitor
        getInstrumentation().removeMonitor(receiverActivityMonitor);

        receiverActivity.finish(); //close activity test is good!
    }
}