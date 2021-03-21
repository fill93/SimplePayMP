package com.df.simplepaymp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.df.simplepaympmodule.model.*
import com.df.simplepaympmodule.session.FillMPSession
import com.df.simplepaympmodule.ui.FillMPCheckoutActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fillMPItens = listOf(FillMPItem("tit do produto", "descri do prod cao", 1, "BRL", 1.99))
        val fillMPPayer = FillMPPayer("filipimentel.fp@ail.com")
        val fillMPExcudeMethods = listOf(FillMPMethodPay("ticket"), FillMPMethodPay("atm"))
        val fillMPPaymentMethods = FillMPPaymentMethods(fillMPExcudeMethods,1)

        val fillItemMPData =
                FillMPItemData.Builder()
                        .setFillMPItens(fillMPItens)
                        .setFillMPPayer(fillMPPayer)
                        .setFillMPPaymentMethods(fillMPPaymentMethods)
                        .build()

        bt_create_product_and_pay.setOnClickListener {
            FillMPSession().loadSession(
                    "TEST-5641631835692104-091123-8328958ccf078812eb5756755eb1c71d-533881075",
                    "TEST-7e223cec-c303-43cd-8f56-54c97981cefd",
                    fillItemMPData
            )
            startActivity(Intent(this, FillMPCheckoutActivity::class.java))
        }

    }
}