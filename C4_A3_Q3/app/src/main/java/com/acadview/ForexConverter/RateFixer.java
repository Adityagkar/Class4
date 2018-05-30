package com.acadview.ForexConverter;

public class RateFixer {
    Double currency_1_rate; // 1 currency1 = ? currency2
    Double currency_2_rate;
    String currency1_name;
    String currency2_name;

    public Double getCurrency_1_rate() {
        return currency_1_rate;
    }

    public void setCurrency_1_rate(Double currency_1_rate) {
        this.currency_1_rate = currency_1_rate;
    }

    public Double getCurrency_2_rate() {
        return currency_2_rate;
    }

    public void setCurrency_2_rate(Double currency_2_rate) {
        this.currency_2_rate = currency_2_rate;
    }

    public String getCurrency1_name() {
        return currency1_name;
    }

    public void setCurrency1_name(String currency1_name) {
        this.currency1_name = currency1_name;
    }

    public String getCurrency2_name() {
        return currency2_name;
    }

    public void setCurrency2_name(String currency2_name) {
        this.currency2_name = currency2_name;
    }
}
