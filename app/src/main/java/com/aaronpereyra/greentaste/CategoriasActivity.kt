package com.aaronpereyra.greentaste

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CategoriasActivity : AppCompatActivity() {

    private lateinit var btnBreakfast: Button
    private lateinit var btnLunch: Button
    private lateinit var btnDinner: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        btnBreakfast = findViewById(R.id.btnBreakfast)
        btnLunch = findViewById(R.id.btnLunch)
        btnDinner = findViewById(R.id.btnDinner)

        findViewById<ImageView>(R.id.btnBack).setOnClickListener { finish() }

        findViewById<View>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            finish()
        }

        activarBoton(btnBreakfast, btnLunch, btnDinner)
        cargarBreakfast()

        btnBreakfast.setOnClickListener {
            activarBoton(btnBreakfast, btnLunch, btnDinner)
            cargarBreakfast()
        }

        btnLunch.setOnClickListener {
            activarBoton(btnLunch, btnBreakfast, btnDinner)
            cargarLunch()
        }

        btnDinner.setOnClickListener {
            activarBoton(btnDinner, btnBreakfast, btnLunch)
            cargarDinner()
        }
    }

    private fun activarBoton(activo: Button, otro1: Button, otro2: Button) {

        activo.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#8BC34A"))
        activo.setTextColor(Color.WHITE)

        otro1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#F2F2F2"))
        otro1.setTextColor(Color.parseColor("#666666"))

        otro2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#F2F2F2"))
        otro2.setTextColor(Color.parseColor("#666666"))
    }

    private fun cargarBreakfast() {
        setupPlato(R.id.plato1, "Tostadas con palta y huevos", "Pan integral tostado con palta.", "S/ 14.50", R.drawable.tostadas_de_pan_y_huevo)
        setupPlato(R.id.plato2, "Omelettes de espinaca", "Tortilla de espinaca fresca.", "S/ 11.00", R.drawable.omelettes_de_espinaca)
        setupPlato(R.id.plato3, "Ensalada de frutas", "Frutas de estación.", "S/ 10.00", R.drawable.ensalada_de_frutas)
        setupPlato(R.id.plato4, "Panqueques de avena", "Panqueques saludables.", "S/ 12.00", R.drawable.panqueques_de_avena)
        setupPlato(R.id.plato5, "Smoothie de arandanos", "Batido natural.", "S/ 9.50", R.drawable.smoothie_de_arandanos)
        setupPlato(R.id.plato6, "Yogurt de granola", "Yogurt con granola.", "S/ 8.50", R.drawable.yogurt_con_granola)
    }

    private fun cargarLunch() {
        setupPlato(R.id.plato1, "Chaufa de trigo", "Arroz integral con vegetales.", "S/ 20.00", R.drawable.chaufa_de_trigo)
        setupPlato(R.id.plato2, "Crema de zapallo", "Crema ligera y natural.", "S/ 13.00", R.drawable.crema_de_zapallo)
        setupPlato(R.id.plato3, "Salmón a la plancha", "Salmón con ensalada fresca.", "S/ 28.00", R.drawable.salmon_a_la_plancha)
        setupPlato(R.id.plato4, "Ensalada César con pollo", "Lechuga, pollo y aderezo.", "S/ 12.50", R.drawable.ensalada_cesar)
        setupPlato(R.id.plato5, "Brochetas de pollo", "Pollo con verduras grill.", "S/ 18.00", R.drawable.brochetas_de_pollo_con_verduras)
        setupPlato(R.id.plato6, "Pasta integral primavera", "Pasta con vegetales.", "S/ 16.00", R.drawable.pasta_integral_primavera)
    }

    private fun cargarDinner() {
        setupPlato(R.id.plato1, "Bowl de quinoa", "Quinoa con vegetales y semillas.", "S/ 18.00", R.drawable.bowl_de_quinoa)
        setupPlato(R.id.plato2, "Poke de atún spicy", "Atún marinado con arroz.", "S/ 22.00", R.drawable.poke_de_atun_spicy)
        setupPlato(R.id.plato3, "Bowl mediterráneo", "Vegetales, hummus y aceitunas.", "S/ 19.00", R.drawable.bowl_mediterraneo)
        setupPlato(R.id.plato4, "Hamburguesa de lentejas", "Vegetal con pan integral.", "S/ 11.54", R.drawable.hamburguesa_de_lentejas)
        setupPlato(R.id.plato5, "Sandwich de tofu", "Tofu grillado y vegetales.", "S/ 14.00", R.drawable.sandwich_de_tofu)
        setupPlato(R.id.plato6, "Hummus de garbanzo", "Crema con tostadas crocantes.", "S/ 10.00", R.drawable.hummus_de_garbanzo)
    }

    private fun setupPlato(containerId: Int, nombre: String, desc: String, precio: String, img: Int) {
        val root = findViewById<View>(containerId)
        root.findViewById<TextView>(R.id.tvNombreProductoCat).text = nombre
        root.findViewById<TextView>(R.id.tvDescripcionProductoCat).text = desc
        root.findViewById<TextView>(R.id.tvPrecioProductoCat).text = precio
        root.findViewById<ImageView>(R.id.imgProductoCat).setImageResource(img)
    }
}