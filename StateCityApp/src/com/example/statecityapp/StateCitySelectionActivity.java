package com.example.statecityapp;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StateCitySelectionActivity extends Activity {
Button b1,b2,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_state_city_selection);
		b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        SQLiteDatabase mydatabase = openOrCreateDatabase("db.dat",MODE_PRIVATE,null);
		mydatabase.execSQL("CREATE TABLE IF NOT EXISTS State(Stateid Integer Primary Key autoincrement,Sname VARCHAR);");
		mydatabase.execSQL("CREATE TABLE IF NOT EXISTS City(Cityid Integer Primary Key autoincrement,Stateid Integer,Cname VARCHAR);");
		
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(StateCitySelectionActivity.this,StateAddActivity.class);
				
				startActivity(i);
			}
		});
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i2=new Intent(StateCitySelectionActivity.this,CityAddActivity.class);
				
				startActivity(i2);
			}
		});
        b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i3=new Intent(StateCitySelectionActivity.this,StateCitySpinnerActivity.class);
				
				startActivity(i3);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.state_city_selection, menu);
		return true;
	}

}
