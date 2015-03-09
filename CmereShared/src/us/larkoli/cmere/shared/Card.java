package us.larkoli.cmere.shared;

public enum Card {
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

	public final int pointValue;
	
	private Card(int pointValue) {
		this.pointValue = pointValue;
	}
	
	public static Card fromPointValue(int pointValue) {
		for (Card card : Card.values()) {
			if (card.pointValue == pointValue) {
				return card;
			}
		}
		
		throw new IllegalArgumentException("No card for point value " + pointValue);
	}
}
