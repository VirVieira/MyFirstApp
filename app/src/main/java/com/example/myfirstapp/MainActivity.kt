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

        // Recuperar os componentes EditText
        //Criar uma variável e associar o componente de UI<EditText>


        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)

        // Recuperar o botao da tela
        // Recuperar o texto digitiado no edt peso

        btnCalcular.setOnClickListener {
            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == "") {
                // Mostrar mensagem para o usuario

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

                // Navegar para a próxima tela
                // Criar o layout da proxima tela
                // Passar dados (Resultado) para proxima tela

                // Intent - Classe do proprio android
                val intent = Intent(this, ResultActivity::class.java )
                intent.putExtra("KEY_RESULT_IMC", resultado)
                startActivity(intent)

                   // Cores
                  // EditText Background + Icone
                // Gradiente + Icone + titulo  + descrição

                }
            }
        }

    private fun Intent(mainActivity: MainActivity) {

    }
}
