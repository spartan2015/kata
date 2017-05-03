package test.deckofcards;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import test.deckofcards.impl.DeckOfCardsImpl;

public class DeckOfCardsImplTest {

	@Test
	public void initialSizeIs52(){
		DeckOfCards cards = new DeckOfCardsImpl();
		assertTrue(52 == cards.size());
	}
	
	@Test
	public void assertDeckHasNoMoreAndNoLessThan4Suites(){
		DeckOfCards deckOfCards = new DeckOfCardsImpl();
		Card[] cardsSet1 = extracted(deckOfCards);
		int[] suites = new int[4];
		for(Card card: cardsSet1){
			suites[card.getSuit().ordinal()]++;			
		}
		
		for(int actual : suites){
			assertTrue(13 == actual);
		}
	}
	
	@Test
	public void assertDeckHasNoMoreAndNoLessThan13RanksPerSuite(){
		DeckOfCards deckOfCards = new DeckOfCardsImpl();
		Card[] cardsSet1 = extracted(deckOfCards);
		int[] ranks = new int[13];
		for(Card card: cardsSet1){
			ranks[card.getRank().ordinal()]++;			
		}
		
		for(int actual : ranks){
			assertTrue(4 == actual);
		}
	}
	
	@Test
	public void shuffleTest(){
		DeckOfCards deckOfCards = new DeckOfCardsImpl();
		Card[] cardsSet1 = extracted(deckOfCards);
		
		deckOfCards = new DeckOfCardsImpl();
		deckOfCards.shuffle();
		Card[] cardsSet2 = extracted(deckOfCards);
		assertFalse(Arrays.equals(cardsSet1, cardsSet2));
		
		// check that result still contains the 52 cards that were before the shuffle
	}

	@Test()
	public void noMoreThan52(){
		DeckOfCards deckOfCards = new DeckOfCardsImpl();
		Card[] cards = extracted(deckOfCards, 53);
		assertNull(cards[52]);
	}
	
	private Card[] extracted(DeckOfCards deckOfCards) {
		return extracted(deckOfCards, 52);
	}

	private Card[] extracted(DeckOfCards deckOfCards, int no) {
		Card[] cardsArray = new Card[no];
		for(int i = 0; i < no; i++){
			cardsArray[i] = deckOfCards.pop();
		}
		return cardsArray;
	}
}
