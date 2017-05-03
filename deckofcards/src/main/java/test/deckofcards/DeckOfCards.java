package test.deckofcards;

public interface DeckOfCards {

	/**
	 * shuffle the deck of cards
	 */
	void shuffle();
	
	/**
	 * retrieves and remove a card
	 * or null is deck is empty 
	 * 
	 * @return
	 */
	Card pop();
	
	int size();
	
}
