//4) creati un obiect QuoteService care ofera urmatoarele metode:
//- getAllQuotes():List<String>
//- getQuotesForAuthor(String author): List<Quote>
//- getAuthors(): List<String>
//- setFavourite(int id)
//- getFavourites():List<Quote>
//- getRandomQuote():String : generati un numar random cu ajutorul obiectului java.util.Random si returnati quote-ul cu acel id
package com.fasttrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class QuoteService extends Quote {

    private List<Quote> quotesReadFromFile;

    public QuoteService(List<Quote> quotesReadFromFile) {
        this.quotesReadFromFile = quotesReadFromFile;
    }

    public String getRandomQuote() {
        Random random = new Random();
        int randomQuote = random.nextInt(1, quotesReadFromFile.size() + 1);
        return getQuote(randomQuote);
    }

    public List<Quote> getFavourites() {
        List<Quote> list = new LinkedList<>();
        for (Quote quote : quotesReadFromFile) {
            if (quote.isTheOne == true) {
                list.add(quote);
            }
        }
        return list;
    }

    public void setFavourite(int id) {
        for (Quote quote : quotesReadFromFile) {
            if (quote.getId() == id) {
                quote.setFavourite(true);
            }
        }
    }

    public List<String> getAuthors() {
        List<String> list = new LinkedList<>();
        for (Quote quote : quotesReadFromFile) {
            list.add(quote.getAuthor());
        }
        return list;
    }

    public List<Quote> getQuotesForAuthor(String author) {
        List<Quote> list = new LinkedList<>();
        for (Quote quote : quotesReadFromFile) {
            if ((quote.getAuthor()).equals(author)) {
                list.add(quote);
            }
        }
        return list;
    }

    public List<String> getAllQuotes() {
        List<String> listOfQuotes = new LinkedList<>();
        for (Quote quote : quotesReadFromFile) {
            listOfQuotes.add(quote.getQuote());
        }
        return listOfQuotes;
    }

    public String getQuote(int id) {
        for (Quote quote : quotesReadFromFile) {
            if (quote.getId() == id) {
                return quote.getQuote();
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "QuoteService{" +
                "quotesReadFromFile=" + quotesReadFromFile +
                '}';
    }
}