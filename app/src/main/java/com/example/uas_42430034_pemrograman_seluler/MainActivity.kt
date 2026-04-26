package com.example.uas_42430034_pemrograman_seluler

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.inputSearch)
        val btnCari = findViewById<Button>(R.id.btnCari)
        val btnAZ = findViewById<Button>(R.id.btnAZ)
        val btnZA = findViewById<Button>(R.id.btnZA)
        val btnLihat = findViewById<Button>(R.id.btnLihat)

// Tombol Cari
        btnCari.setOnClickListener {
            val text = input.text.toString()

            if (text.isEmpty()) {
                Toast.makeText(this, "Input tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("hasil", "Hasil pencarian: $text")
                startActivity(intent)
            }
        }

// Tombol A-Z
        btnAZ.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("hasil", "Menampilkan data A-Z")
            startActivity(intent)
        }

// Tombol Z-A
        btnZA.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("hasil", "Menampilkan data Z-A")
            startActivity(intent)
        }

// Tombol Lihat Semua
        btnLihat.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("hasil", "Menampilkan semua data senjata")
            startActivity(intent)
        }
    }
}