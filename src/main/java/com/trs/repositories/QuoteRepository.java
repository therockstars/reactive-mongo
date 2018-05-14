package com.trs.repositories;

import com.trs.domain.Quote;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {

}
