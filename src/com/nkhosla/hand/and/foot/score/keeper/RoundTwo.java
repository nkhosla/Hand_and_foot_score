package com.nkhosla.hand.and.foot.score.keeper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.nkhosla.hand.and.foot.score.keeper2.R;

public class RoundTwo extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_round_two);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_round_two, menu);
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

	public void playThirdRound(View view) {
		//Declare the text fields and initialize as EditTexts
		EditText t1naturals = (EditText) findViewById(R.id.R2T1Naturals);
		EditText t2naturals = (EditText) findViewById(R.id.R2T2Naturals);

		EditText t1got22 = (EditText) findViewById(R.id.R2T1got22);
		EditText t2got22 = (EditText) findViewById(R.id.R2T2got22);

		EditText t1Unnaturals = (EditText) findViewById(R.id.R2T1Unnaturals);
		EditText t2Unnaturals = (EditText) findViewById(R.id.R2T2Unnaturals);

		EditText t1PointsOnTable = (EditText) findViewById(R.id.R2T1PointsOnTable);
		EditText t2PointsOnTable = (EditText) findViewById(R.id.R2T2PointsOnTable);

		EditText t1PointsInHand = (EditText) findViewById(R.id.R2T1PointsInHand);
		EditText t2PointsInHand = (EditText) findViewById(R.id.R2T2PointsInHand);

        EditText t1Spp = (EditText) findViewById(R.id.R2T1Spp);
        EditText t2Spp = (EditText) findViewById(R.id.R2T2Spp);


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
				isEmptyText(t2PointsInHand) ||
                isEmptyText(t1Spp) ||
                isEmptyText(t2Spp))){

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
            int spp[]={0,0};

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

            spp[0] = 2000*Integer.parseInt(t1Spp.getText().toString());
            spp[1] = 2000*Integer.parseInt(t2Spp.getText().toString());



			int teamOneScore = natural[0]+unnatural[0]+pointsOnTable[0]+got22[0]-pointsInHand[0]+spp[0];
			int teamTwoScore = natural[1]+unnatural[1]+pointsOnTable[1]+got22[1]-pointsInHand[1]+spp[1];



			// insert the scores into the score arrays from MainActivity
			MainActivity.teamOneScores[1]=teamOneScore;
			MainActivity.teamTwoScores[1]=teamTwoScore;

			int cumScoreOne=MainActivity.teamOneScores[4]+teamOneScore;
			int cumScoreTwo=MainActivity.teamTwoScores[4]+teamTwoScore;

			MainActivity.teamOneScores[4]=cumScoreOne;
			MainActivity.teamTwoScores[4]=cumScoreTwo;


			//made a toast with the current scores

			String toastNotification="The score for now is:\n"+"Team One: "+MainActivity.teamOneScores[4]+"\n"+"Team Two: "+MainActivity.teamTwoScores[4];
			Toast.makeText(this, toastNotification, Toast.LENGTH_LONG).show();

			//start the activity
			Intent intentToPlayRoundThree = new Intent(this, RoundThree.class);
			startActivity(intentToPlayRoundThree);
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
