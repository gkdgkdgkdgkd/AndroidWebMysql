package com.example.androiddemo

class NetworkSettings {
    companion object {
        private const val PORT = "8080"
        private const val HOST = "192.168.43.35"
        const val SIGN_IN = "http://$HOST:$PORT/demo/sign/in"
        const val SIGN_UP = "http://$HOST:$PORT/demo/sign/up"
    }
}