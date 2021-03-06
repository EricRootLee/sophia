package startappzke.calsheet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CashFlow extends Activity {
	private EditText input1;
	private EditText input2;
	private EditText solution;
	private CashFlow mContext;;
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);

    	mContext = this;
    	
        setContentView(R.layout.cf);
        
        input1 = (EditText) findViewById(R.id.input1);
		input2 = (EditText) findViewById(R.id.input2);
		solution = (EditText) findViewById(R.id.solution);

		// We create an OnClick Event in each button.

		Button Calculate = (Button) findViewById(R.id.button1);
		
		
		
		Calculate.setOnClickListener(new OnClickListener() {

			private AlertDialog show;
   
			public void onClick(View arg0) {

				if ((input1.getText().length() == 0)
						|| (input1.getText().toString() == "")
						|| (input2.getText().length() ==0)
						|| (input2.getText().toString() == ""))
					    {

					show = new AlertDialog.Builder(mContext).setTitle("StartappzKE!! Error")
							.setMessage("Nothing to Calculate")
							.setPositiveButton("OK", null).show();


				} else {

					double result = new Double(input1.getText().toString())
							-new Double(input2.getText().toString());
					        
					
					solution.setText("Cash Flow "+Double.toString((result)));
					
					
					
				}

			}

		});

			
    }
    @Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			startActivity(new Intent(this, MainActivity.class));
			CashFlow.this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
		}

}

