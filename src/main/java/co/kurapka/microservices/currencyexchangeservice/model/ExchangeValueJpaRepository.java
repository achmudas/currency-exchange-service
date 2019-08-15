package co.kurapka.microservices.currencyexchangeservice.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueJpaRepository extends JpaRepository<ExchangeValue, Long>{
	
	ExchangeValue findByFromAndTo(String from, String to);

}
