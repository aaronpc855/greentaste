package com.aaronpereyra.greentaste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductoAdapter(private val productos: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Vinculamos con los IDs exactos de tu XML
        val nombre: TextView = view.findViewById(R.id.tvNombreProducto)
        val precio: TextView = view.findViewById(R.id.tvPrecioProducto)
        // Corregido: ivProducto cambiado a imgProducto para que coincida con tu XML
        val imagen: ImageView = view.findViewById(R.id.imgProducto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = productos[position]
        holder.nombre.text = producto.nombre
        holder.precio.text = "S/ ${producto.precio}"

        // Carga la imagen desde la URL de AlwaysData usando Glide
        Glide.with(holder.itemView.context)
            .load(producto.imagen_url)
            .placeholder(android.R.drawable.progress_horizontal) // Opcional: mientras carga
            .error(android.R.drawable.stat_notify_error)       // Opcional: si falla la URL
            .into(holder.imagen)
    }

    override fun getItemCount() = productos.size
}
