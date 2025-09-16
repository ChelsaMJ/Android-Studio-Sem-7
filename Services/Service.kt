package com.example.transitions

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Service : AppCompatActivity() {

    private var boundService: BoundService? = null
    private var isBound: Boolean = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BoundService.LocalBinder
            boundService = binder.getService()
            isBound = true

            Toast.makeText(
                this@Service,
                boundService?.getWelcomeMessage(),
                Toast.LENGTH_SHORT
            ).show()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
            boundService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        val startStartedService = findViewById<Button>(R.id.btnStartStartedService)
        val stopStartedService = findViewById<Button>(R.id.btnStopStartedService)
        val bindBoundService = findViewById<Button>(R.id.btnBindBoundService)
        val unbindBoundService = findViewById<Button>(R.id.btnUnbindBoundService)
        val startForegroundService = findViewById<Button>(R.id.btnStartForegroundService)
        val stopForegroundService = findViewById<Button>(R.id.btnStopForegroundService)

        startStartedService.setOnClickListener {
            startService(Intent(this, StartedService::class.java))
        }

        stopStartedService.setOnClickListener {
            stopService(Intent(this, StartedService::class.java))
        }

        bindBoundService.setOnClickListener {
            bindService(Intent(this, BoundService::class.java),
                connection,
                BIND_AUTO_CREATE)
        }

        unbindBoundService.setOnClickListener {
            if (isBound) {
                unbindService(connection)
                isBound = false
            }
        }

        startForegroundService.setOnClickListener {
            val intent = Intent(this, ForegroundService::class.java)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                startForegroundService(intent)
            } else {
                startService(intent)
            }
        }

        stopForegroundService.setOnClickListener {
            stopService(Intent(this, ForegroundService::class.java))
        }
    }
}
