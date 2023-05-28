package com.tomaslopezrios.parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailAlumnoActivity : AppCompatActivity() {

    private lateinit var ivFoto : ImageView
    private lateinit var tvName: TextView
    private lateinit var tvAge: TextView
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_alumno)

        ivFoto = findViewById(R.id.ivFoto)
        tvName = findViewById(R.id.tvName)
        tvAge = findViewById(R.id.tvAge)
        btnBack = findViewById(R.id.btnBack)

        val bundle = intent.extras
        val name=bundle?.getString("NAME", "")
        val age= bundle?.getInt("AGE",0 )
        val url = bundle?.getString("URL", "")

        tvName.text = name
        tvAge.text = "${age.toString()} años"
        Glide.with(applicationContext).load(url).into(ivFoto)
        btnBack.setOnClickListener { onBackPressed()}

    }
}