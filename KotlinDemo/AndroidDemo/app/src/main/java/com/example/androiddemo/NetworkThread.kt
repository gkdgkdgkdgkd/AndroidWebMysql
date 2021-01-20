package com.example.androiddemo

import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.concurrent.Callable

class NetworkThread(var name:String,var password:String,var url:String):Callable<String> {
    override fun call(): String {
        return try{
            val connection = URL(url).openConnection() as HttpURLConnection
            val data = "name="+URLEncoder.encode(name,Charsets.UTF_8.toString())+"&password="+URLEncoder.encode(password,Charsets.UTF_8.toString())
            connection.requestMethod = "POST"
            connection.doInput = true
            connection.doOutput = true
            connection.outputStream.write(data.toByteArray(Charsets.UTF_8))
            val bytes = ByteArray(1024)
            val len = connection.inputStream.read(bytes)
            String(bytes,0,len,Charsets.UTF_8)
        }catch (e:Exception){
            e.printStackTrace()
            ""
        }
    }
}