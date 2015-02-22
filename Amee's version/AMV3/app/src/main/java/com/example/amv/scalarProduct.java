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


public class scalarProduct extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scalar_product);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scalar_product, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_scalar_product, container, false);
            return rootView;
        }
    }

    public void scalar(View view){
        Intent intent = new Intent(this, resultScalarProduct.class);

        EditText editText = (EditText)findViewById(R.id.X1Input);
        double x1 = Double.parseDouble(editText.getText().toString());

        editText = (EditText)findViewById(R.id.X2Input);
        double x2 = Double.parseDouble(editText.getText().toString());

        editText = (EditText)findViewById(R.id.Y1Input);
        double y1 = Double.parseDouble(editText.getText().toString());

        editText = (EditText)findViewById(R.id.Y2Input);
        double y2 = Double.parseDouble(editText.getText().toString());

        String ans ="";
        try {
            double result = Calculator.scalarProduct(x1, y1, x2, y2);

            ans = "The result is= \n " + result;
        } catch(Exception e){
            ans = e.getLocalizedMessage();
        }
        intent.putExtra("Result", ans);

        startActivity(intent);
    }
}
