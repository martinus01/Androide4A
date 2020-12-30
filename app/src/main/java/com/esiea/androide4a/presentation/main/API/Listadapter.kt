package com.esiea.androide4a.presentation.main.API

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esiea.androide4a.R


class Listadapter(private val values: MutableList<Launch>, private val context: Context) : RecyclerView.Adapter<Listadapter.ViewHolder>() {
    class ViewHolder(var layout: View) : RecyclerView.ViewHolder(layout) {
        var txtmission: TextView
        var txtnet: TextView
        var txtagencies: TextView
        var fuseeimage: ImageView

        init {
            txtmission = layout.findViewById<View>(R.id.titre_mission) as TextView
            txtnet = layout.findViewById<View>(R.id.pad_name) as TextView
            txtagencies = layout.findViewById<View>(R.id.titre_agency) as TextView
            fuseeimage = layout.findViewById<View>(R.id.fusee_image) as ImageView
        }
    }

    fun add(position: Int, item: Launch) {
        values.add(position, item)
        notifyItemInserted(position)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // create a new view
        val inflater = LayoutInflater.from(parent.context)
        val v: View = inflater.inflate(R.layout.section, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val currentLaunch = values[position]
        holder.txtmission.text = currentLaunch.mission
        holder.txtnet.text = currentLaunch.net
        holder.txtagencies.text = currentLaunch.padagencies
        Glide.with(context).load(values[position].fuseeimage).into(holder.fuseeimage)
        holder.fuseeimage.setOnClickListener {
            val intent = Intent(context, infoLaunch::class.java)
            intent.putExtra("rocketname", currentLaunch.rocketname)
            intent.putExtra("rocketconfiguration", currentLaunch.rocketconfiguration)
            intent.putExtra("rocketfamilly", currentLaunch.rocketfamilyname)
            intent.putExtra("rcname", currentLaunch.rcname)
            intent.putExtra("rcabbrev", currentLaunch.rcabbrev)
            intent.putExtra("countrycode", currentLaunch.countryCode)
            intent.putExtra("fuseeimage", currentLaunch.fuseeimage)
            intent.putExtra("agenciesimage", currentLaunch.agencyimage)
            intent.putExtra("mission", currentLaunch.mission)
            intent.putExtra("windowstart", currentLaunch.windowstart)
            intent.putExtra("windowend", currentLaunch.windowend)
            intent.putExtra("net", currentLaunch.net)
            intent.putExtra("location", currentLaunch.location)
            intent.putExtra("padname", currentLaunch.padname)
            intent.putExtra("latitude", currentLaunch.latitude)
            intent.putExtra("longitude", currentLaunch.longitude)
            intent.putExtra("padagencies", currentLaunch.padagencies)
            intent.putExtra("missionname", currentLaunch.missionname)
            intent.putExtra("description", currentLaunch.description)
            intent.putExtra("typemission", currentLaunch.typemission)
            intent.putExtra("lspname", currentLaunch.lspname)
            intent.putExtra("lspcountrycode", currentLaunch.countryCode)
            intent.putExtra("agenciesname", currentLaunch.agenciesname)
            intent.putExtra("lspabrrev", currentLaunch.lspabbrev)
            intent.putExtra("agenciesabbrev", currentLaunch.agenciesabbrev)
            context.startActivity(intent)
            /*
                        Intent myIntent=new Intent(LaunchActivity.this, infoLaunch.class);
                         myIntent.putExtra("key",value);
                        LaunchActivity.this.startActivity(myIntent);
    */
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return values.size
    }/*
    fun setArticles(articles:MutableList<RestLaunchResponse>){
        RestLaunchResponse=articles
        notifyDataSetChanged()
    }*/
}