package com.example.uas_42430034_pemrograman_seluler

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // ARRAY DATA SENJATA
    private val weapons = arrayOf(
        "Vandal",
        "Phantom",
        "Operator",
        "Sheriff",
        "Spectre",
        "Guardian",
        "Bulldog",
        "Odin"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {

            setContentView(R.layout.activity_main)

            val input = findViewById<EditText>(R.id.inputSearch)

            val btnCari = findViewById<Button>(R.id.btnCari)
            val btnAZ = findViewById<Button>(R.id.btnAZ)
            val btnZA = findViewById<Button>(R.id.btnZA)
            val btnLihat = findViewById<Button>(R.id.btnLihat)

            // 🔍 SEARCH DATA (LINEAR SEARCH)
            btnCari.setOnClickListener {

                val text = input.text.toString()

                if (text.isEmpty()) {

                    Toast.makeText(this,
                        "Input tidak boleh kosong!",
                        Toast.LENGTH_SHORT).show()

                } else {

                    var ditemukan = false
                    var hasil = ""

                    for (weapon in weapons) {

                        if (weapon.equals(text, ignoreCase = true)) {

                            ditemukan = true
                            hasil = "Senjata ditemukan:\n$weapon"

                            Log.d("42430034",
                                "Pencarian berhasil: $weapon")

                            break
                        }
                    }

                    if (!ditemukan) {

                        hasil = "Senjata tidak ditemukan"

                        Log.d("42430034",
                            "Pencarian gagal: $text")
                    }

                    val intent =
                        Intent(this, DetailActivity::class.java)

                    intent.putExtra("hasil", hasil)

                    startActivity(intent)
                }
            }

            // 🔤 SORT A-Z (BUBBLE SORT)
            btnAZ.setOnClickListener {

                val sorted = weapons.clone()

                for (i in sorted.indices) {
                    for (j in 0 until sorted.size - i - 1) {

                        if (sorted[j] > sorted[j + 1]) {

                            val temp = sorted[j]
                            sorted[j] = sorted[j + 1]
                            sorted[j + 1] = temp
                        }
                    }
                }

                val hasil = sorted.joinToString("\n")

                Log.d("42430034",
                    "Sorting A-Z berhasil")

                val intent =
                    Intent(this, DetailActivity::class.java)

                intent.putExtra("hasil", hasil)

                startActivity(intent)
            }

            // 🔤 SORT Z-A
            btnZA.setOnClickListener {

                val sorted = weapons.clone()

                for (i in sorted.indices) {
                    for (j in 0 until sorted.size - i - 1) {

                        if (sorted[j] < sorted[j + 1]) {

                            val temp = sorted[j]
                            sorted[j] = sorted[j + 1]
                            sorted[j + 1] = temp
                        }
                    }
                }

                val hasil = sorted.joinToString("\n")

                Log.d("42430034",
                    "Sorting Z-A berhasil")

                val intent =
                    Intent(this, DetailActivity::class.java)

                intent.putExtra("hasil", hasil)

                startActivity(intent)
            }

            // 📋 TAMPILKAN SEMUA DATA
            btnLihat.setOnClickListener {

                val hasil = weapons.joinToString("\n")

                Log.d("42430034",
                    "Menampilkan semua data")

                val intent =
                    Intent(this, DetailActivity::class.java)

                intent.putExtra("hasil", hasil)

                startActivity(intent)
            }

        } catch (e: Exception) {

            Log.e("42430034",
                "Terjadi error: ${e.message}")

            Toast.makeText(this,
                "Terjadi kesalahan!",
                Toast.LENGTH_SHORT).show()
        }
    }
}