package com.shreenathlogistics.akencryptionexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.shreenathlogistics.akencryption.AESEncyption

class MainActivity : AppCompatActivity() {

    val secretKey = "tK5UTui+DPh8lIlBxya5XVsmeDCoUl6vHhdIESMB6sQ="
    val salt = "QWlGNHNhMTJTQWZ2bGhpV3U=" // base64 decode => AiF4sa12SAfvlhiWu
    val iv = "bVQzNFNhRkQ1Njc4UUFaWA==" // base64 decode => mT34SaFD5678QAZX

    lateinit var button : Button
    lateinit var encText : EditText
    lateinit var text1 : TextView
    lateinit var text2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnshow)

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                encText = findViewById(R.id.txtEnc)
                text1 = findViewById(R.id.text1)
                text2 = findViewById(R.id.text2)
                text1.text = ""
                text2.text = ""
                if (!encText.text.isEmpty()) {
                    val encString = AESEncyption.encrypt(encText.text.toString(), secretKey, salt, iv)
                    val decString = encString?.let { AESEncyption.decrypt(it, secretKey, salt, iv) }
                    text1.text = encString
                    text2.text = decString
                }

            }

        })
    }


}