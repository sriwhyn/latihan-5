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

class BelanjaDiskon : AppCompatActivity() {
    private lateinit var txtBelanja: TextView
    private lateinit var buttonSubmitB: Button
    private lateinit var etBelanja: EditText
    private lateinit var txtD : TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_belanja_diskon)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        txtBelanja = findViewById(R.id.txtBelanja)
        buttonSubmitB = findViewById(R.id.btnSubmitBelanja)
        etBelanja = findViewById(R.id.etBelanja)
        txtD = findViewById(R.id.txtsetelahD)


        buttonSubmitB.setOnClickListener()
        {
            val totalBelanja= etBelanja.text.toString()
            if (totalBelanja.isNotEmpty()) {
                try{
                    val totalBelanja = totalBelanja.toInt()
                    val diskon: Double
                    if (totalBelanja < 100000) {
                        diskon = 0.0
                    } else if (totalBelanja <= 500000) {
                        diskon = 0.1 * totalBelanja
                    } else if (totalBelanja <= 1000000) {
                        diskon = 0.2 * totalBelanja
                    } else {
                        diskon = 0.3 * totalBelanja
                    }
                    val totalSetelahDiskon = totalBelanja - diskon
                    txtBelanja.text = "Total Belanja Anda = Rp.$totalBelanja"
                    txtD.text = "Diskon: Rp.$diskon\nTotal setelah diskon: Rp.$totalSetelahDiskon"
                }catch (e:NumberFormatException)
                // mencegah terjadinya error jika menginputkan data selain angka
                {
                    Toast.makeText(this, "Input Hanya Berupa Angka", Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Harap masukkan total belanja", Toast.LENGTH_SHORT).show()
            }
        }
    }

}