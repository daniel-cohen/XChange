package org.knowm.xchange.currencyconverterapi.service;

import java.io.IOException;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.currencyconverterapi.CurrencyConverterApi;
import org.knowm.xchange.currencyconverterapi.dto.marketdata.CurrencyConverterApiRate;
import org.knowm.xchange.currencyconverterapi.dto.marketdata.CurrencyConverterApiTickers;
import org.knowm.xchange.exceptions.ExchangeException;

import si.mazi.rescu.RestProxyFactory;

/**
 * @author daniel-cohen
 */
public class CurrencyConverterApiDataServiceRaw extends CurrencyConverterApiBaseService {

  private final CurrencyConverterApi currencyConverterApi;

  /**
   * Constructor
   *
   * @param exchange
   */
  public CurrencyConverterApiDataServiceRaw(Exchange exchange) {

    super(exchange);
    this.currencyConverterApi = RestProxyFactory.createProxy(CurrencyConverterApi.class, exchange.getExchangeSpecification().getPlainTextUri(), getClientConfig());
  }

  public CurrencyConverterApiRate getCurrencyConverterApiTicker(CurrencyPair currencyPair) throws IOException {

    
    
    String currencyPairStr = currencyPair.base.getCurrencyCode() + "_" + currencyPair.counter.getCurrencyCode();
    
    
    // Request data
    CurrencyConverterApiTickers currencyConverterApiTickers = currencyConverterApi.getTickers(currencyPairStr, "y");

    if (currencyConverterApiTickers == null) {
      throw new ExchangeException("Null response returned from currency Converter Api!");
    }

    CurrencyConverterApiRate rate = currencyConverterApiTickers.get(currencyPairStr);

    // Adapt to XChange DTOs
    return rate;
  }

}
