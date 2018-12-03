package DeckOfCards;

public enum Rank {
	
	ACE("Ace", 1), 
	TWO("Two", 2), 
	THREE("Three", 3), 
	FOUR("Four", 4), 
	FIVE("Five", 5), 
	SIX("Six", 6), 
	SEVEN("Seven", 7), 
	EIGHT("Eight", 8),	
	NINE("Nine", 9), 
	TEN("Ten", 10), 
	JACK("Jack", 10), 
	QUEEN("Queen", 10), 
	KING("King", 10);

	private String rankName;
	private int rankValue;
	
	private Rank(String rankName, int rankValue){
		this.setRankName(rankName);
		this.rankValue = rankValue;
	}

	public int getRankValue() {
		return rankValue;
	}

	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
}