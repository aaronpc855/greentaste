# 🥗 GreenTaste

**GreenTaste** es una aplicación móvil nativa desarrollada en **Android (Kotlin)** orientada a la promoción de la alimentación saludable y sostenible. La plataforma permite a los usuarios explorar catálogos de productos nutritivos organizados por categorías, gestionar un carrito de compras dinámico y consumir servicios web externos mediante una arquitectura moderna.

---

## 📱 Características Principales

* **Autenticación y Persistencia Local:** Control de sesión de usuario optimizado utilizando **Jetpack DataStore (Preferences)** y gestión de perfiles locales.
* **Catálogo por Categorías:** Visualización dinámica de productos saludables clasificados (Desayunos, Almuerzos, cenas y bebidas) mediante *LazyVerticalGrid*.
* **Gestión de Carrito y Compras:** Carrito interactivo implementado con *ViewModel* para cálculo de subtotales, costos de envío y control de cantidades.
* **Consumo de API REST:** Integración con servicios remotos alojados en backend (AlwaysData) utilizando **Retrofit** y **Gson** para operaciones CRUD en tiempo real.
* **Interfaz Moderna (Jetpack Compose):** Diseño UI completamente fluido y adaptativo con animaciones personalizadas, *HorizontalPager* interactivo y componentes de Material Design 3.

---

## 🛠️ Tecnologías y Stack Tecnológico

* **Lenguaje:** [Kotlin 1.9](https://kotlinlang.org/)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) & Material Design 3
* **Arquitectura:** MVVM (Model-View-ViewModel) con Corrutinas y Flow
* **Navegación:** Jetpack Navigation Compose
* **Gestión de Estado y Datos:** Jetpack DataStore (Preferences)
* **Redes y Conectividad:** Retrofit 2, GSON Converter
* **Carga de Imágenes:** Coil
* **Entorno:** Android Studio (Gradle 8.2 / Kotlin Compiler Extension 1.5.1)

---

## 📂 Arquitectura del Proyecto

La estructura del código fuente sigue buenas prácticas de separación de responsabilidades:

```text
com.aaronpereyra.greentastecompose/
├── data/
│   ├── datastore/       # Control de preferencias locales (UserStore)
│   ├── local/           # Fuentes de datos locales (LocalDataSource)
│   ├── models/          # Modelos de datos específicos (CartItem)
│   ├── remote/          # Definición de servicios API (ApiService)
│   └── repository/      # Repositorio central de datos (MainRepository)
├── models/              # Modelos de datos globales (FoodProduct, Category, etc.)
├── navigation/          # Configuración del grafo de navegación (AppNavigation)
├── ui/
│   ├── components/      # Componentes reutilizables (AppBottomBar)
│   └── screens/         # Pantallas principales (Home, Cart, Profile, Login, Detail)
├── utils/               # Constantes globales de conexión (Constants)
└── viewmodel/           # Gestión de estado UI (MainViewModel, CartViewModel)
