package com.aaronpereyra.greentaste

data class Platillo(
    val nombre: String,
    val descripcion: String,
    val precio: String,
    val tiempo: String,
    val calificacion: String,
    val imagenResId: Int,
    var esFavorito: Boolean = false
)