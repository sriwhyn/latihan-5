package com.sri.latihan5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnSuhu : Button
    private lateinit var btnBelanja : Button
    private lateinit var btnBalok : Button
    private lateinit var btnGenGan : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnSuhu=findViewById(R.id.btnSuhu)
        btnBelanja=findViewById(R.id.btnBelanja)
        btnBalok=findViewById(R.id.btnBalok)
        btnGenGan=findViewById(R.id.btnGenGan)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSuhu.setOnClickListener()
        {
            val intentMenu2 = Intent(this@MainActivity,KonversiSuhu::class.java)
            startActivity(intentMenu2)
        }

        btnBelanja.setOnClickListener()
        {
            val intentMenu2 = Intent(this@MainActivity,BelanjaDiskon::class.java)
            startActivity(intentMenu2)
        }

        btnBalok.setOnClickListener()
        {
            val intentMenu2 = Intent(this@MainActivity,LuasPermukaanVolumeBalok::class.java)
            startActivity(intentMenu2)
        }

        btnGenGan.setOnClickListener()
        {
            val intentMenu2 = Intent(this@MainActivity,BilanganGanjilGenap::class.java)
            startActivity(intentMenu2)
        }

    }
}
