package com.df.simplepaympmodule.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.df.simplepaympmodule.session.FillMPDataSession
import com.df.simplepaympmodule.util.Constants
import com.mercadopago.android.px.core.MercadoPagoCheckout
import com.mercadopago.android.px.model.Payment
import com.mercadopago.android.px.model.exceptions.MercadoPagoError
import org.koin.androidx.viewmodel.ext.android.viewModel

class FillMPCheckoutActivity : AppCompatActivity() {

    private val viewModel: FillMPCheckoutViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.postCreateProductAndCheckout(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(data != null) {
            resolveOnActivityResult(requestCode, resultCode, data)
        } else {
            FillMPDataSession.errorMPPAY("Operação cancelada!")
        }
        super.onActivityResult(requestCode, resultCode, data)
        finish()
    }

    private fun resolveOnActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == Constants.REQUEST_PAYMENT) {
            if (resultCode == MercadoPagoCheckout.PAYMENT_RESULT_CODE) {
                val payment = data.getSerializableExtra(MercadoPagoCheckout.EXTRA_PAYMENT_RESULT) as Payment?
                if (payment!!.paymentStatus == "approved") {
                    FillMPDataSession.successMPPAY()
                }
            } else if (resultCode == RESULT_CANCELED) {
                if (data.extras != null && data.extras!!.containsKey(MercadoPagoCheckout.EXTRA_ERROR)) {
                    val mercadoPagoError =
                        data.getSerializableExtra(MercadoPagoCheckout.EXTRA_ERROR) as MercadoPagoError?
                    Toast.makeText(this, "Error: ${mercadoPagoError!!.message}", Toast.LENGTH_LONG).show()
                }
                FillMPDataSession.errorMPPAY("Operação cancelada!")
            } else {
                FillMPDataSession.errorMPPAY("Erro ao realizar pagamento!")
            }
        } else {
            finish()
        }
    }

}