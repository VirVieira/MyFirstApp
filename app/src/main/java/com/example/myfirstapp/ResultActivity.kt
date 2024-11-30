package com.example.myfirstapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val result = intent.getFloatExtra("KEY_RESULT_IMC", 0.1f)

       val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

      var classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"
        }else if (result in 18.5f..24.9f) {
            "NORMAL"
        }else if (result in 25f..29.9f) {
            "SOBREPESO"
        }else if (result in 30f..39.9f) {
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }
        tvClassificacao.text = classificacao

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}
