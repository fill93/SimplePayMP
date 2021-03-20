package com.df.simplepaympmodule.ui

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import com.df.simplepaympmodule.data.repository.FillCheckoutImpl
import com.df.simplepaympmodule.model.*
import com.df.simplepaympmodule.util.Constants
import com.mercadopago.android.px.configuration.AdvancedConfiguration
import com.mercadopago.android.px.core.MercadoPagoCheckout
import org.json.JSONException
import org.json.JSONObject

class FillMPCheckoutViewModel(private val repository: FillCheckoutImpl) : ViewModel() {

    //val responseMLD = MutableLiveData<String>()

    private val fillMpItens = listOf(
        FillMPItem("titulo tetse","descriptio", 1,"BRL",1.99)
    )
    private val fillMpPayer = FillMPPayer("filipepimentel.fp@hotail.com")
    private val fillExcudeMethods = listOf(
        FillMPMethodPay("ticket"),
        FillMPMethodPay("atm")
    )
    private val fillMPMethodsPay = FillMPPaymentMethods(fillExcudeMethods,1)
    private val fillMPItemData = FillMPItemData(fillMpItens, fillMpPayer, fillMPMethodsPay)

    fun postCreateProductCheckout(activity: Activity) {
        repository.postFillMPItemDATA(
            fillMPItemData,
            loading = {},
            success = {
                try {
                    val checkout =
                        MercadoPagoCheckout.Builder(
                            "TEST-7e223cec-c303-43cd-8f56-54c97981cefd",
                            it.id!!
                        )
                        .setAdvancedConfiguration(
                            AdvancedConfiguration.Builder().setBankDealsEnabled(false).build()
                        )
                        .build()
                    checkout.startPayment(
                        activity,
                        Constants.REQUEST_PAYMENT
                    )
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            error = {}
        )
    }

}