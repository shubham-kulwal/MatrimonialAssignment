package matrimonial.assignment.com.matrimonialassignment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import matrimonial.assignment.com.matrimonialassignment.R;

public class LoginActivity extends AppCompatActivity {

    private TextView login_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        init();
    }


    private void init() {
        login_tv = findViewById(R.id.login_tv);
        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class) ;
                startActivity(intent);
            }
        });
    }
}
