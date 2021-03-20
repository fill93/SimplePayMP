package com.df.simplepaympmodule.model;

import java.util.List;

public class FillMPItemData {

    private List<FillMPItem> items;
    private FillMPPayer payer;
    private FillMPPaymentMethods paymentMethods;

    public FillMPItemData(List<FillMPItem> items, FillMPPayer payer, FillMPPaymentMethods paymentMethods) {
        this.items = items;
        this.payer = payer;
        this.paymentMethods = paymentMethods;
    }

    public List<FillMPItem> getItems() {
        return items;
    }

    public void setItems(List<FillMPItem> items) {
        this.items = items;
    }

    public FillMPPayer getPayer() {
        return payer;
    }

    public void setPayer(FillMPPayer payer) {
        this.payer = payer;
    }

    public FillMPPaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(FillMPPaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
}
