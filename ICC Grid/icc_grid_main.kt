package com.example.unit1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class icc_grid_main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.icc_grid_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewTeams)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns

        val teamList = listOf(
            icc_teams(R.drawable.india, "India", "Rank 1 | ICC ODI Team"),
            icc_teams(R.drawable.australia, "Australia", "Rank 2 | ICC ODI Team"),
            icc_teams(R.drawable.england, "England", "Rank 3 | ICC ODI Team"),
            icc_teams(R.drawable.southafrica, "South Africa", "Rank 4 | ICC ODI Team"),
            icc_teams(R.drawable.newzealand, "New Zealand", "Rank 5 | ICC ODI Team"),
            icc_teams(R.drawable.pakistan, "Pakistan", "Rank 6 | ICC ODI Team"),
            icc_teams(R.drawable.srilanka, "Sri Lanka", "Rank 7 | ICC ODI Team"),
            icc_teams(R.drawable.bangladesh, "Bangladesh", "Rank 8 | ICC ODI Team"),
            icc_teams(R.drawable.afghanistan, "Afghanistan", "Rank 9 | ICC ODI Team"),
            icc_teams(R.drawable.westindies, "West Indies", "Rank 10 | ICC ODI Team")
        )

        recyclerView.adapter = icc_grid_adapter(this, teamList)
    }
}
