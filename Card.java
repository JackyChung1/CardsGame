package CardsGame;

public class Card {
	private String color;
	private String count;
	private int colorNum;
	private int countNum;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public int getColorNum() {
		return colorNum;
	}
	public void setColorNum(int colorNum) {
		this.colorNum = colorNum;
	}
	public int getCountNum() {
		return countNum;
	}
	public void setCountNum(int countNum) {
		this.countNum = countNum;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Card))
			return false;
		Card other = (Card) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		return true;
	}
	
	public Card compareTo(Card c) {
		if(this.getCountNum() == c.getCountNum()){
			return this.getColorNum() > c.getColorNum() ? c : this;
		}
		return this.getCountNum() > c.getCountNum() ? this : c;
	}
}
