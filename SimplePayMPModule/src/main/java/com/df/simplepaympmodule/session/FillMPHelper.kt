package com.df.simplepaympmodule.session

import android.app.Activity
import android.content.Intent
import com.df.simplepaympmodule.model.FillMPItemData
import com.df.simplepaympmodule.ui.FillMPCheckoutActivity
import com.df.simplepaympmodule.util.ErrroMPPAY
import com.df.simplepaympmodule.util.SuccessMPPAY

class FillMPHelper {

    fun initFillMP (
            activity: Activity,
            token: String,
            apiKey: String,
            fillMPItemData: FillMPItemData,
            successMPPAY: SuccessMPPAY,
            errorMPPAY: ErrroMPPAY
    ) {
        FillMPDataSession.token = token
        FillMPDataSession.apiKey = apiKey
        FillMPDataSession.fillMPItemData = fillMPItemData
        FillMPDataSession.successMPPAY = successMPPAY
        FillMPDataSession.errorMPPAY = errorMPPAY
        activity.startActivity(Intent(activity, FillMPCheckoutActivity::class.java))
    }

}