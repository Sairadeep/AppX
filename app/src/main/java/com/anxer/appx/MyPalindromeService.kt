package com.anxer.appx

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyPalindromeService : Service() {

    private var binder = object : IvAidlInterface.Stub() {
        override fun getUseremailName(name: String): String {
            return name.reversed().toString()
        }
    }

    override fun onBind(p0: Intent?): IBinder {
        return binder
    }
}