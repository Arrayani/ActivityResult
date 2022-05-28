package com.gamecodeschool.activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gamecodeschool.activityresult.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    lateinit var binding : ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val intent = Intent()
            intent.type =  "image/"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent,"select the image"),100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100)
            if (data!=null)
                binding.imageView.setImageURI(data.data)
    }

}