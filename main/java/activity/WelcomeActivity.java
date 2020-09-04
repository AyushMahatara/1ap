package activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.am.augustsnotes.R;

import model.UserInfo;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

      //  String username = getIntent().getStringExtra("username");

      //  UserInfo userInfo = (UserInfo) getIntent().getSerializableExtra("userinfo");

        TextView textview = findViewById(R.id.welcomename);
      //  textview.setText("Hello  pro  dai  "+userInfo.getUsername());
        String username = getIntent().getStringExtra("username");
        textview.setText("Hello, "+ username + "!");
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                startActivity(new Intent(WelcomeActivity.this, ChangeActivity.class));
                break;

            case R.id.power:
                finishAffinity();
                break;

            case R.id.save:
                Toast.makeText(this,"save is clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.about:
              //  Toast.makeText(this,"about is clicked",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(WelcomeActivity.this, AboutActivity.class));
                break;

            case R.id.rate:
                Toast.makeText(this,"rate is clicked",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
