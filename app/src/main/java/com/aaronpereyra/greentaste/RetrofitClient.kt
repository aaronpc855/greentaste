package com.aaronpereyra.greentaste

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // Hemos quitado "productos.php" de aquí porque eso va en el ApiService
    // La BASE_URL siempre debe terminar en /
    private const val BASE_URL = "https://aaronpatrimonio.alwaysdata.net/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}