package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)


        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {

                Snackbar.make(
                    edtPeso,
                    "Preencha todos os Campos",
                    Snackbar.LENGTH_LONG
                )
                    .show()

                } else run {
                    val peso = pesoStr.toFloat()
                    val altura = alturaStr.toFloat()

                    val alturaQ2 = altura * altura
                    val resultado = peso / alturaQ2

                    val intent = Intent(this, ResultActivity::class.java )
                intent.putExtra("KEY_RESULT_IMC", resultado)
                startActivity(intent)

                }
            }
        }

    private fun Intent(mainActivity: MainActivity) {

    }
}
