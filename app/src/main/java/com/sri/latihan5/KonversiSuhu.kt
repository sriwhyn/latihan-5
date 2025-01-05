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

class KonversiSuhu : AppCompatActivity() {

    private lateinit var btnSubmit : Button
    private lateinit var txtF : TextView
    private lateinit var txtK : TextView
    private lateinit var txtR : TextView
    private lateinit var etC : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konversi_suhu)

        txtF = findViewById(R.id.txtFahrenheit)
        txtK = findViewById(R.id.txtKelvin)
        txtR = findViewById(R.id.txtReamur)
        etC = findViewById(R.id.etInputSuhu)
        btnSubmit = findViewById(R.id.btnsubmit)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSubmit.setOnClickListener()
        {
            KonversiSuhuCelcius()
        }

    }
    private fun KonversiSuhuCelcius() {
        val ct = etC.text.toString()

        if (ct.isNotEmpty()) {
            try {
                val c = ct.toDouble()
                val f = (9.0 / 5.0) * c + 32
                val k = c + 273.15
                val r = (4.0 / 5.0) * c

                txtF.text = "Konversi dalam Fahrenheit  = $f.F"
                txtK.text = "Konversi dalam Kelvin      = $k.K"
                txtR.text = "Konversi dalam Reamur      = $r.R"
            }
            catch (e : NumberFormatException)
            // mencegah terjadinya error jika menginputkan data selain angka
            {
                Toast.makeText(this, "Input Hanya Berupa Angka", Toast.LENGTH_SHORT).show()
            }
        }else
        {
            Toast.makeText(this, "Harap Input Angka ", Toast.LENGTH_SHORT).show()
        }
    }
}