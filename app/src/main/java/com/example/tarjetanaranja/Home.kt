package com.example.tarjetanaranja

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.avaya.clientplatform.api.ClientPlatform
import com.avaya.clientplatform.api.ClientPlatformFactory
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Method
import com.google.gson.Gson

class Home : AppCompatActivity() {




    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val homeamv_fg = InicioFragment.newInstance()
                openFragment(homeamv_fg)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val homeamv_fg = promosfragment.newInstance()
                openFragment(homeamv_fg)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val homeamv_fg = Contacto.newInstance()
                openFragment(homeamv_fg)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Atencion a Clientes"

        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        obtenertoken()
        val homeamv_fg = Contacto.newInstance()
        openFragment(homeamv_fg)

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun obtenertoken() {
        var myPreferences = "myPrefs"
        var sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
        var displayname = sharedPreferences.getString("displayname", "Prueba")
        var username = sharedPreferences.getString("username", "1234")
        var host = sharedPreferences.getString("host", "amv.collaboratory.avaya.com")
        var puerto = sharedPreferences.getString("puerto", "443")

        //Definimos las variables de URL que tendra nuestra peticion con sus respectivas llaves
        //Key
        var paramKey1 = "displayName"
        //Parametro-Variable
        var paramValue1 = displayname
        //Key
        var paramKey2 = "userName"
        //Parametro Variable
        var paramValue2 = username
        //Invocamos FUEL Manager y lo asignamos a una variable para tener un mejor acceso a el
        val manager: FuelManager by lazy { FuelManager() }
        //Usamos el metodo request de FUUEL Manager, junto a la lusta de parametros
        manager.request(Method.GET, "https://$host:$puerto/avayatest/auth?", listOf(paramKey1 to paramValue1, paramKey2 to paramValue2)).responseString { req, res, result ->
            val (data, error) = result
            //Si no tenemos ningun error, procedemos a hacer la llamada, ya que el servidor respondio con un 200 y tendremos el Token de LLamada
            when (error) {
                null -> {
                    //Imprimimos el Response en el LogCat solo para asegurar que se hizo bien la peticion
                    Log.d("RESPONSES", data)
                    // creamos una variable llamada gson para la Funcion GSON() para que sea mas accesible
                    var gson = Gson()
                    //Asignamos a la variable Login el metodo gson?.fromJson(data, Login.Response::class.java) y le pasamos el response JSON para su conversion a un objeto que Android puede manejar
                    var Login = gson?.fromJson(data, AMVRepsonse::class.java)
                    val myPreferences = "myPrefs"
                    val sharedPreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("sessionid", Login.sessionid)
                    editor.putString("token", data)
                    editor.apply()
                    Log.d("AMV", "Token Creado")
                    Log.d("AMV", "UUID: " + Login.uuid)
                    Log.d("AMV", "SessionID: " + Login.sessionid)

                }
            }
        }
    }


}



object ClientPlatformManager {

    var sClientPlatform: ClientPlatform? = null

    @Synchronized
    fun getClientPlatform(context: Context): ClientPlatform? {

        if (sClientPlatform != null) {
            return sClientPlatform
        }

        sClientPlatform = ClientPlatformFactory.getClientPlatformInterface(context)

        return sClientPlatform
    }

}
