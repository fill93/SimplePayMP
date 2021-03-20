package com.df.simplepaympmodule.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.df.simplepaympmodule.util.Constants
import com.mercadopago.android.px.core.MercadoPagoCheckout
import com.mercadopago.android.px.model.Payment
import com.mercadopago.android.px.model.exceptions.MercadoPagoError
import org.koin.androidx.viewmodel.ext.android.viewModel

class FillMPCheckoutActivity : AppCompatActivity() {

    private val viewModel: FillMPCheckoutViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.postCreateProductCheckout(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        resolveCheckoutResult(requestCode, resultCode, data!!)
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun resolveCheckoutResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == Constants.REQUEST_PAYMENT) {
            if (resultCode == MercadoPagoCheckout.PAYMENT_RESULT_CODE) {
                val payment = data.getSerializableExtra(MercadoPagoCheckout.EXTRA_PAYMENT_RESULT) as Payment?
                if (payment!!.paymentStatus == "approved") {
                    //aprovado - jogar resultado para funcao anonima
                    Toast.makeText(this,"Ap",Toast.LENGTH_SHORT).show()
                }
            } else if (resultCode == RESULT_CANCELED) {
                if (data != null && data.extras != null &&
                    data.extras!!.containsKey(MercadoPagoCheckout.EXTRA_ERROR)
                ) {
                    val mercadoPagoError =
                        data.getSerializableExtra(MercadoPagoCheckout.EXTRA_ERROR) as MercadoPagoError?
                    Toast.makeText(this, "Error: $mercadoPagoError", Toast.LENGTH_LONG).show()
                }
                Log.i(
                    "JK", " ::: 222 ::: " + "CANCELADO" + " ::: " + StringBuilder()
                        .append("Cancel - ")
                        .append(requestCode)
                        .append(resultCode)
                )
            } else {
                Log.i(
                    "JK", " ::: 333 ::: " + "OUTRA ERRO NO PAGAMENTO" + ":::: " + StringBuilder()
                        .append(requestCode)
                        .append(resultCode)
                )
            }
        } else if (resultCode == RESULT_CANCELED) {

        } else {

        }
    }

}