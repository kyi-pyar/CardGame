package CardGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static final int[][] indexDiff= {{1,4,5}, {1,3,4,5}, {1,3,4,5}, {3,4}};
	
	public static void checkAndRemove(List<Card> list) {
		for(int cur_index=0;cur_index<list.size();cur_index++) {
			int cur_rank=list.get(cur_index).getRank();
			int [] difList=indexDiff[cur_index%4];
			for(int i=0;i<difList.length;i++) {
				int adj_index=cur_index+difList[i];
				if(adj_index<list.size() && list.get(adj_index).getRank()==cur_rank){
					list.remove(adj_index);
					list.remove(cur_index);
					checkAndRemove(list);
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		Card[] desk=Card.newDeck();
		for(Card c: desk) {
			switch (c.getSuit()) {
			case 0:System.out.println("SPADES:"+c.getRank());break;
			case 1:System.out.println("HEARTS:"+c.getRank());break;
			case 2:System.out.println("DIAMONDS:"+c.getRank());break;
			case 3:System.out.println("CLUBS:"+c.getRank());break;
			}
		}
		
		List list=new ArrayList<>();
		for(int i=0;i<desk.length;i++) {
			list.add(desk[i]);
			checkAndRemove(list);
		}
		if(list.size()==0)System.out.println("you have won!");
		else System.out.println("Remaining:"+ list.size()+" cards");
		
		
		
	
		
		
	}

}
