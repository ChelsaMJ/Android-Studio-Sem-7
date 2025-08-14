package com.example.unit1

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlin.jvm.java

class icc_teams_adapter(
    private val context: Context,
    private val teamList: List<icc_teams>
) : BaseAdapter() {

    override fun getCount(): Int = teamList.size
    override fun getItem(position: Int): Any = teamList[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.icc_teams_items, parent, false)

        val imageTeam: ImageView = view.findViewById(R.id.imageTeam)
        val textTeamName: TextView = view.findViewById(R.id.textTeamName)
        val textTeamInfo: TextView = view.findViewById(R.id.textTeamInfo)

        val team = teamList[position]
        imageTeam.setImageResource(team.imageResId)
        textTeamName.text = team.name
        textTeamInfo.text = team.info

        // Click listener with PendingIntent
        view.setOnClickListener {
            val intent = Intent(context, icc_team_details::class.java).apply {
                putExtra("imageResId", team.imageResId)
                putExtra("name", team.name)
                putExtra("info", team.info)
            }

            val pendingIntent = PendingIntent.getActivity(
                context,
                position, // unique request code
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            pendingIntent.send() // triggers the intent
        }

        return view
    }

}
