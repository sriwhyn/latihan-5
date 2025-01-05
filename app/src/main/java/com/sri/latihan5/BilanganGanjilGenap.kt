package com.sri.latihan5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BilanganGanjilGenap : AppCompatActivity() {

    private lateinit var txtBilangan : TextView
    private lateinit var btnBilangan : Button
    private lateinit var etBilangan : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bilangan_ganjil_genap)

        txtBilangan = findViewById(R.id.txtBilangan)
        btnBilangan = findViewById(R.id.btnBilangan)
        etBilangan  = findViewById(R.id.etBilangan)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBilangan.setOnClickListener()
        {

            val bilangan = etBilangan.text.toString()
            if (bilangan.isNotEmpty()) {
                try {
                    var bilangan = bilangan.toInt()
                    if (bilangan % 2 == 0) {
                        txtBilangan.text = "Bilangan yang Anda Input Adalah Bilangan Genap"
                    } else {
                        txtBilangan.text = "Bilangan yang Anda Input Adalah Bilangan Ganjil"
                    }
                } catch (e: NumberFormatException)
                // mencegah terjadinya error jika menginputkan data selain angka
                {
                    Toast.makeText(this, "Input Hanya Berupa Angka", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Harap Input Angka", Toast.LENGTH_SHORT).show()
            }

        }
    }
}