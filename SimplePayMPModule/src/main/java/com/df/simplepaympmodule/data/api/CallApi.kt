package com.df.simplepaympmodule.data.api

import com.df.simplepaympmodule.model.FillMPData
import com.df.simplepaympmodule.model.FillMPItemData
import io.reactivex.Single
import retrofit2.http.*

interface CallApi {

    @POST("checkout/preferences")
    fun postFillCreateProductID(
        @Header("Content-Type")             header: String = "application/json",
        @Query("access_token")              accessToken: String = "TEST-5641631835692104-091123-8328958ccf078812eb5756755eb1c71d-533881075",
        @Body                               body: FillMPItemData
    ) : Single<FillMPData>

}