package com.example.transitions

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class BoundService: Service() {

    private val binder = LocalBinder()

    inner class LocalBinder: Binder() {
        fun getService(): BoundService = this@BoundService}

    override fun onBind(p0: Intent?): IBinder? {

        return binder
    }

    fun getWelcomeMessage(): String {
        return "Welcome to the Bound Service!"
    }
}