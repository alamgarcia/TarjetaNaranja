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
            intent.putExtra("topic", "Boton 1")
            startActivity(intent)
        }
        return view


    }


    companion object {
        fun newInstance(): Contacto = Contacto()
    }



}
