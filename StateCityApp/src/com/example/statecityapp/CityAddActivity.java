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

public class CityAddActivity extends Activity {
	EditText et1,et2;
	Button bt1,bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_city_add);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		bt1=(Button) findViewById(R.id.button1);
		bt2=(Button) findViewById(R.id.button2);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String cnm,sid;
				cnm=et1.getText().toString();
				sid=et2.getText().toString();
				String sql="INSERT INTO City(Cname,Stateid) VALUES('"+cnm+"','"+sid+"');";
				SQLiteDatabase mydatabase = openOrCreateDatabase("db.dat",MODE_PRIVATE,null);
				mydatabase.execSQL(sql);
				Toast.makeText(getApplicationContext(),"city added successfully",Toast.LENGTH_LONG).show();
			}
		});
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i=new Intent(CityAddActivity.this,StateCitySelectionActivity.class);	
			startActivity(i);
			finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.city_add, menu);
		return true;
	}

}
