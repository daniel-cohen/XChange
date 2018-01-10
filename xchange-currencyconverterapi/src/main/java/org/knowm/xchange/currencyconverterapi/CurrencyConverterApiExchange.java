package org.knowm.xchange.currencyconverterapi;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currencyconverterapi.service.CurrencyConverterApiMarketDataService;

import si.mazi.rescu.SynchronizedValueFactory;

/**
 * @author daniel-cohen
 */
public class CurrencyConverterApiExchange extends BaseExchange implements Exchange {

  @Override
  protected void initServices() {
    this.marketDataService = new CurrencyConverterApiMarketDataService(this);
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setPlainTextUri("https://free.currencyconverterapi.com");
    exchangeSpecification.setHost("free.currencyconverterapi.com");
    exchangeSpecification.setPort(443);
    exchangeSpecification.setExchangeName("Currency Converter API");
    exchangeSpecification.setExchangeDescription("Free Currency Converter API offers free web services for developers to convert one currency to another.");

    return exchangeSpecification;
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {
    // No private API implemented. Not needed for this exchange at the moment.
    return null;
  }
}
