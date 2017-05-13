package com.vinita.nutrients;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        /** Called when the user taps the Send button */

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText ethello = (EditText) findViewById(R.id.ethello);
        message=Integer.parseInt(ethello.getText().toString());
        intent.putExtra("message",message);
        startActivity(intent);
    }
}
