package activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.am.augustsnotes.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import model.PREF_KEYS;
import model.UserInfo;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    public void login(View view) {
        TextInputEditText usernameText = findViewById(R.id.username);
        TextInputEditText passwordText = findViewById(R.id.password);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        SharedPreferences preferences = getSharedPreferences(PREF_KEYS.PREF_NAME, MODE_PRIVATE);
      //  String savedusername = preferences.getString(PREF_KEYS.USERNAME, "");
       // String savedpassword = preferences.getString(PREF_KEYS.PASSWORD,"");

        String Info = preferences.getString(PREF_KEYS.USER_INFO, "");
        UserInfo userInfo = new Gson().fromJson(Info,UserInfo.class);

        if (username.equals(userInfo.getUsername()) && password.equals(userInfo.getPassword())) {

            CheckBox checkBox = findViewById(R.id.chechbox);
            if (checkBox.isChecked()){
                SharedPreferences.Editor editor = getSharedPreferences(PREF_KEYS.PREF_NAME, MODE_PRIVATE).edit();
                editor.putBoolean(PREF_KEYS.REMEMBER_PASSWORD,true);
                editor.apply();
            }

            startActivity(new Intent(LoginActivity.this, WelcomeActivity.class).putExtra(PREF_KEYS.PREF_NAME, username));
        }else{
            Toast.makeText(this,"incorrect username or password",Toast.LENGTH_SHORT).show();

        }

    }
}
