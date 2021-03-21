package com.df.simplepaympmodule.data.repository

import com.df.simplepaympmodule.data.api.CallApi
import com.df.simplepaympmodule.model.FillMPDataResponse
import com.df.simplepaympmodule.model.FillMPItemData
import com.df.simplepaympmodule.session.FillMPDataSession
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FillCheckoutRepository(private val api: CallApi) : FillCheckoutImpl {

    private var disposable: Disposable? = null

    override fun postFillMPItemDATA(
            fillMPItemData: FillMPItemData,
            success: (dataResponse: FillMPDataResponse) -> Unit,
            error: (throwable: Throwable) -> Unit
    ) {
        api.postFillCreateProductID(body = fillMPItemData, accessToken = FillMPDataSession.token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {}
            .doAfterTerminate {}
            .subscribe(
                {
                    success(it)
                },
                {
                    error(it)
                }
            )
            .also { disposable = it }
    }
}