package com.example.jesusmorenohernandezcalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    lateinit var mostrarResultado: TextView;
    var calcu = Calculadora();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Recogemos el nombre que hemos mandado desde la otra actividad y  se lo mandamos a este view:
        var nombre: String? = intent.getStringExtra("nombre").toString();
        var apellidos: String? = intent.getStringExtra("apellidos").toString();
        var user: TextView = findViewById<EditText>(R.id.textViewUsuario);
        user.text = "Bienvenido $nombre $apellidos";
        mostrarResultado = findViewById<EditText>(R.id.textViewResultado);

        //Declaramos todos los botones y, como van a hacer casi lo mismo los unimos en un unico onClick con un when:

        val button = findViewById<Button>(R.id.button0);
        button.setOnClickListener { onClick(button) }
        val button1 = findViewById<Button>(R.id.button1);
        button1.setOnClickListener { onClick(button1) }
        val button2 = findViewById<Button>(R.id.button2);
        button2.setOnClickListener { onClick(button2) }
        val button3 = findViewById<Button>(R.id.button3);
        button3.setOnClickListener { onClick(button3) }
        val button4 = findViewById<Button>(R.id.button4);
        button4.setOnClickListener { onClick(button4) }
        val button5 = findViewById<Button>(R.id.button5);
        button5.setOnClickListener { onClick(button5) }
        val button6 = findViewById<Button>(R.id.button6);
        button6.setOnClickListener { onClick(button6) }
        val button7 = findViewById<Button>(R.id.button7);
        button7.setOnClickListener { onClick(button7) }
        val button8 = findViewById<Button>(R.id.button8);
        button8.setOnClickListener { onClick(button8) }
        val button9 = findViewById<Button>(R.id.button9);
        button9.setOnClickListener { onClick(button9) }
        val buttonS = findViewById<Button>(R.id.buttonSumar);
        buttonS.setOnClickListener { onClick(buttonS) }
        val buttonR = findViewById<Button>(R.id.buttonRestar);
        buttonR.setOnClickListener { onClick(buttonR) }
        val buttonM = findViewById<Button>(R.id.buttonMultiplicacion);
        buttonM.setOnClickListener { onClick(buttonM) }
        val buttonD = findViewById<Button>(R.id.buttonDividir);
        buttonD.setOnClickListener { onClick(buttonD) }
        val buttonI = findViewById<Button>(R.id.buttonIgual);
        buttonI.setOnClickListener { onClick(buttonI) }
        val buttonP = findViewById<Button>(R.id.buttonPunto);
        buttonP.setOnClickListener { onClick(buttonP) }
        val buttonAC = findViewById<Button>(R.id.buttonAC);
        buttonAC.setOnClickListener { onClick(buttonAC) }





    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.button0 -> calcu.añadirNumero("0", mostrarResultado);
            R.id.button1 -> calcu.añadirNumero("1", mostrarResultado);
            R.id.button2 -> calcu.añadirNumero("2", mostrarResultado);
            R.id.button3 -> calcu.añadirNumero("3", mostrarResultado);
            R.id.button4 -> calcu.añadirNumero("4", mostrarResultado);
            R.id.button5 -> calcu.añadirNumero("5", mostrarResultado);
            R.id.button6 -> calcu.añadirNumero("6", mostrarResultado);
            R.id.button7 -> calcu.añadirNumero("7", mostrarResultado);
            R.id.button8 -> calcu.añadirNumero("8", mostrarResultado);
            R.id.button9 -> calcu.añadirNumero("9", mostrarResultado);
            R.id.buttonDividir -> {
                calcu.añadirOperacion("÷", mostrarResultado)
            }
            R.id.buttonMultiplicacion -> {
                calcu.añadirOperacion("x", mostrarResultado)
            }
            R.id.buttonRestar -> {
                calcu.añadirOperacion("-", mostrarResultado)
            }
            R.id.buttonSumar -> {
                calcu.añadirOperacion("+", mostrarResultado)
            }
            R.id.buttonIgual -> {
                calcu.operar(mostrarResultado)
            }
            R.id.buttonPunto -> {
                calcu.añadirNumero(".", mostrarResultado);
            }
            R.id.buttonAC -> {
                calcu.restaurar(mostrarResultado);
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("primero", calcu.primero)
        outState.putString("segundo", calcu.segundo)
        outState.putDouble("resultado", calcu.resultado)
        outState.putBoolean("hayOperacion", calcu.hayOperacion)
        outState.putString("operacion", calcu.operacion)
        outState.putBoolean("sePusoIgual", calcu.sePulsoIgual)
        outState.putBoolean("sePusoIgual", calcu.sePulsoIgual)
        outState.putString("mostrarPantalla", mostrarResultado.text.toString())

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        calcu.primero = savedInstanceState.getString("primero").toString()
        calcu.segundo = savedInstanceState.getString("segundo").toString()
        calcu.resultado = savedInstanceState.getDouble("resultado")
        calcu.hayOperacion = savedInstanceState.getBoolean("hayOperacion")
        calcu.operacion = savedInstanceState.getString("operacion").toString()
        calcu.sePulsoIgual = savedInstanceState.getBoolean("sePusoIgual")
        mostrarResultado.text = savedInstanceState.getString("mostrarPantalla").toString()

    }


}