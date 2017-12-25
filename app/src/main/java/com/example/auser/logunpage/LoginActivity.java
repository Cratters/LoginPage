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

public class LoginActivity extends AppCompatActivity {

    EditText edUserName,edPassword;
    Button btnSingIn;
    TextView tvRegister;
    String pref_admin = "";
    String pref_password = "";
    Intent intent;
    Context context = this;

    private void restorePrefs() {
        SharedPreferences settings = getSharedPreferences(RegisterActivity.PREF, 0);
        pref_admin = settings.getString(RegisterActivity.PREF_USERNAME, "");
        pref_password = settings.getString(RegisterActivity.PREF_PASSWORD, "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        restorePrefs();
    }
    @Override
    protected void onStart() {
        super.onStart();
        restorePrefs();
    }

    void findViews() {
        edUserName = (EditText) findViewById(R.id.editText);
        edPassword = (EditText) findViewById(R.id.editText2);
        btnSingIn = (Button) findViewById(R.id.btnSingIn);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(listener);
        btnSingIn.setOnClickListener(listener);
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.tvRegister:
                    intent = new Intent();
                    intent.setClass(LoginActivity.this ,RegisterActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btnSingIn:
                    checkUser();
                    break;

            }
        }
    };

    void  checkUser() {

        if (edUserName.getText().toString().equals("") || edPassword.getText().toString().equals(""))
            Toast.makeText(context, "欄位不可空白", Toast.LENGTH_SHORT).show();
        else {
            if (!pref_admin.toString().equals(edUserName.getText().toString())) {

                Toast.makeText(context, "帳號驗證失敗", Toast.LENGTH_SHORT).show();

            } else if (!pref_password.toString().equals(edPassword.getText().toString())) {

                Toast.makeText(context, "帳號驗證失敗", Toast.LENGTH_SHORT).show();

            } else {
                intent = new Intent();
                intent.setClass(LoginActivity.this, UserHomePage.class);
                startActivity(intent);
            }
        }
    }
}
