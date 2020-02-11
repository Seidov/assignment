package com.example.assignment.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment.R;
import com.example.assignment.sharedPreference.SaveSharedPreference;
import com.example.assignment.tools.Tools;
import com.example.assignment.model.User;

import java.util.ArrayList;

import static com.example.assignment.sharedPreference.PreferencesUtility.USERNAME_IN_PREF;

public class SignInActivity extends AppCompatActivity {
    EditText usernameText;
    EditText passwordText;
    CardView btnSignIn;

    Tools tools = new Tools();
    ArrayList<User> usersList = new ArrayList<User>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initLayout();

        usernameText.setText(getUsernameInPref());


    }

    private void initLayout() {
        usernameText = findViewById(R.id.user_email_edit_text);
        passwordText = findViewById(R.id.user_password_edit_text);
        btnSignIn = findViewById(R.id.btnSignIn);
    }

    public void signIn(View view) {
        if (mAuth(usernameText.getText().toString(), passwordText.getText().toString())) {

            SaveSharedPreference.setLoggedIn(getApplicationContext(), true);
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();

        }

    }

    public void signOut(View view) {
        SaveSharedPreference.setLoggedIn(getApplicationContext(), false);
    }

    public boolean mAuth(String userNameText, String userPasswordText) {
        boolean bCheckUser = false;
        usersList = tools.getUsersList();

        if (!userNameText.isEmpty() && userNameText != null && !userPasswordText.isEmpty() && userPasswordText != null) {
            if (checkUser(userNameText, userPasswordText, usersList)) {
                bCheckUser = true;
            } else {
                Toast.makeText(this, "Kullanıcı Bulunamadı", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Kullanıcı Bilgileri Eksik", Toast.LENGTH_SHORT).show();
        }

        return bCheckUser;
    }

    public boolean checkUser(String userNameText, String userPasswordText, ArrayList<User> userList) {
        boolean bCheck = false;

        for (User user : userList) {
            if (userNameText.equals(user.getUserName()) && userPasswordText.equals(user.getUserPassword())) {
                bCheck = true;
                setUserNameInPref(userNameText);
                Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
            }
        }
        return bCheck;
    }

    public void setUserNameInPref(String newUser) {
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USERNAME_IN_PREF, newUser);
        editor.commit();
    }

    public String getUsernameInPref() {
        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String username = preferences.getString(USERNAME_IN_PREF, "");
        return username;
    }


}



