package com.example.bangun

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Process
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.system.exitProcess

class SecondActivity : AppCompatActivity() {
    private var waktu = 0L

    companion object {
        const val KEY_DATA = "KEY_DATA"
    }

    override fun onBackPressed() {

//        TEKAN DUA KALI UNTUK KELUAR
        if (waktu + 2000 > System.currentTimeMillis()) {
            finish()
        } else {
            Toast.makeText(this, "Tekan Dua Kali Untuk Keluar Aplikasi.", Toast.LENGTH_SHORT).show()
        }
        waktu = System.currentTimeMillis()


    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val nama = findViewById<TextView>(R.id.sapa)
        val tvSecondActivity = findViewById<TextView>(R.id.tv_result)
        var hitungulang = findViewById<Button>(R.id.btn_ulang)
        val hasil = intent.getParcelableExtra<Data>(KEY_DATA) as Data

        nama.text = "HAI! ${hasil.nama}"
        tvSecondActivity.text =
            "Jenis Kelamin : ${hasil.gender} \n\n umur : ${hasil.umur} Tahun \n\n perhitungan BMI : ${hasil.hitung}\n\n Jenis :${hasil.jenis}"

        hitungulang.setOnClickListener {

            Toast.makeText(this, "HITUNG ULANG!!", Toast.LENGTH_SHORT).show()
            val moveIntent = Intent(this, MainActivity::class.java)
            startActivity(moveIntent)
            finish()


        }

    }
}
