package com.tomaslopezrios.parcial1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomaslopezrios.parcial1.adapter.AlumnosAdapter
import com.tomaslopezrios.parcial1.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val bundle = intent.extras
        val currentName = bundle?.getString("CURRENT_NAME", "No name")
        val currentAlumno = Alumno(
            currentName.toString(),
            38,
            "https://logowik.com/content/uploads/images/949_anonymous_logo.jpg"
        )
        AlumnoProvider.Alumnos.add(0, currentAlumno)

        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)

        binding.recyclerView.layoutManager = manager
        binding.recyclerView.adapter = AlumnosAdapter(AlumnoProvider.Alumnos) { alumno ->
            onItemSelected(alumno)
        }

    }

    private fun onItemSelected(alumno: Alumno) {
        val intent = Intent(this, DetailAlumnoActivity::class.java)
        intent.putExtra("NAME", alumno.name)
        intent.putExtra("AGE", alumno.age)
        intent.putExtra("URL", alumno.urlPhoto)
        startActivity(intent)
    }
}