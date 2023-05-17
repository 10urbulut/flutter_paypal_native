package com.piccmaq.flutter_paypal_native.models.shippingdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.paypal.checkout.shipping.ShippingChangeData;
import com.paypal.checkout.shipping.ShippingChangeType;

import java.util.List;


public class ShippingChangeDataHelper {

    @SerializedName("payToken")
    @Expose
    private String payToken;
    @SerializedName("paymentId")
    @Expose
    private String paymentId;
    @SerializedName("shippingChangeType")
    @Expose
    private String shippingChangeType;
    @SerializedName("shippingChangeAddress")
    @Expose
    private ShippingChangeAddress shippingAddress;
    @SerializedName("shippingOptions")
    @Expose
    private List<ShippingOption> shippingOptions = null;
    @SerializedName("selectedShippingOption")
    @Expose
    private ShippingOption selectedShippingOption = null;

    public static ShippingChangeDataHelper preparefromPaypalShippingChangeData(ShippingChangeData data) {
        ShippingChangeDataHelper val = new ShippingChangeDataHelper();

        List<ShippingOption> options = ShippingOption
                .fromPaypalOptionsList(data.getShippingOptions());
        val.setShippingOptions(options);

        val.setPaymentId(data.getPaymentId());
        val.setPayToken(data.getPayToken());
        val.setShippingAddress(
                ShippingChangeAddress.fromPaypalShippingChangeAddress(
                        data.getShippingAddress()
                )
        );

        val.setSelectedShippingOption(
                ShippingOption.fromPaypalOptions(
                        data.getSelectedShippingOption()
                )
        );


        ShippingChangeType tt = data.getShippingChangeType();
        if (tt == ShippingChangeType.ADDRESS_CHANGE) {
            val.setShippingChangeType("address_change");
        } else if (tt == ShippingChangeType.OPTION_CHANGE) {
            val.setShippingChangeType("option_change");
        }

        return val;
    }

    public String getPayToken() {
        return payToken;
    }

    public void setPayToken(String payToken) {
        this.payToken = payToken;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getShippingChangeType() {
        return shippingChangeType;
    }

    public void setShippingChangeType(String shippingChangeType) {
        this.shippingChangeType = shippingChangeType;
    }

    public ShippingChangeAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingChangeAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<ShippingOption> getShippingOptions() {
        return shippingOptions;
    }

    public void setShippingOptions(List<ShippingOption> shippingOptions) {
        this.shippingOptions = shippingOptions;
    }

    public ShippingOption getSelectedShippingOption() {
        return selectedShippingOption;
    }

    public void setSelectedShippingOption(ShippingOption selectedShippingOption) {
        this.selectedShippingOption = selectedShippingOption;
    }

}
