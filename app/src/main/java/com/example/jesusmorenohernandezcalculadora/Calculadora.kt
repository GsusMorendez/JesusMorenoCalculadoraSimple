package com.example.jesusmorenohernandezcalculadora

import android.widget.TextView
import java.math.BigDecimal

class Calculadora {

    var primero: String = "";
    var segundo: String = "";
    var resultado: Double = 0.0;
    var hayOperacion: Boolean = false;
    var operacion: String = "";
    var sePulsoIgual: Boolean = false;

    fun añadirNumero(param: String, mostrarResultado: TextView) {

        if (!hayOperacion && !sePulsoIgual) {

            if (param == "." && this.primero != "" && !this.primero.contains(".")) {
                this.primero += param;
                mostrarResultado.text = this.primero
            } else if (param != ".") {
                this.primero += param;
                mostrarResultado.text = this.primero
            }

        } else if (hayOperacion) {

            if (this.primero.contains(".") && (this.primero.length - 2).toChar() == '.' && (this.primero.length - 1).toChar() == '0') {
                this.primero = this.primero.substring(0, this.primero.length - 2)
            }

            if (operacion == "÷" && param == "0") {
                mostrarResultado.text = "No se puede dividir entre 0";
                this.primero = "";
                this.segundo = "";
                this.resultado = 0.0;
                this.hayOperacion = false;
                this.operacion = "";
                this.sePulsoIgual = false;

            } else {
                if (param == "." && segundo != "" && !segundo.contains(".")) {
                    segundo += param;

                    mostrarResultado.text = this.primero + " " + this.operacion + " " + this.segundo
                } else if (param != ".") {
                    this.segundo += param;
                    mostrarResultado.text = this.primero + " " + this.operacion + " " + this.segundo
                }
            }


        } else if (!hayOperacion && sePulsoIgual) {
            if (param != ".") {
                this.primero = param;
                mostrarResultado.text = this.primero
                sePulsoIgual = false
            }


        }
    }

    fun operar(mostrarResultado: TextView) {
        fun Double.roundTo2DecimalPlaces() =
            BigDecimal(this).setScale(5, BigDecimal.ROUND_HALF_UP).toDouble()


        if (primero != "" && segundo != "") {

            var uno = this.primero.toDouble();
            var dos = this.segundo.toDouble();

            when (this.operacion) {
                "+" -> this.resultado = (uno + dos).roundTo2DecimalPlaces()
                "-" -> this.resultado = (uno - dos).roundTo2DecimalPlaces()
                "÷" -> this.resultado = (uno / dos).roundTo2DecimalPlaces()
                "x" -> this.resultado = (uno * dos).roundTo2DecimalPlaces()
            }


            var salida: String = resultado.toString()

            if (salida[salida.length - 2] == '.' && salida[salida.length - 1] == '0') {
                salida = salida.substring(0, salida.length - 2)
            }
            mostrarResultado.text = salida
            this.primero = salida
            this.segundo = ""
            this.hayOperacion = false
            this.operacion = ""
            sePulsoIgual = true
        }
    }

    fun añadirOperacion(simbolo: String, mostrarResultado: TextView) {

        if (this.hayOperacion && this.primero != "" && this.segundo != "") {
            operar(mostrarResultado)
            this.operacion = simbolo
            this.hayOperacion = true
            mostrarResultado.text = this.primero + " " + this.operacion
        } else if (!this.hayOperacion && primero != "" && this.primero != "-") {
            this.hayOperacion = true
            this.operacion = simbolo
            mostrarResultado.text = mostrarResultado.text.toString() + " " + this.operacion
        } else if (!this.hayOperacion && this.primero == "" && simbolo == "-") {
            this.primero += "-";
            mostrarResultado.text = this.primero
        } else if (this.hayOperacion && this.primero != "" && this.segundo == "") {
            this.operacion = simbolo
            mostrarResultado.text = this.primero + " " + this.operacion
        }

    }

    fun restaurar(mostrarResultado: TextView) {

        this.primero = "0";
        this.segundo = "";
        this.resultado = 0.0;
        this.hayOperacion = false;
        this.operacion = "";
        this.sePulsoIgual = true;

        mostrarResultado.text = "0"

    }
}