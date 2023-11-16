package com.android.nbaplay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.android.nbaplay.model.NbaPlayer

class PlayerAdapter(private val context: Context, private val nbaPlayerList: List<NbaPlayer>) : BaseAdapter() {

    override fun getCount(): Int {
        return nbaPlayerList.size
    }

    override fun getItem(position: Int): Any {
        return nbaPlayerList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val holder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_player, parent, false)
            holder = ViewHolder()
            holder.nameTextView = view.findViewById(R.id.txt_nama)
            holder.positionTextView = view.findViewById(R.id.txt_posisi)
            holder.teamTextView = view.findViewById(R.id.txt_team)
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val nbaPlayer = getItem(position) as NbaPlayer

        val fullNmae = nbaPlayer.firstName + nbaPlayer.lastName
        val teamName = nbaPlayer.team?.fullName

        holder.nameTextView.text = fullNmae
        holder.positionTextView.text = nbaPlayer.position
        holder.teamTextView.text = teamName

        return view!!
    }

    private class ViewHolder {
        lateinit var nameTextView: TextView
        lateinit var positionTextView: TextView
        lateinit var teamTextView: TextView
    }
}