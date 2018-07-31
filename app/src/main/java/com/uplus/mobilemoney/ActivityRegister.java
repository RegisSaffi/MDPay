package com.uplus.mobilemoney;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityRegister extends AppCompatActivity {

    Button next;
    EditText phone;
    SharedPreferences shared;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        next=(Button) findViewById(R.id.next);
        phone=(EditText) findViewById(R.id.phone);
        shared=getSharedPreferences("shared",MODE_PRIVATE);
        if(shared.contains("phone"))
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!phone.getText().toString().equals("")) {

                    SharedPreferences.Editor editor=shared.edit();
                    editor.putString("phone",phone.getText().toString());
                    editor.commit();

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"enter phone",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
