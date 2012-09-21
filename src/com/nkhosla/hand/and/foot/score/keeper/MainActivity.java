package com.nkhosla.hand.and.foot.score.keeper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.nkhosla.hand.and.foot.score.keeper2.R;

public class MainActivity extends Activity {

	//create the varables to store data throughout the game.
	//The format of the score vars is:
	//{round 1 score, round 2 score, r3 score, r4 score, updated cumulative score}

	public static int[] teamOneScores={0,0,0,0,0};
	public static int[] teamTwoScores={0,0,0,0,0};
	public static String[] teamNames={"",""};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void playFirstRound(View view) {
		EditText playerOneName = (EditText) findViewById(R.id.insert_player_one);
		EditText playerTwoName = (EditText) findViewById(R.id.insert_player_two);
		EditText playerThreeName = (EditText) findViewById(R.id.insert_player_three);
		EditText playerFourName = (EditText) findViewById(R.id.insert_player_four);




		if(isEmptyText(playerOneName) ||
				isEmptyText(playerTwoName) ||
				isEmptyText(playerThreeName) ||
				isEmptyText(playerFourName)){

			//give a pop-up reminding the user to fill in all fields

			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Warning!");
			builder.setMessage("Please fill in all the names of all four players");
			builder.setCancelable(false);
			builder.setPositiveButton("Ok",null);
			AlertDialog alert = builder.create();
			alert.show();

		}

		else{

			//get the players name's and store then as strings

			String nameOne = playerOneName.getText().toString();
			String nameTwo = playerTwoName.getText().toString();
			String nameThree = playerThreeName.getText().toString();
			String nameFour = playerFourName.getText().toString();


			String teamOneNames=nameOne.concat(" and ").concat(nameTwo);
			String teamTwoNames=nameThree.concat(" and ").concat(nameFour);

			//Put the team names into Extras for the intent and give a small toast notification
			//showing the teams

			MainActivity.teamNames[0] = teamOneNames;
			MainActivity.teamNames[1] = teamTwoNames;


			String toastNotification="The teams are:\nTeam One: ".concat(teamOneNames).concat("\nTeam Two: ").concat(teamTwoNames);
			Toast.makeText(this, toastNotification, Toast.LENGTH_LONG).show();

			//the intent to start the next round activity
			Intent intentToPlayRoundOne = new Intent(this, RoundOne.class);
			startActivity(intentToPlayRoundOne);
		}

	}

	public boolean isEmptyText(EditText editText) {
		// declare/initialize the boolean
		boolean isEmpty=true;


		//Check if empty
		if(editText.getText().toString().trim().equals("")){
			isEmpty = true;
		}

		else {
			isEmpty=false;
		}

		//return the boolean
		return isEmpty;
	}
}
