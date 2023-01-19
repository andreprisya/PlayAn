package com.example.playan

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var nama_pemain = ""
    var koin_pemain = 50
    var level_pemain = 1
    var tebakan = ""

    // Halaman Awal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_awal)
    }

    fun dialogReset(view: View) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_reset, null)
        builder.setView(dialogLayout)
        val d = builder.show();
        val btnYakin = dialogLayout.findViewById(R.id.btnYakin) as Button
        val btnBatal = dialogLayout.findViewById(R.id.btnBatal) as Button

        btnYakin.setOnClickListener( object : OnClickListener {
            override fun onClick(v: View?) {
                nama_pemain = ""
                koin_pemain = 50
                level_pemain = 1
                d.dismiss()
            }
        })

        btnBatal.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                d.dismiss()
            }
        })

    }

    fun dialogUsername() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_username, null)
        builder.setView(dialogLayout)
        val d = builder.show();

        var edtUsername  = dialogLayout.findViewById(R.id.edtUsername) as EditText

        val btnMulai = dialogLayout.findViewById(R.id.btnMulai) as Button

        btnMulai.setOnClickListener( object : OnClickListener {
            override fun onClick(v: View?) {
                nama_pemain = edtUsername.text.toString()
                changeUsername(nama_pemain)
                d.dismiss()
            }
        })
    }



    fun changeUsername(string: String) {
        setContentView(R.layout.halaman_beranda)
        var tv = findViewById(R.id.txUsername) as TextView
        tv.setText(string)
    }

    fun awalToBeranda(view: View) {
        setContentView(R.layout.halaman_beranda)
        var tv = findViewById(R.id.txUsername) as TextView
        tv.setText(nama_pemain)
        if (nama_pemain == "") {
            dialogUsername()
        }
    }

    // Halaman Beranda
    fun berandaToAwal(view: View) {
        setContentView(R.layout.halaman_awal)
    }

    fun checkLevel(){
        setContentView(R.layout.halaman_level)
        var btnLevel2 = findViewById(R.id.btnLevel2) as Button
        var btnLevel3 = findViewById(R.id.btnLevel3) as Button
        var btnLevel4 = findViewById(R.id.btnLevel4) as Button
        var btnLevel5 = findViewById(R.id.btnLevel5) as Button
        var btnLevel6 = findViewById(R.id.btnLevel6) as Button
        var btnLevel7 = findViewById(R.id.btnLevel7) as Button
        var btnLevel8 = findViewById(R.id.btnLevel8) as Button
        var btnLevel9 = findViewById(R.id.btnLevel9) as Button
        var btnLevel10 = findViewById(R.id.btnLevel10) as Button
        var txPoint = findViewById(R.id.txPoint) as TextView

        txPoint.setText(""+koin_pemain)

        if (level_pemain >= 2) {
            btnLevel2.setTextColor(Color.WHITE)
            btnLevel2.setClickable(true)
        }

        if (level_pemain >= 3) {
            btnLevel3.setTextColor(Color.WHITE)
            btnLevel3.setClickable(true)
        }

        if (level_pemain >= 4) {
            btnLevel4.setTextColor(Color.WHITE)
            btnLevel4.setClickable(true)
        }

        if (level_pemain >= 5) {
            btnLevel5.setTextColor(Color.WHITE)
            btnLevel5.setClickable(true)
        }

        if (level_pemain >= 6) {
            btnLevel6.setTextColor(Color.WHITE)
            btnLevel6.setClickable(true)
        }

        if (level_pemain >= 7) {
            btnLevel7.setTextColor(Color.WHITE)
            btnLevel7.setClickable(true)
        }

        if (level_pemain >= 8) {
            btnLevel8.setTextColor(Color.WHITE)
            btnLevel8.setClickable(true)
        }

        if (level_pemain >= 9) {
            btnLevel9.setTextColor(Color.WHITE)
            btnLevel9.setClickable(true)
        }

        if (level_pemain >= 10) {
            btnLevel10.setTextColor(Color.WHITE)
            btnLevel10.setClickable(true)
        }


    }

    fun berandaToLevel(view: View) {
        checkLevel()
    }

    fun dialogInfo(view: View) {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_info, null)
        builder.setView(dialogLayout)
        builder.show()
    }

//    Halaman Level
    fun levelToBeranda(view: View){
        setContentView(R.layout.halaman_beranda)

    }

    fun levelToSoal1(view: View){
        setContentView(R.layout.halaman_soal)
        var txPoint = findViewById(R.id.txPoint) as TextView
        txPoint.setText(""+koin_pemain)

        var edtJawaban = findViewById(R.id.edtJawaban) as EditText
        val btnCek = findViewById(R.id.btnCek) as Button
        val btnBantuan = findViewById(R.id.btnBantuan) as Button

        btnCek.setOnClickListener( object : OnClickListener {
            override fun onClick(v: View?) {
                tebakan = edtJawaban.text.toString()
                Log.w("test",tebakan)
                cekJawaban1(tebakan)
            }
        })

        btnBantuan.setOnClickListener( object : OnClickListener {
            override fun onClick(v: View?) {
                if (koin_pemain >= 10) {
                    edtJawaban.setText("sule")
                    koin_pemain -= 10
                    txPoint.setText(""+koin_pemain)
                }
            }
        })
    }

    fun cekJawaban1(string: String){
        setContentView(R.layout.halaman_soal)
        var txPoint = findViewById(R.id.txPoint) as TextView
        var jawaban = "sule"
        if (string == jawaban) {
            setContentView(R.layout.halaman_berikutnya)
            var txPoint = findViewById(R.id.txPoint) as TextView
            dialogBenar()
            koin_pemain += 5
            level_pemain += 1
            txPoint.setText(""+koin_pemain)
        } else {
            dialogSalah()
            txPoint.setText(""+koin_pemain)
        }
    }

    fun dialogBenar() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_benar, null)
        builder.setView(dialogLayout)
        builder.show()
    }

    fun dialogSalah() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogLayout = inflater.inflate(R.layout.dialog_salah, null)
        builder.setView(dialogLayout)
        builder.show()
    }

    fun soalToSoal2(view: View) {
        setContentView(R.layout.halaman_soal2)
        var txPoint = findViewById(R.id.txPoint) as TextView
        txPoint.setText(""+koin_pemain)
    }

//    soal 2
    fun levelToSoal2(view: View){
    setContentView(R.layout.halaman_soal2)
    var txPoint = findViewById(R.id.txPoint) as TextView
    txPoint.setText(""+koin_pemain)

    var edtJawaban = findViewById(R.id.edtJawaban) as EditText
    val btnCek = findViewById(R.id.btnCek) as Button
    val btnBantuan = findViewById(R.id.btnBantuan) as Button

    btnCek.setOnClickListener( object : OnClickListener {
        override fun onClick(v: View?) {
            tebakan = edtJawaban.text.toString()
            Log.w("test",tebakan)
            cekJawaban2(tebakan)
        }
    })

    btnBantuan.setOnClickListener( object : OnClickListener {
        override fun onClick(v: View?) {
            if (koin_pemain >= 10) {
                edtJawaban.setText("limbad")
                koin_pemain -= 10
                txPoint.setText(""+koin_pemain)
            }
        }
    })
}

    fun cekJawaban2(string: String){
        setContentView(R.layout.halaman_soal2)
        var txPoint = findViewById(R.id.txPoint) as TextView
        var jawaban = "limbad"
        if (string == jawaban) {
            setContentView(R.layout.halaman_berikutnya2)
            var txPoint = findViewById(R.id.txPoint) as TextView
            dialogBenar()
            koin_pemain += 5
            level_pemain += 1
            txPoint.setText(""+koin_pemain)
        } else {
            dialogSalah()
            txPoint.setText(""+koin_pemain)
        }
    }

    //    soal 3
    fun levelToSoal3(view: View){
        setContentView(R.layout.halaman_soal3)
        var txPoint = findViewById(R.id.txPoint) as TextView
        txPoint.setText(""+koin_pemain)

        var edtJawaban = findViewById(R.id.edtJawaban) as EditText
        val btnCek = findViewById(R.id.btnCek) as Button
        val btnBantuan = findViewById(R.id.btnBantuan) as Button

        btnCek.setOnClickListener( object : OnClickListener {
            override fun onClick(v: View?) {
                tebakan = edtJawaban.text.toString()
                Log.w("test",tebakan)
                cekJawaban3(tebakan)
            }
        })

        btnBantuan.setOnClickListener( object : OnClickListener {
            override fun onClick(v: View?) {
                if (koin_pemain >= 10) {
                    edtJawaban.setText("tulus")
                    koin_pemain -= 10
                    txPoint.setText(""+koin_pemain)
                }
            }
        })
    }

    fun cekJawaban3(string: String){
        setContentView(R.layout.halaman_soal3)
        var txPoint = findViewById(R.id.txPoint) as TextView
        var jawaban = "tulus"
        if (string == jawaban) {
            setContentView(R.layout.halaman_berikutnya3)
            var txPoint = findViewById(R.id.txPoint) as TextView
            dialogBenar()
            koin_pemain += 5
            level_pemain += 1
            txPoint.setText(""+koin_pemain)
        } else {
            dialogSalah()
            txPoint.setText(""+koin_pemain)
        }
    }













}