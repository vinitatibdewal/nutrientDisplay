package com.vinita.nutrients;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DisplayMessageActivity extends AppCompatActivity {

    TextView tvnext,tvnext1,tvnext2;
    int message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        tvnext = (TextView)findViewById(R.id.tvnext);
        tvnext1 = (TextView)findViewById(R.id.tvnext1);
        tvnext2 = (TextView)findViewById(R.id.tvnext2);
        message = intent.getIntExtra("message",0);
        loadDataFromAsset();
    }
    public void loadDataFromAsset() {

        BufferedReader br = null;
        String fileText = "";
        int lineCtr=0;
        int lineNo=0;
        try {
            String str = "";
            StringBuffer buffer = new StringBuffer();
            AssetManager assetManager = getAssets();
            InputStream stream = assetManager.open("nutrients.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    stream));

            lineCtr = 0;
            while ((str=reader.readLine()) != null)   {
                lineCtr++;
                if (lineCtr==message)
                buffer.append(str);
            }

            fileText = buffer.toString();
            String[] arr = fileText.split("\\t");
            tvnext.setText(new String(arr[1]));
            tvnext1.setText(new String (arr[2]));
            tvnext2.setText(new String(arr[3]));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}