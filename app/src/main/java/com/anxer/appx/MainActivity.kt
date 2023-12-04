package com.anxer.appx

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.anxer.appx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private var aidlInterface: IvAidlInterface? = null
    private var isServiceRunning: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        val intent = Intent(this@MainActivity, MyPalindromeService::class.java)
        isServiceRunning =
            Utils.isServiceRunning(this@MainActivity, MyPalindromeService::class.java)
        if (!isServiceRunning) {
            Log.d("serviceStatus", "Service is starting now..!")
            startService(intent)
        } else {
            Log.d("serviceStatus", "Service is already running")
        }
    }
}