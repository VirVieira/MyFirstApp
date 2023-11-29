package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.myfirstapp.R.id.edittext_peso
import com.example.myfirstapp.R.id.edittext_peso
import android.widget.Toast

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)

        btnCalcular.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = alturaStr.toFloat()
                val peso: Float = pesoStr.toFloat()

                val alturafinal: Float = altura * altura
                val result: Float = peso / alturafinal

                val intent = Intent(this , ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT" , result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this , "Preencher todos os campos" , Toast.LENGTH_LONG).show()
            }

        }

    }
}