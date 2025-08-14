package com.example.unit1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class icc_team_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_icc_team_details)

        val imageTeam: ImageView = findViewById(R.id.imageTeamDetail)
        val textTeamName: TextView = findViewById(R.id.textTeamNameDetail)
        val textTeamInfo: TextView = findViewById(R.id.textTeamInfoDetail)

        val imageRes = intent.getIntExtra("imageResId", 0)
        val name = intent.getStringExtra("name")
        val info = intent.getStringExtra("info")

        imageTeam.setImageResource(imageRes)
        textTeamName.text = name
        textTeamInfo.text = info
    }
}
