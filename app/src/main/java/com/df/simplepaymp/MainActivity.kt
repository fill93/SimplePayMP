package com.df.simplepaymp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.df.simplepaympmodule.ui.FillMPCheckoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_create_product_and_pay.setOnClickListener {
            startActivity(Intent(this, FillMPCheckoutActivity::class.java))
        }

    }
}