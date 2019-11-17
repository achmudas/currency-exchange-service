package co.kurapka.microservices.currencyexchangeservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.kurapka.microservices.currencyexchangeservice.model.ExchangeValue;
import co.kurapka.microservices.currencyexchangeservice.model.ExchangeValueJpaRepository;

@RestController
public class CurrencyExchangeController {

	private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private Environment env;

	@Autowired
	private ExchangeValueJpaRepository jpaRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exValue = jpaRepository.findByFromAndTo(from, to);
		exValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		log.info("exValue -> {}", exValue);
		return exValue;
	}

}
