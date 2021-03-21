package com.df.simplepaympmodule.ui
/*
import android.app.Activity
import androidx.lifecycle.ViewModel
import com.df.simplepaympmodule.data.repository.FillCheckoutImpl
import com.df.simplepaympmodule.session.FillMPDataSession.apiKey
import com.df.simplepaympmodule.session.FillMPDataSession.fillMPItemData
import com.df.simplepaympmodule.util.Constants
import com.mercadopago.android.px.configuration.AdvancedConfiguration
import com.mercadopago.android.px.core.MercadoPagoCheckout
import org.json.JSONException

class FillMPCheckoutViewModel(private val repository: FillCheckoutImpl) : ViewModel() {

    fun postCreateProductAndCheckout(activity: Activity) {
        repository.postFillMPItemDATA(
            fillMPItemData,
            success = {
                try {
                    val checkout =
                        MercadoPagoCheckout.Builder(apiKey, it.id!!)
                        .setAdvancedConfiguration(
                            AdvancedConfiguration.Builder()
                                    .setBankDealsEnabled(false)
                                    .build()
                        ).build()
                    checkout.startPayment(activity, Constants.REQUEST_PAYMENT)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            error = {}
        )
    }

}*/
