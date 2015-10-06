package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity implements MyObserver {

	private static final String FILENAME = "file.sav"; //model
	private EditText bodyText;  // View
	private ListView oldTweetsList; // model
	private ArrayList<Tweet> tweets; //model
	private ArrayAdapter<Tweet> adapter; //controller

	public void myNotify(MyObservable observable) { // controller
		adapter.notifyDataSetChanged();
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) { //view

		super.onCreate(savedInstanceState); //view
		setContentView(R.layout.main); //view

		bodyText = (EditText) findViewById(R.id.body); // view
		Button saveButton = (Button) findViewById(R.id.save); //view
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); //model
		tweets = new ArrayList<Tweet>(); // model

		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK); //controller
				String text = bodyText.getText().toString();// controller
				tweets.add(new NormalTweet(text)); // controller
				saveInFile(); // move to model
				adapter.notifyDataSetChanged(); //controller
			}
		});

	}

	@Override
	protected void onStart() { // View
		// TODO Auto-generated method stub
		super.onStart(); //view
		loadFromFile(); //model
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets); // controller
		oldTweetsList.setAdapter(adapter); // model
	}

	private void loadFromFile() { //model
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Following line base on https://google-gson.googlecode.com/svn ...
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType); //model


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	private void saveInFile() { //model
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);

			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets, writer);
			writer.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}