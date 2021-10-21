import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
	private List<Card> deck;
	
	public CardDeck() {
		deck = new ArrayList<>();
		for (Card.Suits s : Card.Suits.values()) {
			for (Card.Ranks r : Card.Ranks.values()) {
				deck.add(new Card(s, r));
			}
		}
	}
	
	public List<Card> deal(int n) {
		List<Card> hand;
		List<Card> deckLeft = new ArrayList<>();
		if (n > deck.size()) {
			hand = new ArrayList<>(deck);
			deckLeft = new ArrayList<>();
			System.out.println("Out of cards.");
		} else {
			hand = new ArrayList<>(deck.subList(0, n));
			deckLeft = deck.subList(n, deck.size());
		}
		deck = deckLeft;
		System.out.println("* Dealt " + Math.min(hand.size(), n) + "cards. ");
		return hand;
	}
	
	public void putBack(List<Card> hand) {
		deck.addAll(hand);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public void peek(int n) {
		System.out.println(">>>> First " + n + " card(s): ");
		for (int i = 0; i < n && i < deck.size(); i++) {
			System.out.println(deck.get(i));
		}
		if (n > deck.size()) {
			System.out.println("Out of cards.");
		}
	}
	
	public void print() {
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i));
		}
	}
}