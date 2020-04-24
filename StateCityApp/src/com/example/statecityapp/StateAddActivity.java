package com.example.statecityapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StateAddActivity extends Activity {
	EditText et1;
	Button bt1,bt2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_state_add);
		et1=(EditText) findViewById(R.id.editText1);
		bt1=(Button) findViewById(R.id.button1);
		bt2=(Button) findViewById(R.id.button2);	
		bt1.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String snm;;
				snm=et1.getText().toString();
				
				String sql="INSERT INTO State(Sname) VALUES('"+snm+"');";
				SQLiteDatabase mydatabase = openOrCreateDatabase("db.dat",MODE_PRIVATE,null);
				mydatabase.execSQL(sql);
				Toast.makeText(getApplicationContext(),"state added successfully",Toast.LENGTH_LONG).show();
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(StateAddActivity.this,StateCitySelectionActivity.class);	
				startActivity(i);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.state_add, menu);
		return true;
	}

}
