/*package com.nkhosla.hand.and.foot.score.keeper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class FinalScores extends Activity {

	//Get the extras from Round 4
	Bundle extras = getIntent().getExtras();

	int roundOneScores[] = extras.getIntArray("roundOneScores");
	int roundTwoScores[]=extras.getIntArray("roundTwoScores");
	int roundThreeScores[]=extras.getIntArray("roundThreeScores");
	int roundFourScores[]=extras.getIntArray("roundFourScores");
	int cumulativeScore[]=extras.getIntArray("cumulativeScore");
	String teamNames[]=extras.getStringArray("teamNames");

	//quick check to make sure previous math for the scores adds up
	teamOneScore=roundOneScores[0]+roundTwoScores[0]+roundThreeScores[0]+roundFourScores[0];
	teamOneScore=roundOneScores[0]+roundTwoScores[0]+roundThreeScores[0]+roundFourScores[0];
	
	if(teamOneScore !=cumulativeScore[0]){
		Toast.makeText(this, "team 1 scores are wrong--check program math", Toast.LENGTH_LONG).show();
	}

	if(teamTwoScore !=cumulativeScore[1]){
		Toast.makeText(this, "team 2 scores are wrong--check program math", Toast.LENGTH_LONG).show();
	}
	
	
















	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_final_scores);
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_final_scores, menu);
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
}



*/