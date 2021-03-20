package com.df.simplepaympmodule.data.repository

import com.df.simplepaympmodule.model.*

interface FillCheckoutImpl {

    fun postFillMPItemDATA(
        fillMPItemData: FillMPItemData,
        loading: (isVisisble: Int) -> Unit,
        success: (data: FillMPData) -> Unit,
        error: (throwable: Throwable) -> Unit
    )

}