package com.example.amv;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;

import util.Calculator;


public class addTwoVectorsPolar extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_two_vectors_polar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_two_vectors_polar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
            View rootView = inflater.inflate(R.layout.fragment_add_two_vectors_polar, container, false);
            return rootView;
        }
    }

    public void addTVCPolar(View view){
        Intent intent = new Intent(this, polar.class);

        EditText editText = (EditText)findViewById(R.id.R1Input);
        double r1 = Double.parseDouble(editText.getText().toString());

        editText = (EditText)findViewById(R.id.R2Input);
        double r2 = Double.parseDouble(editText.getText().toString());

        editText = (EditText)findViewById(R.id.Theta1Input);
        double t1 = Double.parseDouble(editText.getText().toString());

        editText = (EditText)findViewById(R.id.Theta2Input);
        double t2 = Double.parseDouble(editText.getText().toString());

        String ans="";

        try {
            double[] v1 = Calculator.polarToCartesian(r1, t1);
            double[] v2 = Calculator.polarToCartesian(r2, t2);

            double[] result = Calculator.add2Vectors(v1[0], v1[1], v2[0], v2[1]);
            double[] resPolar = Calculator.cartesianToPolar(result[0], result[1]);

            ans = "The result is= \n R: " + resPolar[0] + ",\n theta: " + resPolar[1];
        } catch(Exception e){
            ans = e.getLocalizedMessage();
        }
        intent.putExtra("Result", ans);

        startActivity(intent);
    }
}
