
public class Card {

	private Suits suit;
	private Ranks rank;
	
	public enum Suits {
		SPADE, HEART, CLUB, DIAMOND
	}
	
	public enum Ranks {
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
		EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
		
		int priority;
		
		// why only private here?
		Ranks(int n) {
			this.priority = n;
		}
	}
	
	public Card(Suits suit, Ranks rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String getSuit() {
		return this.suit.toString();
	}
	
	public String getRank() {
		return this.rank.toString();
	}
	
	@Override
	public String toString() {
		return rank.priority + "\t" + suit;
	}
}
