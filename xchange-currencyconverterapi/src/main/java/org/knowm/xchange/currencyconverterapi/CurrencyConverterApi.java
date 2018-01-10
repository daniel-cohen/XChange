package org.knowm.xchange.currencyconverterapi;

import java.io.IOException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.knowm.xchange.currencyconverterapi.dto.marketdata.CurrencyConverterApiTickers;

/**
 * @author daniel-cohen
 */
@Path("api/v5")
@Produces(MediaType.APPLICATION_JSON)
public interface CurrencyConverterApi {
	
  @GET
  @Path("convert")
  // NOTE: currencies is a comma separated string list. E.g: USD_PHP,USD_AUD 
  CurrencyConverterApiTickers getTickers(
      @QueryParam("q") String currencies, 
		  @DefaultValue("y") @QueryParam("compact") String compact
		  ) throws IOException;

}
