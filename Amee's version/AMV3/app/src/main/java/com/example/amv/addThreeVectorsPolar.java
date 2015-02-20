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


public class addThreeVectorsPolar extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_three_vectors_polar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_three_vectors_polar, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_add_three_vectors_polar, container, false);
            return rootView;
        }
    }

    public void addThreeVCPolar(View view){
        Intent intent = new Intent(this, polar.class);

        EditText editR1 = (EditText)findViewById(R.id.R1Input);
        double r1 = Double.parseDouble(editR1.getText().toString());

        EditText editR2 = (EditText)findViewById(R.id.R2Input);
        double r2 = Double.parseDouble(editR2.getText().toString());

        EditText editR3 = (EditText)findViewById(R.id.R3Input);
        double r3 = Double.parseDouble(editR3.getText().toString());

        EditText editT1 = (EditText)findViewById(R.id.T1Input);
        double t1 = Double.parseDouble(editT1.getText().toString());

        EditText editT2 = (EditText)findViewById(R.id.T2Input);
        double t2 = Double.parseDouble(editT2.getText().toString());

        EditText editT3 = (EditText)findViewById(R.id.T3Input);
        double t3 = Double.parseDouble(editT3.getText().toString());

        double x1 = r1*Math.cos(t1);
        double y1 = r1*Math.sin(t1);

        double x2 = r2*Math.cos(t2);
        double y2 = r2*Math.sin(t2);

        double x3 = r3*Math.cos(t3);
        double y3 = r3*Math.sin(t3);

        double xr = x1+x2+x3;
        double yr = y1+y2+y3;

        double r = Math.sqrt((xr*xr)+(yr*yr));
        double t = Math.atan(yr/xr);

        String ans = "The result is= \n R: " + r + ", theta: " + t;
        intent.putExtra("Result", ans);

        startActivity(intent);
    }
}
