package com.df.simplepaympmodule.data.repository

import com.df.simplepaympmodule.model.*

interface FillCheckoutImpl {

    fun postFillMPItemDATA(
        fillMPItemData: FillMPItemData,
        success: (data: FillMPData) -> Unit,
        error: (throwable: Throwable) -> Unit
    )

}