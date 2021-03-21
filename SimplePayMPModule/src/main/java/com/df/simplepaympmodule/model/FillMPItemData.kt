package com.df.simplepaympmodule.model

data class FillMPItemData(
        private val items: List<FillMPItem>,
        private val payer: FillMPPayer,
        private val paymentMethods: FillMPPaymentMethods
)