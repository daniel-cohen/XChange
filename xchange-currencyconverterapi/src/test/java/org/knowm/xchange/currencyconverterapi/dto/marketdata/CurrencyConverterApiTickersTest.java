package org.knowm.xchange.currencyconverterapi.dto.marketdata;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author daniel-cohen
 */
public class CurrencyConverterApiTickersTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is = CurrencyConverterApiTickersTest.class.getResourceAsStream("/example-latest-rates.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    CurrencyConverterApiTickers currencyConverterApiTickers = mapper.readValue(is, CurrencyConverterApiTickers.class);

    // Verify that the example data was unmarshalled correctly
    System.out.println(currencyConverterApiTickers.get("USD_AUD"));
    assertThat(currencyConverterApiTickers.get("USD_AUD").getVal()).isEqualTo(1.27702);
    
    System.out.println(currencyConverterApiTickers.get("EUR_USD"));
    assertThat(currencyConverterApiTickers.get("EUR_USD").getVal()).isEqualTo(1.195025);
  }
}
