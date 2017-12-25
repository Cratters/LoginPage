package com.example.auser.logunpage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class UserHomePage extends AppCompatActivity {

    String pref_admin = "";
    String pref_password = "";
    TextView tvWelcome;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);
        restorePrefs();
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        tvWelcome.setText("Welcome," + pref_admin.toString());
        Toast.makeText(context, "帳號驗證成功", Toast.LENGTH_SHORT).show();
    }

    private void restorePrefs() {
        SharedPreferences settings = getSharedPreferences(RegisterActivity.PREF, 0);
        pref_admin = settings.getString(RegisterActivity.PREF_USERNAME, "");
        pref_password = settings.getString(RegisterActivity.PREF_PASSWORD, "");
    }
}
