package com.aaronpereyra.greentaste

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    // Esta es la ruta del archivo PHP en tu servidor de AlwaysData
    @GET("productos.php")
    fun getProductos(): Call<List<Producto>>
}