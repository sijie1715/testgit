public class CardDeckTester {
	public static void main(String[] args) {
		CardDeck deck1 = new CardDeck();
		deck1.peek(5);
		deck1.shuffle();
		deck1.peek(5);
		
		Hand hand1 = new Hand(deck1.deal(5));
		hand1.print();
		
		deck1.deal(53);
		deck1.peek(1);
	}
	
}