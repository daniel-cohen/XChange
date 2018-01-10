package org.knowm.xchange.currencyconverterapi.service;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.service.BaseExchangeService;
import org.knowm.xchange.service.BaseService;

/**
 * @author daniel-cohen
 */
public class CurrencyConverterApiBaseService extends BaseExchangeService implements BaseService {

  public CurrencyConverterApiBaseService(Exchange exchange) {

    super(exchange);
  }
}
