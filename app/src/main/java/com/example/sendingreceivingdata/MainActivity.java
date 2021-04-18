package com.example.sendingreceivingdata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextView textRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textRec = findViewById(R.id.text_rec);
        TextInputEditText editMsg = findViewById(R.id.editMsg);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(view -> {
            String msg = editMsg.getText().toString();
            if(msg.length()>0){
                Intent i = new Intent(this, SecondActivity.class);
                i.putExtra("message",msg);
                startActivityForResult(i,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && resultCode == RESULT_OK){
            String reply = data.getStringExtra("reply");
            textRec.setText(reply);
        }
    }
}