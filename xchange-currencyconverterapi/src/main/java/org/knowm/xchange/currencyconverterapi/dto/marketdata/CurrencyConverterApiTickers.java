package org.knowm.xchange.currencyconverterapi.dto.marketdata;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * *
 * <p>
 * Data object representing a Exchange Rates from Open ExchangeRates
 * </p>
 * Auto-generated using the simplest types possible with conversion delegated to the adapter
 *
 * @author daniel-cohen
 */
public final class CurrencyConverterApiTickers {
  /**
   * Constructor
   *
   * @param rates
   * @param timestamp
   */

	
	/*
	 * Sample JSon:
	 {
		"USD_AUD" : {
			"val" : 1.27702
		},
		"EUR_USD" : {
			"val" : 1.195025
		}
	}
	*/
 
  
  // Properties without set values (e.g: "AUD_USD" , "AUD_EUR" "USD_ILS" etc..):
  protected Map<String,CurrencyConverterApiRate> other = new HashMap<String,CurrencyConverterApiRate>();
  
  public CurrencyConverterApiRate get(String name) {
      return other.get(name);
  }

  // "any getter" needed for serialization    
  @JsonAnyGetter
  public Map<String,CurrencyConverterApiRate> any() {
      return other;
  }

  @JsonAnySetter
  public void set(String name, CurrencyConverterApiRate value) {
      other.put(name, value);
  }
  

  @Override
  public String toString() {
    return "CurrencyConverterApiTickers [" + other.toString() + "]";
  }

}
