package com.tomaslopezrios.parcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val etName = findViewById<EditText>(R.id.etName)

        // En caso de presionar el botón y hayan ingresado algun nombre pasa a la pantalla del
        // recyclerView

        btnStart.setOnClickListener {
            val name = etName.text.toString()
            if (name.isNotEmpty()){
                val intent = Intent(this, RecyclerViewActivity::class.java)
                intent.putExtra("CURRENT_NAME",name)
                startActivity(intent)
            }
        }

    }
}