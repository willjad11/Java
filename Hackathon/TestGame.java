// package com.hackathon.dekofcards;

public class TestGame {

	public static void main(String[] args) {
		Deck deck = new Deck();
		int guesses = 5;

		System.out.print("Please enter your name: ");
		String playerName = System.console().readLine();
		Player player1 = new Player(playerName);
		Player computer = new Player("Computer");
		System.out.println(playerName + " is playing against " + computer.getPlayerName());
		System.out.println("Cards in deck: " + deck.getCards().size());

		System.out.println("Type 'draw' to draw a card or 'q' to quit");
        String userInput = System.console().readLine();

		while(deck.getCards().size() > 2 && guesses >= 0) {
			if (!userInput.equals("draw") && !userInput.equals("q")) {
				System.out.println("You must enter 'draw' or 'q'.");
			}

			else if (userInput.equals("draw")) {
				Card player1Card = player1.drawCard(deck.getCards());
				Card computerCard = computer.drawCard(deck.getCards());

				System.out.println(player1.getPlayerName() + " and " + computer.getPlayerName() + " draw a card");
				System.out.print(player1.getPlayerName() + " drew: ");
				player1Card.showCard();
				System.out.print(", Rank: " + player1Card.getRank() + "\n");
				System.out.println("Cards left in deck: " + deck.getCards().size());
				System.out.println("To make a guess, type 'greater', 'lesser', or 'equal'.");

				String userGuess = System.console().readLine();

				if (!userGuess.equals("greater") && !userGuess.equals("lesser") && !userGuess.equals("equal")) {
					System.out.println("You must enter 'greater', 'lesser', or 'equal'. Drawn cards have been discarded.");
				}

				else {
					if (computerCard.getRank() < player1Card.getRank() && userGuess.equals("greater")) {
						int player1Points = player1.getPoints() + 1;
						player1.setPoints(player1Points);

						if (player1.getPoints() >= 5) {
							break;
						}

						System.out.print(computer.getPlayerName() + " drew: ");
						computerCard.showCard();
						System.out.print(", Rank: " + computerCard.getRank() + "\n");

						System.out.println(player1.getPlayerName() + " guessed correctly!");
						System.out.println(player1.getPlayerName() + " now has " + player1.getPoints() + " points!");
					}

					else if (computerCard.getRank() > player1Card.getRank() && userGuess.equals("lesser")) {
						int player1Points = player1.getPoints() + 1;
						player1.setPoints(player1Points);

						if (player1.getPoints() >= 5) {
							break;
						}

						System.out.print(computer.getPlayerName() + " drew: ");
						computerCard.showCard();
						System.out.print(", Rank: " + computerCard.getRank() + "\n");

						System.out.println(player1.getPlayerName() + " guessed correctly!");
						System.out.println(player1.getPlayerName() + " now has " + player1.getPoints() + " points!");
					}

					else if (computerCard.getRank() == player1Card.getRank() && userGuess.equals("equal")) {
						int player1Points = player1.getPoints() + 1;
						player1.setPoints(player1Points);

						if (player1.getPoints() >= 5) {
							break;
						}

						System.out.print(computer.getPlayerName() + " drew: ");
						computerCard.showCard();
						System.out.print(", Rank: " + computerCard.getRank() + "\n");

						System.out.println(player1.getPlayerName() + " guessed correctly!");
						System.out.println(player1.getPlayerName() + " now has " + player1.getPoints() + " points!");
					}

					else {
						int player1Points = player1.getPoints() - 1;
						guesses -= 1;
						if (guesses <= 0) {
							break;
						}
						if (player1Points >= 0) {
							player1.setPoints(player1Points);
						}
						else {
							player1.setPoints(0);
						}

						System.out.print(player1.getPlayerName() + " drew: ");
						player1Card.showCard();
						System.out.print(", Rank: " + player1Card.getRank() + "\n");

						System.out.print(computer.getPlayerName() + " drew: ");
						computerCard.showCard();
						System.out.print(", Rank: " + computerCard.getRank() + "\n");

						System.out.println(player1.getPlayerName() + " guessed incorrectly and lost a point.");
						System.out.println(player1.getPlayerName() + " has " + player1.getPoints() + " points and " + guesses + " wrong guesses left.");
					}
				}
			}

			else if (userInput.equals("q")) {
				break;
			}

			System.out.println("Type 'draw' to draw a card or 'q' to quit");
			userInput = System.console().readLine();
    	}

		if (guesses <= 0) {
			System.out.println("Game over!");
			System.out.println(player1.getPlayerName() + " ran out of guesses and lost.");
		}

		else if (userInput.equals("q")) {
				System.out.println("You have quit the game!");
			}

		else {
			System.out.println("Game over!");
			System.out.println(player1.getPlayerName() + " won with " + player1.getPoints() + " points!");
		}
	}
}