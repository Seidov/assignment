package com.example.assignment.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.sharedPreference.SaveSharedPreference;


public class HomeActivity extends AppCompatActivity {
    ImageView imageView;
    CardView btnSignOut;
    TextView textHeader;
    TextView textContent;

    SignInActivity signInActivity = new SignInActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initLayout();

    }

    private void initLayout() {
        imageView = findViewById(R.id.imageView);
        btnSignOut = findViewById(R.id.btnSignOut);
        textHeader = findViewById(R.id.textHeader);
        textContent = findViewById(R.id.textContent);

    }

    public void signOut(View view) {
        mSignOut();
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        mSignOut();

    }

    public void mSignOut(){
        SaveSharedPreference.setLoggedIn(getApplicationContext(), false);
        finish();
    }
}
