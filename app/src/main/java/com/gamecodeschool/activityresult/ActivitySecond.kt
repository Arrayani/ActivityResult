package com.gamecodeschool.activityresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivitySecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val txtData = findViewById<TextView>(R.id.txtData)
        val txtReply = findViewById<EditText>(R.id.txtReply)
        val btnReply = findViewById<Button>(R.id.btnReply)
        txtData.text= intent.extras!!.getString("info")

        btnReply.setOnClickListener {
            val intent = Intent()
            intent.putExtra("reply", txtReply.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }


    }
}