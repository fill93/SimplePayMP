package com.df.simplepaympmodule.data.repository

import android.util.Log
import android.view.View
import com.df.simplepaympmodule.data.api.CallApi
import com.df.simplepaympmodule.model.FillMPData
import com.df.simplepaympmodule.model.FillMPItemData
import com.df.simplepaympmodule.session.CheckoutParams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FillCheckoutRepository(private val api: CallApi) : FillCheckoutImpl {

    private var disposable: Disposable? = null

    override fun postFillMPItemDATA(
        fillMPItemData: FillMPItemData,
        success: (data: FillMPData) -> Unit,
        error: (throwable: Throwable) -> Unit
    ) {
        api.postFillCreateProductID(body = fillMPItemData, accessToken = CheckoutParams.token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                //loading(View.VISIBLE)
            }
            .doAfterTerminate {
                //loading(View.GONE)
            }
            .subscribe(
                {
                    Log.i("JKK","Suceso")
                    success(it)
                },
                {
                    Log.i("JKK","Erro::: "+it.cause+"::"+it.message)
                    error(it)
                }
            )
            .also { disposable = it }
    }
}