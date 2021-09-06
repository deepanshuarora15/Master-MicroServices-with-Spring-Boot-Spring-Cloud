package com.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
		@Autowired
		private Environment environment;
		
		@Autowired
		private CurrencyExchangeRepository repository;
		@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
		public CurrencyExchange retrieveChangeValue(@PathVariable String from, @PathVariable String to) {
			//CurrencyExchange currencyExchange = new CurrencyExchange(1000L, "USD", "INR", BigDecimal.valueOf(65));
			CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
			if(currencyExchange==null) {
				throw new RuntimeException("Unable to find data for the given link");
			}
			String port = environment.getProperty("local.server.port");
			currencyExchange.setEnvironment(port);
			return currencyExchange;
		}
}
