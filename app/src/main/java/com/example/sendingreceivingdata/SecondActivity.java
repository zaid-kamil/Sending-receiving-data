package com.example.sendingreceivingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textRec = findViewById(R.id.textRec2);
        TextInputEditText editReply = findViewById(R.id.editReply);
        Button btnReply = findViewById(R.id.btnReply);

        // lets receive data from first activity
        Intent i = getIntent();
        String msg = i.getStringExtra("message");
        textRec.setText(msg);

        // send reply back to MainActivity
        btnReply.setOnClickListener(view -> {
            String reply = editReply.getText().toString(); // got the reply
            Intent replyIntent = new Intent();             // created blank intent
            replyIntent.putExtra("reply", reply);     // stored the data in intent
            setResult(RESULT_OK,replyIntent);               // setup result function
            finish();                                       // kill the second activity
        });
    }
}