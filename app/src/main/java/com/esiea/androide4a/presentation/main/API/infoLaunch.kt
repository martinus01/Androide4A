package com.esiea.androide4a.presentation.main.API

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.esiea.androide4a.R
import com.squareup.picasso.Picasso


class infoLaunch : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_info)


/*
    private void setter(String txtrocketname, String txtrocketconfiguration, String txtrocketfamilly, String txtrcname,
                     String txtrcabbrev, String txtcountrycode, String txtfuseeimage, String txtagenciesimage,
                     String txtmission, String txtwindowstart, String txtwindowend, String txtnet,
                     String txtlocation, String txtpadname, String txtlatitude, String txtlongitude,
                     String txtpadagencies, String txtmissionname, String txtdescription,
                     String txttypemission, String txtlspname, String txtlspabrrev,
                     String txtlspcountrycode, String txtagenciesname, String txtagenciesabbrev) {
*/
        val intent: Intent = getIntent()
        val txtrocketname = intent.getStringExtra("rocketname")
        val txtrocketconfiguration = intent.getStringExtra("rocketconfiguration")
        val txtrocketfamilly = intent.getStringExtra("rocketfamilly")
        val txtrcname = intent.getStringExtra("rcname")
        val txtrcabbrev = intent.getStringExtra("rcabbrev")
        val txtcountrycode = intent.getStringExtra("countrycode")
        val txtfuseeimage = intent.getStringExtra("fuseeimage")
        val txtagenciesimage = intent.getStringExtra("agenciesimage")
        val txtmission = intent.getStringExtra("mission")
        val txtwindowstart = intent.getStringExtra("windowstart")
        val txtwindowend = intent.getStringExtra("windowend")
        val txtnet = intent.getStringExtra("net")
        val txtlocation = intent.getStringExtra("location")
        val txtpadname = intent.getStringExtra("padname")
        val txtlatitude = intent.getStringExtra("latitude")
        val txtlongitude = intent.getStringExtra("longitude")
        val txtpadagencies = intent.getStringExtra("padagencies")
        val txtmissionname = intent.getStringExtra("missionname")
        val txtdescription = intent.getStringExtra("description")
        val txttypemission = intent.getStringExtra("typemission")
        val txtlspname = intent.getStringExtra("lspname")
        val txtlspcountrycode = intent.getStringExtra("lspcountrycode")
        val txtagenciesname = intent.getStringExtra("agenciesname")
        val txtlspabrrev = intent.getStringExtra("lspabrrev")
        val txtagenciesabbrev = intent.getStringExtra("agenciesabbrev")
        val padagencies = findViewById<View>(R.id.padagencies) as TextView
        padagencies.text = txtpadagencies
        val missionname = findViewById<View>(R.id.titre_mission) as TextView
        missionname.text = txtmissionname
        val description = findViewById<View>(R.id.typemission) as TextView
        description.text = txtdescription
        val typemission = findViewById<View>(R.id.description) as TextView
        typemission.text = txttypemission
        val lspname = findViewById<View>(R.id.lspname) as TextView
        lspname.text = txtlspname
        val lspabrrev = findViewById<View>(R.id.lspabrrev) as TextView
        lspabrrev.text = txtlspabrrev
        val lspcountrycode = findViewById<View>(R.id.lspcountrycode) as TextView
        lspcountrycode.text = txtlspcountrycode
        val agenciesname = findViewById<View>(R.id.agenciesname) as TextView
        agenciesname.text = txtagenciesname
        val agenciesabbrev = findViewById<View>(R.id.agenciesabbrev) as TextView
        agenciesabbrev.text = txtagenciesabbrev
        val location = findViewById<View>(R.id.location) as TextView
        location.text = txtlocation
        val padname = findViewById<View>(R.id.padname) as TextView
        padname.text = txtpadname
        val rocketfamilly = findViewById<View>(R.id.rocketfamilyname) as TextView
        rocketfamilly.text = txtrocketfamilly
        val latitude = findViewById<View>(R.id.latitude) as TextView
        latitude.text = txtlatitude
        val rocketname = findViewById<View>(R.id.rocketname) as TextView
        rocketname.text = txtrocketname
        val rocketconfiguration = findViewById<View>(R.id.rocketconfiguration) as TextView
        rocketconfiguration.text = txtrocketconfiguration
        val rcname = findViewById<View>(R.id.rcname) as TextView
        rcname.text = txtrcname
        val rcabbrev = findViewById<View>(R.id.rcabbrev) as TextView
        rcabbrev.text = txtrcabbrev
        val countrycode = findViewById<View>(R.id.rccountrycode) as TextView
        countrycode.text = txtcountrycode
        val mission = findViewById<View>(R.id.missionname) as TextView
        mission.text = txtmission
        val windowstart = findViewById<View>(R.id.windowstart) as TextView
        windowstart.text = txtwindowstart
        val windowend = findViewById<View>(R.id.windowend) as TextView
        windowend.text = txtwindowend
        val net = findViewById<View>(R.id.windownet) as TextView
        net.text = txtnet
        val longitude = findViewById<View>(R.id.longitude) as TextView
        longitude.text = txtlongitude
        val fuseeimage = findViewById<View>(R.id.fusee_image) as ImageView
        Picasso.with(this)
            .load(txtfuseeimage)
            .into(fuseeimage)
        val agenciesimage = findViewById<View>(R.id.agencies_image) as ImageView
        Picasso.with(this)
            .load(txtagenciesimage)
            .into(agenciesimage)
    }
}