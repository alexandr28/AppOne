package com.acampdev.borisalexandrcamposrios.appone.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.acampdev.borisalexandrcamposrios.appone.R;

public class RegisterForm extends AppCompatActivity {

    Button crear,cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_form);

        crear = (Button) findViewById(R.id.create_account);
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterForm.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        cancelar= (Button) findViewById(R.id.delete_account);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterForm.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
