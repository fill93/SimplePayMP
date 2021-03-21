package com.df.simplepaympmodule.model

class FillMPItemData(builder: Builder) {

    val itens: List<FillMPItem> = builder.itensIN
    val payer: FillMPPayer = builder.payerIN
    val paymentMethods: FillMPPaymentMethods = builder.paymentMethodsIN

    class Builder {

        lateinit var itensIN: List<FillMPItem>
        lateinit var payerIN: FillMPPayer
        lateinit var paymentMethodsIN: FillMPPaymentMethods

        fun setFillMPItens(itens: List<FillMPItem>): Builder{
            this.itensIN = itens
            return this
        }
        fun setFillMPPayer(payer: FillMPPayer): Builder{
            this.payerIN = payer
            return this
        }
        fun setFillMPPaymentMethods(paymentMethods: FillMPPaymentMethods): Builder{
            this.paymentMethodsIN = paymentMethods
            return this
        }
        fun build(): FillMPItemData{
            return FillMPItemData(this)
        }
    }


}