package com.df.simplepaympmodule.data.repository

import com.df.simplepaympmodule.model.*

interface FillCheckoutImpl {

    fun postFillMPItemDATA(
            fillMPItemData: FillMPItemData,
            success: (dataResponse: FillMPDataResponse) -> Unit,
            error: (throwable: Throwable) -> Unit
    )

}