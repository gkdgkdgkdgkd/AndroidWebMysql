package com.example.androiddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.androiddemo.databinding.ActivityMainBinding
import com.fasterxml.jackson.databind.ObjectMapper
import java.lang.Exception
import java.util.concurrent.FutureTask

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mapper = ObjectMapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun signIn(view: View) {
        val name = binding.editTextName.text.toString()
        val password = binding.editTextPassword.text.toString()
        val signInTask = FutureTask(NetworkThread(name, password, NetworkSettings.SIGN_IN))
        val thread = Thread(signInTask)
        thread.start()
        try {
            val body = mapper.readValue(signInTask.get(), ResponseBody::class.java)
            Toast.makeText(
                applicationContext,
                if (body.code == 200) "登录成功" else "登录失败",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun signUp(view: View) {
        val name = binding.editTextName.text.toString()
        val password = binding.editTextPassword.text.toString()
        val signUpTask = FutureTask(NetworkThread(name, password, NetworkSettings.SIGN_UP))
        val thread = Thread(signUpTask)
        thread.start()
        try {
            val body = mapper.readValue(signUpTask.get(), ResponseBody::class.java)
            Toast.makeText(
                applicationContext,
                if (body.code == 200) "注册成功" else "注册失败",
                Toast.LENGTH_SHORT
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}