package com.example.amv;

import util.Calculator;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class Add3C extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add3_c);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add3_c, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_add3_c,
					container, false);
			return rootView;
		}
	}
	
	public void display3Cresult(View view) throws Exception{
		Intent intent = new Intent(this, ResultAdd3C.class);
		
		
	    EditText editX1 = (EditText)findViewById(R.id.X1Input);
        double x1 = Double.parseDouble(editX1.getText().toString());
        
        EditText editX2 = (EditText)findViewById(R.id.X2Input);
        double x2 = Double.parseDouble(editX2.getText().toString());
        
        EditText editX3 = (EditText)findViewById(R.id.X3Input);
        double x3 = Double.parseDouble(editX3.getText().toString());

        EditText editY1 = (EditText)findViewById(R.id.Y1Input);
        double y1 = Double.parseDouble(editY1.getText().toString());

        EditText editY2 = (EditText)findViewById(R.id.Y2Input);
        double y2 = Double.parseDouble(editY2.getText().toString()); 

        EditText editY3 = (EditText)findViewById(R.id.Y3Input);
        double y3 = Double.parseDouble(editY3.getText().toString());
		
		double result[] = Calculator.add3vectors(x1, y1, x2, y2, x3, y3);
       
		
		String ans = "The result is= \n X: " + result[0] + ", Y: " + result[1];
		intent.putExtra("Result",ans);
		startActivity(intent);
	}

}
