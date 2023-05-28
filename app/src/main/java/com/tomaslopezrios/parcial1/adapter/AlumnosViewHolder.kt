package com.tomaslopezrios.parcial1.adapter

import android.content.DialogInterface.OnClickListener
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tomaslopezrios.parcial1.Alumno
import com.tomaslopezrios.parcial1.databinding.ItemAlumnoBinding

class AlumnosViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemAlumnoBinding.bind(view)

    fun render(alumnoModel: Alumno, onClickListener: (Alumno) -> Unit){
        binding.tvName.text = alumnoModel.name
        binding.tvAge.text = "${alumnoModel.age.toString()} años"
        Glide.with(binding.ivFoto.context).load(alumnoModel.urlPhoto).into(binding.ivFoto)
        itemView.setOnClickListener {onClickListener(alumnoModel)}
    }

}