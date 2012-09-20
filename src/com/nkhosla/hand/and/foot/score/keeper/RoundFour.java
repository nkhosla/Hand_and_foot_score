package com.nkhosla.hand.and.foot.score.keeper;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RoundFour extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_round_four);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_round_four, menu);
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

	public void scoreGame(View view) {

		//Declare the text fields and initialize as EditTexts
		EditText t1naturals = (EditText) findViewById(R.id.R4T1Naturals);
		EditText t2naturals = (EditText) findViewById(R.id.R4T2Naturals);

		EditText t1got22 = (EditText) findViewById(R.id.R4T1got22);
		EditText t2got22 = (EditText) findViewById(R.id.R4T2got22);

		EditText t1Unnaturals = (EditText) findViewById(R.id.R4T1Unnaturals);
		EditText t2Unnaturals = (EditText) findViewById(R.id.R4T2Unnaturals);

		EditText t1PointsOnTable = (EditText) findViewById(R.id.R4T1PointsOnTable);
		EditText t2PointsOnTable = (EditText) findViewById(R.id.R4T2PointsOnTable);

		EditText t1PointsInHand = (EditText) findViewById(R.id.R4T1PointsInHand);
		EditText t2PointsInHand = (EditText) findViewById(R.id.R4T2PointsInHand);


		//check to make sure the fields are not empty
		if((isEmptyText(t1naturals) ||
				isEmptyText(t2naturals) ||
				isEmptyText(t1Unnaturals) ||
				isEmptyText(t2Unnaturals) ||
				isEmptyText(t1got22) ||
				isEmptyText(t2got22) ||
				isEmptyText(t1PointsOnTable) ||
				isEmptyText(t2PointsOnTable) ||
				isEmptyText(t1PointsInHand) ||
				isEmptyText(t2PointsInHand))){

			//give a pop-up reminding the user to fill in all fields

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Warning!");
			builder.setMessage("Please fill in all score fields");
			builder.setCancelable(false);
			builder.setPositiveButton("Ok",null);
			AlertDialog alert = builder.create();
			alert.show();
		}


		else {



			// if all fields are full, initialize the score arrays in format of 
			//{team one score, team two score}
			int natural[] ={0,0};
			int got22[] ={0,0};
			int unnatural[] ={0,0};
			int pointsOnTable[] ={0,0};
			int pointsInHand[] ={0,0};

			//get the values and calculate the score
			natural[0] = 500*Integer.parseInt(t1naturals.getText().toString());
			natural[1] = 500*Integer.parseInt(t2naturals.getText().toString());

			got22[0] = 100*Integer.parseInt(t1got22.getText().toString());
			got22[1] = 100*Integer.parseInt(t2got22.getText().toString());

			unnatural[0] = 300*Integer.parseInt(t1Unnaturals.getText().toString());
			unnatural[1] = 300*Integer.parseInt(t2Unnaturals.getText().toString());

			pointsOnTable[0] = Integer.parseInt(t1PointsOnTable.getText().toString());
			pointsOnTable[1] = Integer.parseInt(t2PointsOnTable.getText().toString());

			pointsInHand[0] = Integer.parseInt(t1PointsInHand.getText().toString());
			pointsInHand[1] = Integer.parseInt(t2PointsInHand.getText().toString());



			int teamOneScore = natural[0]+unnatural[0]+pointsOnTable[0]+got22[0]-pointsInHand[0];
			int teamTwoScore = natural[1]+unnatural[1]+pointsOnTable[1]+got22[1]-pointsInHand[1];



			// insert the scores into the score arrays from MainActivity
			MainActivity.teamOneScores[3]=teamOneScore;
			MainActivity.teamTwoScores[3]=teamTwoScore;

			int cumScoreOne=MainActivity.teamOneScores[4]+teamOneScore;
			int cumScoreTwo=MainActivity.teamTwoScores[4]+teamTwoScore;

			MainActivity.teamOneScores[4]=cumScoreOne;
			MainActivity.teamTwoScores[4]=cumScoreTwo;

			//make a pop up wwith the final scores and who won

			//determine who won and make the alert dialog title accordingly
			String alertTitle="";

			if(MainActivity.teamOneScores[4] > MainActivity.teamTwoScores[4]){
				alertTitle=MainActivity.teamNames[0]+" won!";
			}

			else if(MainActivity.teamOneScores[4] < MainActivity.teamTwoScores[4]){
				alertTitle=MainActivity.teamNames[1]+" won!";
			}

			else if(MainActivity.teamOneScores[4] == MainActivity.teamTwoScores[4]){
				alertTitle="It was a tie!";
			}

			//set the message text for the alert
			String nl="\n";

			String teams=MainActivity.teamNames[0]+" | "+MainActivity.teamNames[1]+nl;
			String roundOne= MainActivity.teamOneScores[0]+"  Round One  "+MainActivity.teamTwoScores[0]+nl;
			String roundTwo= MainActivity.teamOneScores[1]+"  Round Two  "+MainActivity.teamTwoScores[1]+nl;
			String roundThree= MainActivity.teamOneScores[2]+"  Round Three  "+MainActivity.teamTwoScores[2]+nl;
			String roundFour= MainActivity.teamOneScores[3]+"  Round Four  "+MainActivity.teamTwoScores[3]+nl+nl;
			String cumulativeScoreString =MainActivity.teamOneScores[4]+"  Final Score  "+MainActivity.teamTwoScores[4];

			String alertMessage=teams+roundOne+roundTwo+roundThree+roundFour+cumulativeScoreString;

			//Send the alert
			AlertDialog.Builder builder = new AlertDialog.Builder(this);

			builder.setTitle(alertTitle);

			builder.setMessage(alertMessage);

			builder.setPositiveButton("OK", null);

			AlertDialog dialog = builder.show();

			TextView messageText = (TextView)dialog.findViewById(android.R.id.message);

			messageText.setGravity(Gravity.CENTER);

		}

	}

	public boolean isEmptyText(EditText editText) {
		// declare/initalize the boolean
		boolean isEmpty=true;


		//Check if empty
		if(editText.getText().toString().trim().equals("")){
			isEmpty = true;
		}

		else {
			isEmpty=false;
		}


		return isEmpty;
	}

}
