package com.df.simplepaymp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.df.simplepaympmodule.model.*
import com.df.simplepaympmodule.session.FillMPHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fillMPItens =
                listOf(FillMPItem("titulo tetse","descriptio", 1,"BRL",1.99))
        val fillMPPayer =
                FillMPPayer("filipimentel.fp@ail.com")
        val fillMPExcudeMethods =
                listOf(FillMPMethodPay("ticket"), FillMPMethodPay("atm"), FillMPMethodPay("debit_card"))
        val fillMPPaymentMethods =
                FillMPPaymentMethods(fillMPExcudeMethods,1)

        val fillItemMPData = FillMPItemData(fillMPItens,fillMPPayer,fillMPPaymentMethods)

        bt_create_product_and_pay.setOnClickListener {
            FillMPHelper().initFillMP(
                    this,
                    "TEST-5641631835692104-091123-8328958ccf078812eb5756755eb1c71d-533881075",
                    "TEST-7e223cec-c303-43cd-8f56-54c97981cefd",
                    fillItemMPData,
                    successMPPAY = {
                        Log.i("JKK","S")
                        Toast.makeText(this,"KLKLKLKLKLKLKLK",Toast.LENGTH_SHORT).show()
                    },
                    errorMPPAY = {
                        Log.i("JKK", "E:::: $it")
                        Toast.makeText(this, "KLKLKLKLKLKLKLK$it",Toast.LENGTH_SHORT).show()
                    }
            )
        }

    }

}