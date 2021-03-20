package com.df.simplepaympmodule.model;

import java.util.List;

public class FillMPPaymentMethods {

    private List<FillMPMethodPay> excludedPaymentTypes;
    private int installments;

    public FillMPPaymentMethods(List<FillMPMethodPay> excluded_payment_types, int installments) {
        this.excludedPaymentTypes = excluded_payment_types;
        this.installments = installments;
    }

    public List<FillMPMethodPay> getExcludedPaymentTypes() {
        return excludedPaymentTypes;
    }

    public void setExcludedPaymentTypes(List<FillMPMethodPay> excludedPaymentTypes) {
        this.excludedPaymentTypes = excludedPaymentTypes;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }


}
