package CardsGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PlayGame {
	public Cards cards;
	public List<Card> newCards;
	public List<Player> players;
	public PlayGame() {
		this.cards = new Cards();
		this.newCards = new ArrayList<Card>();
		this.players = new ArrayList<Player>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("------------创建扑克牌------------");
		PlayGame game = new PlayGame();
		System.out.println("-------------创建成功-------------");
		game.cards.printCards();
		System.out.println("-------------开始洗牌-------------");
		game.newCards = game.cards.newCards();
		game.cards.printCards(game.newCards);
		System.out.println("-------------洗牌结束-------------");
		System.out.println("-------------创建玩家-------------");
		int i = 0;
		while(i < 2){
			int id = -1;
			Player player = new Player();
			//获得玩家的id，若有重复或不为整型则一直循环
			while(true) {
				System.out.println("请输入第" + (i + 1) + "位玩家的ID:");
				try {
					Scanner sc = new Scanner(System.in);
					id = sc.nextInt();
				}catch(Exception e) {
					System.out.println("请输入整数类型的ID!");
					continue;
				}
				player.setId(id + "");
				if(game.players.contains(player)) {
					System.out.println("ID有重复，请重新输入！");
					continue;
				}
				break;
			}
			System.out.println("请输入第" + (i + 1) + "位玩家的名称:");
			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			player.setName(name);
			game.players.add(player);
			i++;
		}
		for (Player player : game.players) {
			System.out.println("------欢迎玩家：" + player.getName());
		}
		System.out.println("-------------开始发牌-------------");
		for(int j = 0;j < 4;j = j + 2) {
			int k = 0;
			for (Player player : game.players) {
				System.out.println("---玩家：" + player.getName() + "拿牌");
				Card card = game.newCards.get(k + j);
				player.cards.add(card);
				k++;
			}
		}
		System.out.println("-------------发牌结束-------------");
		System.out.println("-------------开始游戏-------------");
		//分别取到两玩家最大的牌
		Card maxCard1 = game.players.get(0).cards.get(0).compareTo(game.players.get(0).cards.get(1));
		Card maxCard2 = game.players.get(1).cards.get(0).compareTo(game.players.get(1).cards.get(1));
		System.out.println("玩家" + game.players.get(0).getName() + "最大的手牌为：" + maxCard1.getColor() + maxCard1.getCount());
		System.out.println("玩家" + game.players.get(1).getName() + "最大的手牌为：" + maxCard2.getColor() + maxCard2.getCount());
		//比较两玩家最大的手牌
		Card maxCard = maxCard1.compareTo(maxCard2);
		//判断最大的手牌属于哪个玩家
		if(maxCard.equals(maxCard1)) {
			System.out.println("★玩家：" + game.players.get(0).getName() + "获胜！");
		}else {
			System.out.println("★玩家：" + game.players.get(1).getName() + "获胜！");
		}
		System.out.println("玩家各自的手牌为：");
		System.out.print(game.players.get(0).getName());
		game.cards.printCards(game.players.get(0).cards);
		System.out.print(game.players.get(1).getName());
		game.cards.printCards(game.players.get(1).cards);
	}
}
