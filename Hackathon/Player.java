import java.util.ArrayList;

public class Player {
	private String playerName;
	private int points;
	
    public Player(String playerName) {
    	this.playerName = playerName;
		this.points = 0;
	}

	public Card drawCard(ArrayList<Card> deck) {
		int index = (int)(Math.random() * deck.size());
		Card card = deck.get(index);
		deck.remove(card);
		return card;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String newName) {
		this.playerName = newName;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int newPoints) {
		this.points = newPoints;
	}
}