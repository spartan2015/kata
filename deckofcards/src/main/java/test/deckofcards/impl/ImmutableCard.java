package test.deckofcards.impl;

import test.deckofcards.Card;
import test.deckofcards.Rank;
import test.deckofcards.Suite;

public class ImmutableCard implements Card {

	private final Suite suite;
	private final Rank rank;
	
	public ImmutableCard(Suite suite, Rank rank){
		this.suite = suite;
		this.rank  = rank;
	}
	
	public Suite getSuit() {
		return suite;
	}

	public Rank getRank() {
		return rank;
	}
	
	@Override
	public int hashCode() {		
		return 7 * suite.ordinal() + 3 * rank.ordinal();
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) return false;
		Card second = (Card)obj;
		return second.getSuit() == this.suite && second.getRank() == this.rank;
	}

}
