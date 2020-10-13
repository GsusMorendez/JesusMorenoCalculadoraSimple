package com.example.jesusmorenohernandezcalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun empezar(view: View) {

        var nombre = findViewById<EditText>(R.id.editTextNombre).text.toString();
        var apellidos = findViewById<EditText>(R.id.editTextApellidos).text.toString();

        var MiIntent = Intent(this, MainActivity2::class.java)

        MiIntent.putExtra("nombre", nombre);
        MiIntent.putExtra("apellidos", apellidos);
        startActivity(MiIntent);
        finish();
    }

    fun cerrar(view: View) {
        finish();
    }


}