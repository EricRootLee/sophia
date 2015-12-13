package com.elvenware.readtextfile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class ReadTextFileActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		TextView textView = (TextView)findViewById(R.id.textview_data);
		
		String data = readTextFile(this, R.raw.books);
		textView.setText(data);
	}

	public static String readTextFile(Context ctx, int resId)
	{
		InputStream inputStream = ctx.getResources().openRawResource(resId);

		InputStreamReader inputreader = new InputStreamReader(inputStream);
		BufferedReader bufferedreader = new BufferedReader(inputreader);
		String line;
		StringBuilder stringBuilder = new StringBuilder();
		try 
		{
			while (( line = bufferedreader.readLine()) != null) 
			{
				stringBuilder.append(line);
				stringBuilder.append('\n');
			}
		} 
		catch (IOException e) 
		{
			return null;
		}
		return stringBuilder.toString();
	}
}