package com.df.simplepaympmodule.session

import com.df.simplepaympmodule.model.*
import com.df.simplepaympmodule.util.ErrroMPPAY
import com.df.simplepaympmodule.util.SuccessMPPAY

internal object FillMPDataSession {
    lateinit var token: String
    lateinit var apiKey: String
    lateinit var fillMPItemData: FillMPItemData
    lateinit var successMPPAY: SuccessMPPAY
    lateinit var errorMPPAY: ErrroMPPAY
}