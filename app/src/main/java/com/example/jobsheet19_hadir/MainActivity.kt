package com.example.jobsheet19_hadir

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Nilai: EditText = findViewById(R.id.Nilai)
        val btnKonversi: Button = findViewById(R.id.btnKonversi)
        val Hasil: TextView = findViewById(R.id.Hasil)

        btnKonversi.setOnClickListener {
            val nilaiStr = Nilai.text.toString()
            val nilai = nilaiStr.toIntOrNull()

            if (nilai != null) {
                val huruf = konversiNilai(nilai)
                Hasil.text = "Nilai huruf: $huruf"
            } else {
                Hasil.text = "Masukkan nilai yang valid dalam bentuk angka."
            }
        }
    }

    private fun konversiNilai(nilai: Int): String {
        return when {
            nilai in 85..100 -> "A"
            nilai in 70..84 -> "B"
            nilai in 55..69 -> "C"
            nilai in 40..54 -> "D"
            nilai in 0..39 -> "E"
            else -> "Nilai tidak valid"
        }
    }
}
