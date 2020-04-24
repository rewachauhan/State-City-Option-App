package com.example.statecityapp;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DisplayCityActivity extends Activity {
	Spinner sp;
	Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_city);
		sp= (Spinner) findViewById(R.id.spinner1);
		b=(Button) findViewById(R.id.button1);
		String ind=getIntent().getStringExtra("pos");
		ArrayList<String> labels = new ArrayList<String>();
        Toast.makeText(getApplicationContext(), ind, Toast.LENGTH_LONG).show();
        SQLiteDatabase mydatabase = openOrCreateDatabase("db.dat",MODE_PRIVATE,null);
        String sql="SELECT Cname FROM State s,City c where s.Stateid=c.Stateid and Sname='"+ind+"';";
        Cursor cs=mydatabase.rawQuery(sql,null);
        
        cs.moveToFirst();
        labels.add("Select city");
        while(!cs.isAfterLast())
        {
        	labels.add(cs.getString(0));
        	cs.moveToNext();
        }
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,labels);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),StateCitySpinnerActivity.class);
				startActivity(i);
				finish();
			}
		});
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String cityname=arg0.getSelectedItem().toString();
				Toast.makeText(getApplicationContext(),"you've selected:"+cityname,Toast.LENGTH_LONG).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_city, menu);
		return true;
	}

}
