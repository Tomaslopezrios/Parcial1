package com.tomaslopezrios.parcial1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomaslopezrios.parcial1.Alumno
import com.tomaslopezrios.parcial1.R

class AlumnosAdapter(
    private var alumnos: MutableList<Alumno>, private val onClickListener: (Alumno) -> Unit) : RecyclerView.Adapter<AlumnosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlumnosViewHolder(layoutInflater.inflate(R.layout.item_alumno,parent,false))
    }

    override fun getItemCount(): Int {
        return alumnos.size
    }

    override fun onBindViewHolder(holder: AlumnosViewHolder, position: Int) {
        val alumno = alumnos[position]
        holder.render(alumno,onClickListener)
    }


}