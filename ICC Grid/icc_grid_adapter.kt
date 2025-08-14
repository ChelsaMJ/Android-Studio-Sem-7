package com.example.unit1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.recyclerview.widget.RecyclerView
import kotlin.jvm.java

class icc_grid_adapter(
    private val context: Context,
    private val teamList: List<icc_teams>
) : RecyclerView.Adapter<icc_grid_adapter.TeamViewHolder>() {

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageTeam: ImageView = itemView.findViewById(R.id.imageTeam)
        val textTeamName: TextView = itemView.findViewById(R.id.textTeamName)
        val textTeamInfo: TextView = itemView.findViewById(R.id.textTeamInfo)
        val ratingBar: AppCompatRatingBar = itemView.findViewById(R.id.ratingBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.icc_grid_items, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teamList[position]
        holder.imageTeam.setImageResource(team.imageResId)
        holder.textTeamName.text = team.name
        holder.textTeamInfo.text = team.info
        holder.ratingBar.rating = 3.5f // Example rating

        // Card click → open details
        holder.itemView.setOnClickListener {
            val intent = Intent(context, icc_team_details::class.java).apply {
                putExtra("imageResId", team.imageResId)
                putExtra("name", team.name)
                putExtra("info", team.info)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = teamList.size
}
