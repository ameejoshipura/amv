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

public class Add3P extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add3_p);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add3, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_add3, container,
					false);
			return rootView;
		}
	}
	
	public void display3Presult(View view) throws Exception{
        Intent intent = new Intent(this, ResultsAddPolar.class);

        EditText editR1 = (EditText)findViewById(R.id.R1Input);
        double r1 = Double.parseDouble(editR1.getText().toString());

        EditText editR2 = (EditText)findViewById(R.id.R2Input);
        double r2 = Double.parseDouble(editR2.getText().toString());

        EditText editR3 = (EditText)findViewById(R.id.R3Input);
        double r3 = Double.parseDouble(editR2.getText().toString());
        
        EditText editT1 = (EditText)findViewById(R.id.T1Input);
        double t1 = Double.parseDouble(editT1.getText().toString());

        EditText editT2 = (EditText)findViewById(R.id.T2Input);
        double t2 = Double.parseDouble(editT2.getText().toString());

        EditText editT3 = (EditText)findViewById(R.id.T3Input);
        double t3 = Double.parseDouble(editT2.getText().toString());
        
        double vector1c[]=Calculator.polarToCartesian(r1, t1);
        double vector2c[]=Calculator.polarToCartesian(r2, t2);
        double vector3c[]=Calculator.polarToCartesian(r3, t3);
        
        double result[] = Calculator.add3vectors(vector1c[0],vector1c[1],vector2c[0],vector2c[1],vector3c[0],vector3c[1]);

        String ans = "The result is= \n R: " + result[0] + ", theta: " + result[1];
        intent.putExtra("Result", ans);

        startActivity(intent);
	}
}
