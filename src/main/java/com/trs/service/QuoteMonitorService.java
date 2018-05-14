package com.trs.service;

import com.trs.client.StockQuoteClient;
import com.trs.domain.Quote;
import com.trs.repositories.QuoteRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QuoteMonitorService implements ApplicationListener<ContextRefreshedEvent> {

    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository quoteRepository;

    public QuoteMonitorService(StockQuoteClient stockQuoteClient, QuoteRepository quoteRepository) {
        this.stockQuoteClient = stockQuoteClient;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        stockQuoteClient.getQuoteStream()
//                .log("quote-monitor-service")
//                .subscribe(quote -> {
//                    Mono<Quote> savedQuote = quoteRepository.save(quote);
//
//                    System.out.println("I saved a quote! Id: " +savedQuote.block().getId());
//                });

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<< GOT EVENT >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
}