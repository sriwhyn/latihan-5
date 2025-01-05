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

class LuasPermukaanVolumeBalok : AppCompatActivity() {

    private lateinit var etP : EditText
    private lateinit var etL : EditText
    private lateinit var etT : EditText
    private lateinit var btnBalok : Button
    private lateinit var txtV : TextView
    private lateinit var txtLP : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_luas_permukaan_volume_balok)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etP = findViewById(R.id.etPanjang)
        etL = findViewById(R.id.etLebar)
        etT = findViewById(R.id.etTinggi)
        btnBalok= findViewById(R.id.btnSubmitBalok)
        txtV = findViewById(R.id.txtV)
        txtLP = findViewById(R.id.txtLP)

        btnBalok.setOnClickListener()
        {
            val P = etP.text.toString()
            val L = etL.text.toString()
            val T = etT.text.toString()
            if (P.isNotEmpty() && L.isNotEmpty() && T.isNotEmpty()) {
                try {

                    var P = P.toInt()
                    var L = L.toInt()
                    var T = T.toInt()
                    val LP = 2 * ((P * L) + (P * T) + (L * T))
                    val V = P * L * T
                    txtLP.text = "Luas Permukaan=$LP"
                    txtV.text = "Volume =$V"

                } catch (e: NumberFormatException)
                // mencegah terjadinya error jika menginputkan data selain angka
                {
                    Toast.makeText(this, "Input Hanya Berupa Angka", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "Pastikan anda Anda Menginput data dengan benar ", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
