package com.df.simplepaympmodule.session

import com.df.simplepaympmodule.model.FillMPItemData

class FillMPSession {
    fun loadSession(
            token: String,
            apiKey: String,
            fillMPItemData: FillMPItemData
    ) {
        CheckoutParams.token = token
        CheckoutParams.apiKey = apiKey
        CheckoutParams.fillMPItemData = fillMPItemData
    }
}