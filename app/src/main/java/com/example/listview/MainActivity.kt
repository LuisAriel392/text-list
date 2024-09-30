package com.example.listview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Datos de platillos con imágenes
    val platillos = listOf(
        Platillo("Italia: Pizza Margherita", R.drawable.pizza), // Asegúrate de tener la imagen en drawable
        Platillo("México: Tacos al Pastor", R.drawable.tacos),
        Platillo("Japón: Sushi", R.drawable.sushi),
        Platillo("India: Pollo Tikka Masala", R.drawable.pollo_tikka),
        Platillo("España: Paella", R.drawable.paella),
        Platillo("Perú: Ceviche", R.drawable.ceviche),
        Platillo("Argentina: Asado", R.drawable.asado),
        Platillo("Tailandia: Pad Thai", R.drawable.pad_thai),
        Platillo("Grecia: Moussaka", R.drawable.moussaka)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el adaptador personalizado
        val adapter = PlatilloAdapter(platillos)
        binding.platillos.adapter = adapter
    }

    // Adaptador personalizado para el ListView
    class PlatilloAdapter(private val platillos: List<Platillo>) : BaseAdapter() {

        override fun getCount(): Int = platillos.size

        override fun getItem(position: Int): Platillo = platillos[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

            // Referencias a los elementos del layout
            val imageView = view.findViewById<ImageView>(R.id.platilloImage)
            val textView = view.findViewById<TextView>(R.id.platilloName)

            // Asignar valores
            val platillo = getItem(position)
            textView.text = platillo.name
            imageView.setImageResource(platillo.imageResId)

            return view
        }
    }

    // Clase Platillo
    data class Platillo(val name: String, val imageResId: Int)
}

