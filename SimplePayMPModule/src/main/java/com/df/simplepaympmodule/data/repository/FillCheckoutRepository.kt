package com.df.simplepaympmodule.data.repository

import android.view.View
import com.df.simplepaympmodule.data.api.CallApi
import com.df.simplepaympmodule.model.FillMPData
import com.df.simplepaympmodule.model.FillMPItemData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FillCheckoutRepository(private val api: CallApi) : FillCheckoutImpl {

    private var disposable: Disposable? = null

    override fun postFillMPItemDATA(
        fillMPItemData: FillMPItemData,
        loading: (isVisisble: Int) -> Unit,
        success: (data: FillMPData) -> Unit,
        error: (throwable: Throwable) -> Unit
    ) {
        api.postFillCreateProductID(body = fillMPItemData)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                loading(View.VISIBLE)
            }
            .doAfterTerminate {
                loading(View.GONE)
            }
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