package com.trs;

import com.trs.client.StockQuoteClient;
import com.trs.domain.Quote;
import com.trs.repositories.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class QuoteRunner implements CommandLineRunner {

    private final StockQuoteClient stockQuoteClient;
    private final QuoteRepository quoteRepository;

    public QuoteRunner(StockQuoteClient stockQuoteClient, QuoteRepository quoteRepository) {
        this.stockQuoteClient = stockQuoteClient;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       Flux<Quote> quoteFlux = stockQuoteClient.getQuoteStream();

       quoteFlux.take(5)
       .subscribe(quote -> {
           System.out.println("Val==>" + quote.getTicker() + " " + quote.getId());
           try {
               Mono<Quote> savedQuote = quoteRepository.save(quote);
               System.out.println("Quote Saved........ " + savedQuote.toProcessor().block().getId());
           }
           catch (Exception e) {
               e.printStackTrace();
           }
       });

//        stockQuoteClient.getQuoteStream()z
//                .log("quote-monitor-service")
//                .subscribe(quote -> {
//                    Mono<Quote> savedQuote = quoteRepository.save(quote);
//
//                    System.out.println("I saved a quote! Id: " +savedQuote.block().getId());
//                });
    }
}
