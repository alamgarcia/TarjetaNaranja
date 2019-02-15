package com.example.tarjetanaranja


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contacto.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class Contacto : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_contacto, container, false)

        view.button.setOnClickListener {
            view ->

            val intent = Intent(activity, LlamadaVideo::class.java)
            // Pasar Valores entre Actividades
            intent.putExtra("topic", "Denuncias")
            startActivity(intent)
        }


        view.button2.setOnClickListener {
                view ->

            val intent = Intent(activity, LlamadaVideo::class.java)
            // Pasar Valores entre Actividades
            intent.putExtra("topic", "Claves")
            startActivity(intent)
        }
        view.button3.setOnClickListener {
                view ->

            val intent = Intent(activity, LlamadaVideo::class.java)
            // Pasar Valores entre Actividades
            intent.putExtra("topic", "Saldos a Pagar")
            startActivity(intent)
        }
        view.button4.setOnClickListener {
                view ->

            val intent = Intent(activity, LlamadaVideo::class.java)
            // Pasar Valores entre Actividades
            intent.putExtra("topic", "Saldos disponibles")
            startActivity(intent)
        }
        view.button5.setOnClickListener {
                view ->

            val intent = Intent(activity, LlamadaVideo::class.java)
            // Pasar Valores entre Actividades
            intent.putExtra("topic", "Club la Nacion")
            startActivity(intent)
        }
        view.button6.setOnClickListener {
                view ->

            val intent = Intent(activity, LlamadaVideo::class.java)
            // Pasar Valores entre Actividades
            intent.putExtra("topic", "Galicia Seguros")
            startActivity(intent)
        }
        view.button7.setOnClickListener {
                view ->

            val intent = Intent(activity, LlamadaVideo::class.java)
            // Pasar Valores entre Actividades
            intent.putExtra("topic", "HBO Go")
            startActivity(intent)
        }
        view.button8.setOnClickListener {
                view ->

            val intent = Intent(activity, LlamadaVideo::class.java)
            // Pasar Valores entre Actividades
            intent.putExtra("topic", "Aviso Viaje al Exterior")
            startActivity(intent)
        }

        return view


    }


    companion object {
        fun newInstance(): Contacto = Contacto()
    }



}
