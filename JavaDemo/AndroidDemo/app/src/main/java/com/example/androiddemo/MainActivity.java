package com.example.androiddemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androiddemo.databinding.ActivityMainBinding;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void signIn(View view) {
        String name = binding.editTextName.getText().toString();
        String password = binding.editTextPassword.getText().toString();
        FutureTask<String> signInTask = new FutureTask<>(new NetworkThread(name, password, NetworkSettings.SIGN_IN));
        Thread thread = new Thread(signInTask);
        thread.start();
        try {
            ResponseBody body = mapper.readValue(signInTask.get(), ResponseBody.class);
            Toast.makeText(getApplicationContext(), body.getCode() == 200 ? "登录成功" : "登录失败", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signUp(View view) {
        String name = binding.editTextName.getText().toString();
        String password = binding.editTextPassword.getText().toString();
        FutureTask<String> signUpTask = new FutureTask<>(new NetworkThread(name, password, NetworkSettings.SIGN_UP));
        Thread thread = new Thread(signUpTask);
        thread.start();
        try {
            ResponseBody body = mapper.readValue(signUpTask.get(), ResponseBody.class);
            Toast.makeText(getApplicationContext(), body.getCode() == 200 ? "注册成功" : "注册失败", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}