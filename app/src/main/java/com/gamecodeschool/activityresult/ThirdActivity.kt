package com.gamecodeschool.activityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.gamecodeschool.activityresult.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    lateinit var binding : ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_third)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // kurang huruf s nya udah ga bisa ini ActivityResultContracts
        val getImage  = registerForActivityResult(
            ActivityResultContracts.GetContent(),
        ActivityResultCallback {
            binding.imageView.setImageURI(it)
        })
        binding.button.setOnClickListener{

        getImage.launch("image/")
//            val intent = Intent()
//            intent.type =  "image/"
//            intent.action = Intent.ACTION_GET_CONTENT
//            startActivityForResult(Intent.createChooser(intent,"select the image"),100)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 100)
//            if (data!=null)
//                binding.imageView.setImageURI(data.data)
//    }

}