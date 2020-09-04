package activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.am.augustsnotes.R;

import java.util.prefs.Preferences;

import model.PREF_KEYS;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME = 2000; // 2 seconds

    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SharedPreferences preferences = getSharedPreferences(PREF_KEYS.PREF_NAME, MODE_PRIVATE);

        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // check if the user is already registered or not
                // if the user is registered, then launch login activity
                // else launch register activity
                if (preferences.getBoolean(PREF_KEYS.IS_FIRST_TIME, true)) {
                    startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
                } else {
                    if(preferences.getBoolean(PREF_KEYS.REMEMBER_PASSWORD, false))
                    {
                        startActivity(new Intent(SplashActivity.this, WelcomeActivity.class).putExtra("username", preferences.getString(PREF_KEYS.USERNAME,"")));
                    }
                    else{
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }}
             }
        }, SPLASH_TIME);
    }
}
