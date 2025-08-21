package com.example.unit1

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Dashboard2 : AppCompatActivity() {

    private lateinit var notifCount: TextView
    private lateinit var msgCount: TextView
    private lateinit var taskCount: TextView
    private lateinit var earningCount: TextView

    private lateinit var btnInc: ImageButton
    private lateinit var btnDec: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard2)   // connect to your xml file

        // find TextViews
        notifCount = findViewById(R.id.notif_count)
        msgCount = findViewById(R.id.msg_count)
        taskCount = findViewById(R.id.task_count)
        earningCount = findViewById(R.id.earning_count)

        // find Buttons
        btnInc = findViewById(R.id.increment)
        btnDec = findViewById(R.id.decrement)

        // increment button
        btnInc.setOnClickListener {
            updateValues(1)
        }

        // decrement button
        btnDec.setOnClickListener {
            updateValues(-1)
        }
    }

    private fun updateValues(change: Int) {
        // notifications
        val notif = notifCount.text.toString().toInt()
        notifCount.text = (notif + change).toString()

        // messages
        val msg = msgCount.text.toString().toInt()
        msgCount.text = (msg + change).toString()

        // tasks
        val task = taskCount.text.toString().toInt()
        taskCount.text = (task + change).toString()

        // earnings (remove $ before parsing)
        val earningStr = earningCount.text.toString().replace("$", "")
        val earning = earningStr.toInt()
        earningCount.text = "$" + (earning + change)
    }
}
