package org.knowm.xchange.currencyconverterapi.service;

import java.io.IOException;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.currencyconverterapi.CurrencyConverterApiAdapters;
import org.knowm.xchange.currencyconverterapi.dto.marketdata.CurrencyConverterApiRate;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;
import org.knowm.xchange.exceptions.ExchangeException;
import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.service.marketdata.MarketDataService;

/**
 * @author daniel-cohen
 */
public class CurrencyConverterApiMarketDataService extends CurrencyConverterApiDataServiceRaw implements MarketDataService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public CurrencyConverterApiMarketDataService(Exchange exchange) {

    super(exchange);
  }

  @Override
  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {

    CurrencyConverterApiRate rate = getCurrencyConverterApiTicker(currencyPair);
    
    if (rate == null) {
      throw new ExchangeException("Problem getting exchange rate! No values was returned for the currencypair:" + currencyPair);
    }

    Double exchangeRate = rate.getVal();
    
    // Adapt to XChange DTOs
    return CurrencyConverterApiAdapters.adaptTicker(currencyPair, exchangeRate);
  }

  @Override
  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {

    throw new NotAvailableFromExchangeException();
  }

  @Override
  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws IOException {

    throw new NotAvailableFromExchangeException();
  }

}
