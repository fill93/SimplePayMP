package com.df.simplepaympmodule

import android.app.Activity
import android.view.View
import com.df.simplepaympmodule.data.repository.FillCheckoutRepository
import com.df.simplepaympmodule.model.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import com.mercadopago.android.px.core.MercadoPagoCheckout


class FillMPCheckout {

    private fun createProductIDAndCheckout(
        activity: Activity,
        fillMPItens: List<FillMPItem>,
        fillMPPayer: FillMPPayer,
        fillMPExcludeMethods: List<FillMPMethodPay>
    ) {
        //object : Thread() {
            //override fun run() {
                //val mpItem = FillMPItem(titulo, descricao, 1, "BRL", valor)
                //val mpItens = mutableListOf<FillMPItem>()
                //mpItens.add(fillMPItem)
                //val mpPayer = FillMPPayer(fillMPPayer.email)
                //val mPMethods: ArrayList<*> = ArrayList<FillMPMethodPay>()
                //mPMethods.add(FillMPMethodPay("ticket"))
                //mPMethods.add(FillMPMethodPay("atm"))

                val fillPaymentMethods = FillMPPaymentMethods(fillMPExcludeMethods, 1)
                //val mpItemData = FillMPItemData(fillMPItens, fillMPPayer, fillPaymentMethods)
                try {
                    /*val response = ""
                    FillCheckoutRepository().postFillMPItemDATA(
                        success = {},
                        error = {}
                    )*/
                    //val json = JSONObject(CheckoutMP().postPreferenceId(mpItemData))
                    /*val checkout: MercadoPagoCheckout = Builder(
                        BuildConfig.PUBLIC_KEY_MERCADOPAGO, json.getString("id")
                    )
                        .setAdvancedConfiguration(Builder().setBankDealsEnabled(false).build())
                        .build()
                    checkout.startPayment(
                        activity,
                        com.mh.fideliza.pagament.RecarregarChave.REQUEST_CODE
                    )*/
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
                //runOnUiThread(Runnable { loading.setVisibility(View.GONE) })
            //}
        //}.start()
    }
}