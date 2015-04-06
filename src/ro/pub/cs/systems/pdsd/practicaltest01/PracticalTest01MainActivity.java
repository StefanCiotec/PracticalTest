package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {
	final private static int SECONDARY_ACTIVITY_REQUEST_CODE = 201;
	Integer center_clicks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        final Button top_left = (Button) findViewById(R.id.top_left_button);
		top_left.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView mEdit = (TextView)findViewById(R.id.textView1);
				mEdit.setText(mEdit.getText().toString() + " Top Left");

			}
		 });
		
        final Button top_right = (Button) findViewById(R.id.top_right_button);
		top_right.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView mEdit = (TextView)findViewById(R.id.textView1);
				mEdit.setText(mEdit.getText().toString() + " Top Right");

			}
		 });
		
		final Button center = (Button) findViewById(R.id.center_button);
		center.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView mEdit = (TextView)findViewById(R.id.textView1);
				mEdit.setText(mEdit.getText().toString() + " Center");
				center_clicks++;

			}
		 });
		
		final Button bottom_left = (Button) findViewById(R.id.bottom_left_button);
		bottom_left.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView mEdit = (TextView)findViewById(R.id.textView1);
				mEdit.setText(mEdit.getText().toString() + " Bottom Left");

			}
		 });
		
		final Button bottom_right = (Button) findViewById(R.id.bottom_right_button);
		bottom_right.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView mEdit = (TextView)findViewById(R.id.textView1);
				mEdit.setText(mEdit.getText().toString() + " Bottom Right");

			}
		 });
		
		final Button navigate_button = (Button) findViewById(R.id.navigate_button);
		navigate_button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final TextView mEdit = (TextView)findViewById(R.id.textView1);
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.lab04.intent.action.SecondaryActivity");
				intent.putExtra("total_clicks", mEdit.getText().toString());
				startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
			}
		 });
    }
    
    @Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		  switch(requestCode) {
		    case SECONDARY_ACTIVITY_REQUEST_CODE:
		        Bundle data = intent.getExtras();
		        // process information from data ...
		        Toast.makeText(getApplicationContext(), data.getString("total_clicks") + " " + resultCode, 
		        		   Toast.LENGTH_LONG).show();
		      break;
		 
		      // process other request codes
		  }
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
    
    @Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
	  super.onSaveInstanceState(savedInstanceState);
	  
	  TextView mEdit = (TextView) findViewById(R.id.textView1);
	  savedInstanceState.putString("text", mEdit.getText().toString());
	  savedInstanceState.putString("clicks", center_clicks.toString());
	  center_clicks = Integer.valueOf(center_clicks.toString());
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
	  super.onRestoreInstanceState(savedInstanceState);
	  
	  String text = savedInstanceState.getString("text");
	  TextView mEdit = (TextView) findViewById(R.id.textView1);
	  mEdit.setText(text);
	  
	  String number = savedInstanceState.getString("clicks");
	  Toast.makeText(getApplicationContext(), number, 
   		   Toast.LENGTH_LONG).show();
	}
}
