package com.nkhosla.hand.and.foot.score.keeper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
    	//the intent to start the next round activity
    	Intent intentToPlayRoundOne = new Intent(this, RoundOne.class);
    	
    	//get the players name's and store then as strings
    	EditText playerOneName = (EditText) findViewById(R.id.insert_player_one);
    	String nameOne = playerOneName.getText().toString();
    	
    	EditText playerTwoName = (EditText) findViewById(R.id.insert_player_two);
    	String nameTwo = playerTwoName.getText().toString();
    	
    	EditText playerThreeName = (EditText) findViewById(R.id.insert_player_three);
    	String nameThree = playerThreeName.getText().toString();
    	
    	EditText playerFourName = (EditText) findViewById(R.id.insert_player_four);
    	String nameFour = playerFourName.getText().toString();
    	
    	String teamOneNames=nameOne.concat(" and ").concat(nameTwo);
    	String teamTwoNames=nameThree.concat(" and ").concat(nameFour);
    	
    	//Put the team names into Extras for the intent and give a small toast notificiaton
    	//showing the teams
    	
    	MainActivity.teamNames[0] = teamOneNames;
    	MainActivity.teamNames[1] = teamTwoNames;
    	
    	
    	String toastNotification="The teams are:\nTeam One: ".concat(teamOneNames).concat("\nTeam Two: ").concat(teamTwoNames);
    	Toast.makeText(this, toastNotification, Toast.LENGTH_LONG).show();
    	
    	//start the activity
    	startActivity(intentToPlayRoundOne);
    	
    }
    }
