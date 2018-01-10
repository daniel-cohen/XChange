package org.knowm.xchange.currencyconverterapi;

import java.math.BigDecimal;

import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;

/**
 * Various adapters for converting from CurrencyConverterApi DTOs to XChange DTOs
 * 
 * @author daniel-cohen
 */
public final class CurrencyConverterApiAdapters {

  /**
   * private Constructor
   */
  private CurrencyConverterApiAdapters() {

  }

  public static Ticker adaptTicker(CurrencyPair currencyPair, Double exchangeRate) {

    BigDecimal last = BigDecimal.valueOf(exchangeRate);
    return new Ticker.Builder().currencyPair(currencyPair).last(last).timestamp(null).build();
  }

}
