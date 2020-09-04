package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.am.augustsnotes.R;
import com.google.gson.Gson;

import model.PREF_KEYS;
import model.UserInfo;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }
    public void launchNewActivity(View view) {
        EditText usernameText = findViewById(R.id.username);
        EditText phonenumberText = findViewById(R.id.number);
        EditText passwordText = findViewById(R.id.password);
        EditText passwordText2 = findViewById(R.id.repassword);
        String username = usernameText.getText().toString();
        String phonenumber = phonenumberText.getText().toString();
        String password = passwordText.getText().toString();
        String repassword = passwordText2.getText().toString();

        if(!password.equals(repassword)){
            // error message => Password not matched
            Toast.makeText(this, "password not matched", Toast.LENGTH_LONG).show();
            return;
        }

        if(username.trim().equals("") || phonenumber.length() != 10 || password.equals("")){
            // error message
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
          UserInfo userInfo = new UserInfo(username, phonenumber, password);
      //  intent.putExtra("userinfo", userInfo);
        SharedPreferences preferences = getSharedPreferences(PREF_KEYS.PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(PREF_KEYS.IS_FIRST_TIME,false);
        Gson gson = new Gson();
        editor.putString(PREF_KEYS.USER_INFO, gson.toJson(userInfo));
        editor.apply();

        startActivity(intent);
    }


    public void launchLoginActivity(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}