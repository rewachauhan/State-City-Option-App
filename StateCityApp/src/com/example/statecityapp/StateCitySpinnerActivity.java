package com.example.statecityapp;

import java.util.ArrayList;
import java.util.List;

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

public class StateCitySpinnerActivity extends Activity {
	Spinner sp;
	String statename="";
	Button b,b1;
	int pos;
	ArrayList<String> labels,labels1;
	ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_city_spinner);
        b=(Button) findViewById(R.id.button1);
        b1=(Button) findViewById(R.id.button2);
        sp=(Spinner) findViewById(R.id.spinner1);
       
        
        labels = new ArrayList<String>();
        labels1= new ArrayList<String>();
        SQLiteDatabase mydatabase = openOrCreateDatabase("db.dat",MODE_PRIVATE,null);
        String sql="SELECT * FROM State;";
        Cursor cs=mydatabase.rawQuery(sql,null);
        
        cs.moveToFirst();
        labels.add("Select state");
        while(!cs.isAfterLast())
        {
        	labels.add(cs.getString(1));
        	cs.moveToNext();
        }
        aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,labels);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//if(!statename.equals("select state"))
				//{
					statename=arg0.getSelectedItem().toString();
					//pos=arg0.getSelectedItemPosition();
					
					
				
				//}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),StateCitySelectionActivity.class);
				startActivity(i);
			}
		});
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!statename.equals("select state"))
				{
				Intent i=new Intent(getApplicationContext(),DisplayCityActivity.class);
				i.putExtra("pos", statename);
				startActivity(i);
				}
				else{
					Toast.makeText(getApplicationContext(), "state not selected", Toast.LENGTH_LONG).show();
				}
				
			}
		});
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.state_city_spinner, menu);
        return true;
    }
    
}
