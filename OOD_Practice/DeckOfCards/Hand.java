import java.util.List;

public class Hand {
	private List<Card> hand;
	public Hand() {
		
	}
	public Hand(List<Card> hand) {
		this.hand = hand;
	}
	public void print() {
		System.out.println(">>>> Showing hand: ");
		if (hand.isEmpty()) {
			System.out.println("No cards to show.");
		} else {
			for (Card c : hand) {
				System.out.println(c);
			}
		}
	}
}