package com.gamecodeschool.activityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var   activityResultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSendData = findViewById<Button>(R.id.btnOpenSecondActivity)
        val info = findViewById<EditText>(R.id.txtInfo)

        btnSendData.setOnClickListener {
            val intent = Intent(this@MainActivity, ActivitySecond::class.java)
            intent.putExtra("info", info.text.toString())
            activityResultLauncher.launch(intent)

        }

        activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult())
            { result: ActivityResult? ->
                if (result!!.resultCode== Activity.RESULT_OK)
                {
                    if(result.data!!.extras!!.getString("reply").toString() == "Yes")
                        Toast.makeText(applicationContext,"Congratulation!!",Toast.LENGTH_LONG).show()
                    else{
                        Toast.makeText(applicationContext,"Sorry!!",Toast.LENGTH_LONG).show()
                    }
                }
            }

    }
}