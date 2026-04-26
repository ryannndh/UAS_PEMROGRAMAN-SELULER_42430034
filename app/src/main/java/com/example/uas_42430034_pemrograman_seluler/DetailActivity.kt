package com.example.uas_42430034_pemrograman_seluler
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val txtHasil = findViewById<TextView>(R.id.txtHasil)

        val hasil = intent.getStringExtra("hasil")

        txtHasil.text = hasil ?: "Tidak ada data"
    }
}