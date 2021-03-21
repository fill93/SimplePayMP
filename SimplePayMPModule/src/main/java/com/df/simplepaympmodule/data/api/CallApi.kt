package com.df.simplepaympmodule.data.api

import com.df.simplepaympmodule.model.FillMPDataResponse
import com.df.simplepaympmodule.model.FillMPItemData
import io.reactivex.Single
import retrofit2.http.*

interface CallApi {

    @POST("checkout/preferences")
    fun postFillCreateProductID(
        @Header("Content-Type")             header: String = "application/json",
        @Query("access_token")              accessToken: String,
        @Body                               body: FillMPItemData
    ) : Single<FillMPDataResponse>

}