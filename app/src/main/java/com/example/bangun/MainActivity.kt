package com.example.bangun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.sqrt
import android.widget.Toast




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bangun)
//        hitungbangun()

        val btnhitung = findViewById<Button>(R.id.btn_hitung)
        val btnreset = findViewById<Button>(R.id.btn_reset)
        btnhitung.setOnClickListener {
            val inputnm = findViewById<EditText>(R.id.nama)
            val input1 = findViewById<EditText>(R.id.input_1)
            val input2 = findViewById<EditText>(R.id.input_2)
            val input3 = findViewById<EditText>(R.id.input_3)
            val rgrup = findViewById<RadioGroup>(R.id.radiogrup)
            val pria = findViewById<RadioButton>(R.id.pria)
            val wanita = findViewById<RadioButton>(R.id.wanita)

            var nama = inputnm.text.toString()
            var usia = input1.text.toString()
            var tinggi = input2.text.toString()
            var berat = input3.text.toString()
            var emptyfield = false

            var gender=""
            if (rgrup.checkedRadioButtonId != -1){
                if(pria.isChecked){
                    gender += "Pria"
                }else if (wanita.isChecked){
                    gender += "Wanita"
                }
            }else {
                emptyfield=true
                Toast.makeText(this, "pilih data!!", Toast.LENGTH_SHORT).show()
            }
            if (nama.isEmpty()||usia.isEmpty()||tinggi.isEmpty()||berat.isEmpty()){
                emptyfield = true
                Toast.makeText(this, "SILAHKAN ISI DATA!!", Toast.LENGTH_SHORT).show()
            }
            if (nama.isEmpty()) {
                emptyfield = true
                inputnm.error = "Field Tidak Boleh Kosong"
            }
            if (usia.isEmpty()) {
                emptyfield = true
                input1.error = "Field Tidak Boleh Kosong"
            }
            if (tinggi.isEmpty()) {
                emptyfield = true
                input2.error = "Field Tidak Boleh Kosong"
            }
            if (berat.isEmpty()) {
                emptyfield = true
                input3.error = "Field Tidak Boleh Kosong"
            }
            if (!emptyfield) {
                Toast.makeText(this, "Perhitungan Berhasil!!", Toast.LENGTH_SHORT).show()
             val hitung = berat.toDouble() / ((tinggi.toDouble()/100 )*(tinggi.toDouble()/100 ))

                var jenis=""
                if (hitung < 18.1){
                    jenis += "Kurus"
                }else if(hitung >= 18.1 && hitung < 23.1){
                    jenis += "normal"
                }else if(hitung >= 23.1 && hitung < 28.1){
                    jenis += "Gendut"
                }else if (hitung > 28.1){
                    jenis += "obesitas"
                }


                val hasil = Data(nama,gender,usia,hitung, jenis)
                val moveIntent = Intent(this@MainActivity, SecondActivity::class.java)
                moveIntent.putExtra(SecondActivity.KEY_DATA, hasil)
                startActivity(moveIntent)
                finish()


            }
        }

        btnreset.setOnClickListener {
            val input1 = findViewById<EditText>(R.id.input_1)
            val input2 = findViewById<EditText>(R.id.input_2)
            val input3 = findViewById<EditText>(R.id.input_3)
            val pria = findViewById<RadioButton>(R.id.pria)
            val wanita = findViewById<RadioButton>(R.id.wanita)
            val inputnm = findViewById<EditText>(R.id.nama)
            Toast.makeText(this, "Reset Berhasil!!", Toast.LENGTH_SHORT).show()

            pria.isChecked=false
            wanita.isChecked=false
            inputnm.setText("")
            input1.setText("")
            input2.setText("")
            input3.setText("")
        }


    }


}


