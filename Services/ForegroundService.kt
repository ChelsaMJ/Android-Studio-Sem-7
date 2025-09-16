package com.example.transitions

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService: Service() {

    private val CHANNEL_ID = "ForegroundServiceChannel"

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification : Notification = NotificationCompat.Builder(
            this, CHANNEL_ID)
            .setContentTitle("Foreground Service")
            .setContentText("Running...")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()

        startForeground(1, notification)
        return START_NOT_STICKY

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }

}