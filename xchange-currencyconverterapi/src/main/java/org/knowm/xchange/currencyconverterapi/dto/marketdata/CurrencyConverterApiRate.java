package org.knowm.xchange.currencyconverterapi.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The exchange rate.
 *
 * @author daniel-cohen
 */
public class CurrencyConverterApiRate{

  private double Val;

  public double getVal() {

    return this.Val;
  }

  @JsonProperty("val")
  public void setVal(double val) {

    this.Val = val;
  }

  @Override
  public String toString() {

    return "Val [" + Val + "]";
  }

}
