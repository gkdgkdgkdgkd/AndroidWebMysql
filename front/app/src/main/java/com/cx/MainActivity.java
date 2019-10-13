package com.cx;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signin = (Button) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.etname)).getText().toString();
                String password = ((EditText) findViewById(R.id.etpassword)).getText().toString();
                if (UserService.signIn(name, password))
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        Button signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.etname)).getText().toString();
                String password = ((EditText) findViewById(R.id.etpassword)).getText().toString();
                if (UserService.signUp(name, password))
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        }
                    });
                else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
