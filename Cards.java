package CardsGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cards {
	public List<Card> cards;
	public Cards() {
		this.createCards();
	}
	//创建一副扑克牌
	private void createCards(){
		this.cards = new ArrayList<Card>();
		String[] colors = {"黑桃","红桃","梅花","方片"};
		String[] counts = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 13;j++) {
				Card card = new Card();
				card.setColor(colors[i]);
				card.setCount(counts[j]);
				card.setColorNum(i);
				card.setCountNum(j);
				cards.add(card);
			}
		}
	}
	//打印牌序
	public void printCards() {
		for (Card card : cards) {
			System.out.print(card.getColor() + card.getCount() + ",");
		}
	}
	public void printCards(List<Card> cards) {
		StringBuilder sb = new StringBuilder();
		sb.append("[" + cards.get(0).getColor() + cards.get(0).getCount());
		for (int i = 1;i < cards.size();i++) {
			sb.append("," + cards.get(i).getColor() + cards.get(i).getCount());
		}
		sb.append("]");
		System.out.println(sb.toString());
	}
	//洗牌
	public List<Card> newCards(){
		List<Card> newCards = new ArrayList<Card>();
		Random rand = new Random();
		for(int i = 0;i < 52;i++) {
			Card card = new Card();
			do {
				card = cards.get(rand.nextInt(52));
			}while(newCards.contains(card));
			newCards.add(card);
		}
		return newCards;
	}
}
