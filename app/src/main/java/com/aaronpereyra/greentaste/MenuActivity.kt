package com.aaronpereyra.greentaste

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MenuActivity : AppCompatActivity() {

    private lateinit var recomendadosTitulo: TextView
    private lateinit var animSlide: android.view.animation.Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // ---------------- SLIDER ----------------
        val viewPager = findViewById<ViewPager2>(R.id.viewPagerSlider)

        val sliderItems = listOf(
            SliderItem(
                "La comida que amas, con el sabor y la nutrición que tu cuerpo necesita",
                "Explora lo que tenemos para ti",
                R.drawable.persona_con_celular
            ),
            SliderItem(
                "Deliciosa comida saludable a tu gusto",
                "Agrega tu tarjeta",
                R.drawable.comida_vegetariana
            ),
            SliderItem(
                "20% de descuento",
                "Aprovecha tu combo de chaufa de trigo + ensalada de frutas ¡Pruébalo!",
                R.drawable.combo
            )
        )

        viewPager.adapter = SliderAdapter(sliderItems)

        // ---------------- INDICADORES ----------------
        val ind1 = findViewById<View>(R.id.indicador1)
        val ind2 = findViewById<View>(R.id.indicador2)
        val ind3 = findViewById<View>(R.id.indicador3)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

                ind1.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
                ind2.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
                ind3.setBackgroundColor(resources.getColor(android.R.color.darker_gray))

                when (position) {
                    0 -> ind1.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
                    1 -> ind2.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
                    2 -> ind3.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
                }
            }
        })

        // ---------------- BOTÓN BUSCAR (MENU → CATEGORIAS) ----------------
        findViewById<View>(R.id.btnNavBuscar).setOnClickListener {
            val intent = Intent(this, CategoriasActivity::class.java)
            startActivity(intent)

            overridePendingTransition(
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        }

        // ---------------- CATEGORÍAS ----------------
        setupCategoria(R.id.catHamburguesa, "Hamburguesas", R.drawable.hamburguesa_de_lentejas)
        setupCategoria(R.id.catBowl, "Bowls", R.drawable.bowl_vegetariano)
        setupCategoria(R.id.catParrilla, "Parrillas", R.drawable.parrillada_vegetariana)
        setupCategoria(R.id.catBrunch, "Brunch", R.drawable.brunch_vegetariano)
        setupCategoria(R.id.catBebida, "Bebidas", R.drawable.bebida_vegetariana)

        // ---------------- PRODUCTOS ----------------
        setupProducto(R.id.itemLentejas, "Hamburguesa de lentejas", "S/ 11.54", R.drawable.hamburguesa_de_lentejas)
        setupProducto(R.id.itemChaufa, "Chaufa de trigo", "S/ 20.00", R.drawable.chaufa_de_trigo)
        setupProducto(R.id.itemEnsalada, "Ensalada César con pollo", "S/ 12.50", R.drawable.ensalada_cesar)
        setupProducto(R.id.itemPoke, "Poke de atún spicy", "S/ 22.00", R.drawable.poke_de_atun_spicy)

        // ---------------- TEXTO RECOMENDADOS ----------------
        recomendadosTitulo = findViewById(R.id.tvRecomendados)
        animSlide = AnimationUtils.loadAnimation(this, R.anim.float_up_down)
        recomendadosTitulo.startAnimation(animSlide)
    }

    override fun onResume() {
        super.onResume()
        if (::recomendadosTitulo.isInitialized) {
            recomendadosTitulo.startAnimation(animSlide)
        }
    }

    private fun setupCategoria(layoutId: Int, nombre: String, imgRes: Int) {
        val root = findViewById<View>(layoutId)
        root.findViewById<ImageView>(R.id.imgCategoria).setImageResource(imgRes)
        root.findViewById<TextView>(R.id.tvNombreCategoria).text = nombre
    }

    private fun setupProducto(layoutId: Int, nombre: String, precio: String, imgRes: Int) {
        val root = findViewById<View>(layoutId)
        root.findViewById<ImageView>(R.id.imgProducto).setImageResource(imgRes)
        root.findViewById<TextView>(R.id.tvNombreProducto).text = nombre
        root.findViewById<TextView>(R.id.tvPrecioProducto).text = precio
    }
}