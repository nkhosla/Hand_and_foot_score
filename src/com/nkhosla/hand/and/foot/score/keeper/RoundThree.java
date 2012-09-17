package com.nkhosla.hand.and.foot.score.keeper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class RoundThree extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_round_three);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_round_three, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void playFourthRound(View view) {
		Intent intentToPlayRoundFour = new Intent(this, RoundFour.class);
		startActivity(intentToPlayRoundFour);

		//get the scores and store each type as {team 1 score, team 2 score}
		//for that type
		EditText t1naturals = (EditText) findViewById(R.id.R3T1Naturals);
		EditText t2naturals = (EditText) findViewById(R.id.R3T2Naturals);
		int natural[] = {500*Integer.parseInt(t1naturals.getText().toString()),500*Integer.parseInt(t2naturals.getText().toString())};

		EditText t1got22 = (EditText) findViewById(R.id.R3T1got22);
		EditText t2got22 = (EditText) findViewById(R.id.R3T2got22);
		int got22[] = {100*Integer.parseInt(t1got22.getText().toString()),100*Integer.parseInt(t2got22.getText().toString())};

		EditText t1Unnaturals = (EditText) findViewById(R.id.R3T1Unnaturals);
		EditText t2Unnaturals = (EditText) findViewById(R.id.R3T2Unnaturals);
		int unnatural[] = {300*Integer.parseInt(t1Unnaturals.getText().toString()),300*Integer.parseInt(t2Unnaturals.getText().toString())};

		EditText t1PointsOnTable = (EditText) findViewById(R.id.R3T1PointsOnTable);
		EditText t2PointsOnTable = (EditText) findViewById(R.id.R3T2PointsOnTable);
		int pointsOnTable[] = {Integer.parseInt(t1PointsOnTable.getText().toString()),Integer.parseInt(t2PointsOnTable.getText().toString())};

		EditText t1PointsInHand = (EditText) findViewById(R.id.R3T1PointsInHand);
		EditText t2PointsInHand = (EditText) findViewById(R.id.R3T2PointsInHand);
		int pointsInHand[] = {Integer.parseInt(t1PointsInHand.getText().toString()),Integer.parseInt(t2PointsInHand.getText().toString())};

		int teamOneScore = natural[0]+unnatural[0]+pointsOnTable[0]+got22[0]-pointsInHand[0];
		int teamTwoScore = natural[1]+unnatural[1]+pointsOnTable[1]+got22[1]-pointsInHand[1];


		//update the score arrays from Main Activity
		// insert the scores into the score arrays from MainActivity
    	MainActivity.teamOneScores[2]=teamOneScore;
    	MainActivity.teamTwoScores[2]=teamTwoScore;
    	
    	MainActivity.teamOneScores[4]=MainActivity.teamOneScores[4]+teamOneScore;
    	MainActivity.teamTwoScores[4]=MainActivity.teamTwoScores[4]+teamTwoScore;

		//toast the current cumulative score
    	String toastNotification="The score for now is:\n"+"Team One: "+MainActivity.teamOneScores[4]+"\n"+"Team Two: "+MainActivity.teamTwoScores[4];
		Toast.makeText(this, toastNotification, Toast.LENGTH_LONG).show();
    	
    	//start the activity
    	startActivity(intentToPlayRoundFour);
	}
}
