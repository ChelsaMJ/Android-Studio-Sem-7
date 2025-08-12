package com.example.unit1

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class timer : AppCompatActivity() {

    private lateinit var timers: List<TextView>
    private var countdownTimers = mutableListOf<CountDownTimer?>()
    private val startTimes = listOf(5, 4, 3, 2, 1) // minutes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        timers = listOf(
            findViewById(R.id.timer1),
            findViewById(R.id.timer2),
            findViewById(R.id.timer3),
            findViewById(R.id.timer4),
            findViewById(R.id.timer5)
        )

        countdownTimers.addAll(List(startTimes.size) { null })

        startTimer(0) // start first timer
    }

    private fun startTimer(index: Int) {
        if (index >= startTimes.size) return

        val totalMillis = startTimes[index] * 60 * 1000L
        countdownTimers[index] = object : CountDownTimer(totalMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                timers[index].text = String.format("%d:%02d", minutes, seconds)

                // Trigger next timer when time <= next timer's start time
                if (index + 1 < startTimes.size &&
                    millisUntilFinished <= startTimes[index + 1] * 60 * 1000L &&
                    countdownTimers[index + 1] == null
                ) {
                    startTimer(index + 1)
                }
            }

            override fun onFinish() {
                timers[index].text = "0:00"
            }
        }.start()
    }
}
