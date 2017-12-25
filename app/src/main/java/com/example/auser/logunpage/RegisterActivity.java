package com.example.auser.logunpage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    public static final String PREF = "PREF";
    public static final String PREF_USERNAME = "UserName";
    public static final String PREF_PASSWORD = "Password";
    EditText edUserName,edPassword,edEmail,edAge;
    Button btnRegister;
    Intent intent;
    Context context = this;

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences(PREF, 0);
        settings.edit().putString(PREF_USERNAME,edUserName.getText().toString()).commit();
        settings.edit().putString(PREF_PASSWORD,edPassword.getText().toString()).commit();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
    }

    void findViews() {
        edUserName = (EditText) findViewById(R.id.etUserName);
        edPassword = (EditText) findViewById(R.id.etPassword);
        edEmail = (EditText) findViewById(R.id.etEmail);
        edAge = (EditText) findViewById(R.id.etAge);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (edUserName.getText().toString().equals("") || edPassword.getText().toString().equals("") || edEmail.getText().toString().equals("") || edAge.getText().toString().equals(""))
                Toast.makeText(context, "欄位不可空白", Toast.LENGTH_SHORT).show();
            else {
                intent = new Intent();
                intent.setClass(RegisterActivity.this ,UserHomePage.class);
                startActivity(intent);
            }
        }
    };

}
