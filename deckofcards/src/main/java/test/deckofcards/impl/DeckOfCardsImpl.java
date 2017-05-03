package test.deckofcards.impl;

import java.util.Random;

import test.deckofcards.Card;
import test.deckofcards.DeckOfCards;
import test.deckofcards.Rank;
import test.deckofcards.Suite;

public class DeckOfCardsImpl implements DeckOfCards {

	private int currentStartIndex = 0;
	private Card[] cards = new Card[52];

	public DeckOfCardsImpl() {
		int currentIndex = 0;
		for (Suite suite : Suite.values()) {
			for (Rank rank : Rank.values()) {
				cards[currentIndex++] = new ImmutableCard(
						suite, rank);
			}
		}
	}

	public synchronized void  shuffle() {
		if (size() <= 1) return;
		Random generator = new Random();

		for (int i = 0; i < 100; i++) {
			int index_1 = generator.nextInt(size() - 1);
			int index_2 = generator.nextInt(size() - 1);

			Card temp = (Card) cards[getRealIndex(index_2)];
			cards[getRealIndex(
					index_2)] = cards[getRealIndex(
							index_1)];
			cards[getRealIndex(index_1)] = temp;
		}
	}

	public synchronized Card pop() {
		return currentStartIndex <52 ? cards[currentStartIndex++] : null;
	}

	private int getRealIndex(int logicalIndex) {
		return currentStartIndex + logicalIndex;
	}

	public synchronized int size() {
		return 52 - currentStartIndex;
	}

}
