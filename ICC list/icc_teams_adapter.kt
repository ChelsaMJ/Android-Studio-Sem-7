package com.example.unit1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

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

        return view
    }
}
