package CardGame;

import java.util.Random;

public class Card {
	public static final int SPADES=0;
	public static final int HEARTS=1;
	public static final int DIAMONDS=2;
	public static final int CLUBS=3;
	
	
	
	
	private static final Random rand=new Random();
	public static final Card[] cards=new Card[13*4];
	private int suit;
	private  int rank;
	static { //static inatializer
		for(int i=SPADES;i<=CLUBS;i++) {
			for(int j=1;j<=13;j++) {
				cards[i*13+j-1]=new Card(i,j);
			}
		}
	}
	private Card(int suit, int rank) {
		this.suit=suit;
		this.rank=rank;
	}
	
	
	
	
	public int getSuit() {
		return suit;
	}




	public void setSuit(int suit) {
		this.suit = suit;
	}




	public int getRank() {
		return rank;
	}




	public void setRank(int rank) {
		this.rank = rank;
	}

	public static Card[] newDeck() {
		Card[] desk=new Card[cards.length];
		System.arraycopy(cards, 0, desk, 0, cards.length);
		for(int i=cards.length-1;i>0;i--) {
			int index=rand.nextInt(i+1);
			Card temp=desk[i];
			desk[i]=desk[index];
			desk[index]=temp;
		}
		return desk;
	}
	@Override
	public String toString() {		
		return this.suit+":"+this.rank ;
	}
	
}
