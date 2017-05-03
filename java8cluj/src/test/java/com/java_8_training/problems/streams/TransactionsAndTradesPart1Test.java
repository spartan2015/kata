package com.java_8_training.problems.streams;


import com.java_8_training.answers.streams.Trader;
import com.java_8_training.answers.streams.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransactionsAndTradesPart1Test {

    private List<Transaction> transactions = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    public void findSortedTransactionsFrom2011() {
        //TODO: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> transactionsYear2011 = new ArrayList<>();

        assertEquals(300, transactionsYear2011.get(0).getValue());
        assertEquals(2011, transactionsYear2011.get(0).getYear());

        assertEquals(400, transactionsYear2011.get(1).getValue());
        assertEquals(2011, transactionsYear2011.get(1).getYear());

        assertEquals(2, transactionsYear2011.size());
    }

    @Test
    public void findUniqueCitiesWhereTradersWork() {
        //TODO: What are all the unique cities where the traders work?
        List<String> cities = new ArrayList<>();

        assertEquals(2, cities.size());
        assertTrue(cities.contains("Cambridge"));
        assertTrue(cities.contains("Milan"));

    }

    @Test
    public void findTradersFromCambridgeSortedByName() {
        //TODO: Find all traders from Cambridge and sort them by name.
        List<Trader> traders = new ArrayList<>();


        assertEquals(3, traders.size());
        assertEquals("Alan", traders.get(0).getName());
        assertEquals("Brian", traders.get(1).getName());
        assertEquals("Raoul", traders.get(2).getName());
    }

    @Test
    public void formatTradersNamesSorted() {
        //TODO: Return a string of all traders’ names sorted alphabetically.
        String result = "";

        assertEquals("AlanBrianMarioRaoul", result);
    }

    @Test
    public void findMilaneseTraders() {
        //TODO: Are there any trader based in Milan?
        boolean milan = false;


        assertTrue(milan);
    }

    @Test
    public void moveMilaneseTradersToCambridge() {
        //TODO: Update all transactions so that the traders from Milan are set to Cambridge.

        assertTrue(transactions.stream().allMatch(t -> "Cambridge".equals(t.getTrader().getCity())));

    }

    @Test
    public void findHighestValueTransaction() {
        //TODO: What's the highest value in all the transactions?
        int highestValue = -1;

        assertEquals(1000, highestValue);
    }

    @Test
    public void findLowestValueTransaction() {
        //TODO: What's the transaction with lowest value?
        Transaction smallestTransaction = null;

        assertEquals(transactions.get(0), smallestTransaction);
    }

}
