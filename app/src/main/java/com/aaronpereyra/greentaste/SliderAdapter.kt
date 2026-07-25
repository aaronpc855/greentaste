package com.aaronpereyra.greentaste

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SliderAdapter(private val items: List<SliderItem>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo = view.findViewById<TextView>(R.id.tvSliderTitulo)
        val subtitulo = view.findViewById<TextView>(R.id.tvSliderSubtitulo)
        val img1 = view.findViewById<ImageView>(R.id.imgSlider1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_item, parent, false)
        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {

        val item = items[position]

        holder.titulo.text = item.titulo
        holder.subtitulo.text = item.subtitulo

        holder.img1.setImageResource(item.img1)
        holder.img1.clearAnimation()

        // botón solo slider 2
        if (position == 1) {
            holder.subtitulo.setBackgroundResource(R.drawable.bg_slider_button_white)
            holder.subtitulo.setTextColor(Color.parseColor("#333333"))
            holder.subtitulo.setPadding(40, 18, 40, 18)
        } else {
            holder.subtitulo.background = null
            holder.subtitulo.setTextColor(Color.WHITE)
            holder.subtitulo.setPadding(0, 0, 0, 0)
        }
    }

    override fun onViewAttachedToWindow(holder: SliderViewHolder) {
        super.onViewAttachedToWindow(holder)

        val context = holder.itemView.context

        when (holder.adapterPosition) {

            // persona con celular
            0 -> {
                val anim = AnimationUtils.loadAnimation(context, R.anim.float_up_down)
                anim.repeatCount = Animation.INFINITE
                holder.img1.startAnimation(anim)
            }

            // comida vegetariana
            1 -> {
                val anim = AnimationUtils.loadAnimation(context, R.anim.pulse_soft)
                anim.repeatCount = Animation.INFINITE
                holder.img1.startAnimation(anim)
            }

            // combo.png (latido)
            2 -> {
                val anim = AnimationUtils.loadAnimation(context, R.anim.pulse_soft)
                anim.duration = 900
                anim.repeatMode = Animation.REVERSE
                anim.repeatCount = Animation.INFINITE
                holder.img1.startAnimation(anim)
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: SliderViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.img1.clearAnimation()
    }

    override fun getItemCount(): Int = items.size
}