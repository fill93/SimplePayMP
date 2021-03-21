package com.df.simplepaympmodule.data.repository

import android.util.Log
import com.df.simplepaympmodule.data.api.ApiService
import com.df.simplepaympmodule.model.FillMPDataResponse
import com.df.simplepaympmodule.model.FillMPItemData
import com.df.simplepaympmodule.session.FillMPDataSession
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FillCheckoutRepository: FillCheckoutImpl {

    private var disposable: Disposable? = null

    override fun postFillMPItemDATA (
            fillMPItemData: FillMPItemData,
            success: (dataResponse: FillMPDataResponse) -> Unit,
            error: (throwable: Throwable) -> Unit
    ) {
        ApiService.callApi.postFillCreateProductID(body = fillMPItemData, accessToken = FillMPDataSession.token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {}
            .doAfterTerminate {}
            .subscribe(
                {
                    Log.i("JKK","S")
                    success(it)
                },
                {
                    Log.i("JKK","N")
                    error(it)
                }
            )
            .also { disposable = it }
    }
}