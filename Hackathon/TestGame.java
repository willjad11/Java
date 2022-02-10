// package com.hackathon.dekofcards;

public class TestGame {

	public static void main(String[] args) {
		Deck deck = new Deck();

		System.out.print("Please enter your name: ");
		String playerName = System.console().readLine();
		Player player1 = new Player(playerName);
		Player computer = new Player("Computer");
		System.out.println(playerName + " is playing against " + computer.getPlayerName());
		System.out.println("Cards in deck: " + deck.getCards().size());

		System.out.println("Type 'draw' to draw a card or 'q' to quit");
        String userInput = System.console().readLine();

		while(deck.getCards().size() >= 2) {
			if (userInput.equals("draw")) {
				System.out.print(player1.getPlayerName() + " draws: ");
				Card player1Card = player1.drawCard(deck.getCards());
				player1Card.showCard();
				System.out.print("Rank: " + player1Card.getRank() + "\n");

				System.out.print(computer.getPlayerName() + " draws: ");
				Card computerCard = computer.drawCard(deck.getCards());
				computerCard.showCard();
				System.out.print("Rank: " + computerCard.getRank() + "\n");

				System.out.println("Cards left in deck: " + deck.getCards().size());

				if (computerCard.getRank() < player1Card.getRank()) {
					int player1Points = player1.getPoints() + 1;
					player1.setPoints(player1Points);
					System.out.println(player1.getPlayerName() + " wins!");
					System.out.println(player1.getPlayerName() + " now has " + player1.getPoints() + " points!");
				}
				else if (computerCard.getRank() > player1Card.getRank()) {
					int computerPoints = computer.getPoints() + 1;
					computer.setPoints(computerPoints);
					System.out.println(computer.getPlayerName() + " wins!");
					System.out.println(computer.getPlayerName() + " now has " + computer.getPoints() + " points!");
				}
				else if (computerCard.getRank() == player1Card.getRank()) {
					int computerPoints = computer.getPoints() - 1;
					computer.setPoints(computerPoints);
					int player1Points = player1.getPoints() - 1;
					player1.setPoints(player1Points);
					System.out.println("It's a tie, you both lose a point");
					System.out.println(player1.getPlayerName() + " now has " + player1.getPoints() + " points.");
					System.out.println(computer.getPlayerName() + " now has " + computer.getPoints() + " points.");
				}
			}
			else if (userInput.equals("q")) {
				break;
			}
		if (deck.getCards().size() == 0) {
			break;
		}
        System.out.println("Type 'draw' to draw a card or 'q' to quit");
        userInput = System.console().readLine();
    	}
		System.out.println("Game over!");
		if (computer.getPoints() > player1.getPoints()) {
			System.out.println(computer.getPlayerName() + " won with " + computer.getPoints() + " points!");
			System.out.println(player1.getPlayerName() + " lost with " + player1.getPoints() + " points!");
		}
		else {
			System.out.println(player1.getPlayerName() + " won with " + player1.getPoints() + " points!");
			System.out.println(computer.getPlayerName() + " lost with " + computer.getPoints() + " points!");
		}
	}
}