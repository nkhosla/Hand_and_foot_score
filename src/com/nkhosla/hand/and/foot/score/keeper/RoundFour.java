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
    	//Intent intentToScoreTheGame = new Intent(this, FinalScores.class);
    	//startActivity(intentToScoreTheGame);
    	
		//get the scores and store each type as {team 1 score, team 2 score}
		//for that type
		EditText t1naturals = (EditText) findViewById(R.id.R4T1Naturals);
		EditText t2naturals = (EditText) findViewById(R.id.R4T2Naturals);
		int natural[] = {500*Integer.parseInt(t1naturals.getText().toString()),500*Integer.parseInt(t2naturals.getText().toString())};

		EditText t1got22 = (EditText) findViewById(R.id.R4T1got22);
		EditText t2got22 = (EditText) findViewById(R.id.R4T2got22);
		int got22[] = {100*Integer.parseInt(t1got22.getText().toString()),100*Integer.parseInt(t2got22.getText().toString())};

		EditText t1Unnaturals = (EditText) findViewById(R.id.R4T1Unnaturals);
		EditText t2Unnaturals = (EditText) findViewById(R.id.R4T2Unnaturals);
		int unnatural[] = {300*Integer.parseInt(t1Unnaturals.getText().toString()),300*Integer.parseInt(t2Unnaturals.getText().toString())};

		EditText t1PointsOnTable = (EditText) findViewById(R.id.R4T1PointsOnTable);
		EditText t2PointsOnTable = (EditText) findViewById(R.id.R4T2PointsOnTable);
		int pointsOnTable[] = {Integer.parseInt(t1PointsOnTable.getText().toString()),Integer.parseInt(t2PointsOnTable.getText().toString())};

		EditText t1PointsInHand = (EditText) findViewById(R.id.R4T1PointsInHand);
		EditText t2PointsInHand = (EditText) findViewById(R.id.R4T2PointsInHand);
		int pointsInHand[] = {Integer.parseInt(t1PointsInHand.getText().toString()),Integer.parseInt(t2PointsInHand.getText().toString())};

		int teamOneScore = natural[0]+unnatural[0]+pointsOnTable[0]+got22[0]-pointsInHand[0];
		int teamTwoScore = natural[1]+unnatural[1]+pointsOnTable[1]+got22[1]-pointsInHand[1];

		//update the score arrays from Main Activity
		// insert the scores into the score arrays from MainActivity
    	MainActivity.teamOneScores[3]=teamOneScore;
    	MainActivity.teamTwoScores[3]=teamTwoScore;
    	
    	MainActivity.teamOneScores[4]=MainActivity.teamOneScores[4]+teamOneScore;
    	MainActivity.teamTwoScores[4]=MainActivity.teamTwoScores[4]+teamTwoScore;

    	
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
        
        
		//send the actual alert
		//new AlertDialog.Builder(this).setTitle(alertTitle).setMessage("Watch out!").setNeutralButton("Close", null).show();
    	
    }
   

}
