package com.df.simplepaympmodule.di

import com.df.simplepaympmodule.data.api.ApiService
import com.df.simplepaympmodule.data.repository.FillCheckoutImpl
import com.df.simplepaympmodule.data.repository.FillCheckoutRepository

/*
val apisModule = module {
    single { ApiService.callApi }
}

val repositoryesModule = module {
    single { FillCheckoutRepository(api =  get()) } bind FillCheckoutImpl::class
}

val viewModelsModule = module {
    viewModel {
        FillMPCheckoutViewModel(
            repository = get()
        )
    }
}*/
