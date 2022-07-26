package com.fasttrack;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        QuoteService quoteService = new QuoteService(ReadFromFile.readingAllQuotes("files/quotes.txt"));
        System.out.println(quoteService.getQuotesForAuthor("Seneca"));
        quoteService.setFavourite(2873);
        System.out.println(quoteService.getFavourites());
        System.out.println(quoteService.getRandomQuote());
   }
}