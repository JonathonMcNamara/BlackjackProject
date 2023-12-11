package com.skilldistillery.blackjack.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApplication {
	Scanner sc = new Scanner(System.in);
	Player p = new Player();
	Dealer d = new Dealer();

	public static void main(String[] args) {
		BlackjackApplication bjA = new BlackjackApplication();
		bjA.run();
	}

	public void run() {
		menu();
	}

	public void menu() {
		System.out.println("Would you like to play a game of Blackjack? Enter Yes or No");
		String userChoice = sc.nextLine().toLowerCase();
		switch (userChoice) {
		case "yes":
			startGame();
			break;
		case "no":
			System.out.println("Goodbye");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Response. Yes to Play or No to quit");
			break;	
		}
	}

	private void startGame() {
		System.out.println("Shuffling and dealing cards");
		dealPlayerAndDealerCards();
		getDealerHand();
		getPlayerHand();
		if(p.getHand().isBlackJack()) {
			System.out.println("You hit Blackjack. You Win");
			System.exit(0);
		}
		nextChoice();
		whoWins();

	}

	private void dealPlayerAndDealerCards() {
		p.addCard(d.dealCard());
		d.addCard(d.dealCard());
		p.addCard(d.dealCard());
		d.addCard(d.dealCard());
	}

	private void getPlayerHand() {
		System.out.println(p.getPlayerHand() + " Value: " + p.getHand().getHandValue());
	}

	private void getDealerHand() {
		List<Card> dealerHand = d.getHand().getCards();
		System.out.println("Dealer Hand: " + dealerHand.get(1));
	}
	
	private void getDealerHandToPlay() {
		System.out.println("Dealer Hand: " + d.getDealerHand() + " Value: " + d.getHand().getHandValue());
	}

	private void nextChoice() {
		while (true) {
			System.out.println("Would you like to Hit or Stand? ");
			String userChoice = sc.nextLine().toLowerCase();
			if (userChoice.equals("hit")) {
				System.out.println("Player Hits");
				p.addCard(d.dealCard());
				this.getDealerHand();
				this.getPlayerHand();
				if (p.getHand().isBust()) {
					System.out.println("You have busted");
					System.exit(0);
				}
				else if(p.getHand().isBlackJack()){
					System.out.println("You hit 21. You Win!");
					System.exit(0);	
				}
			} else if(userChoice.equals("stand")) {
				dealerTurn();
				break;
				
			} else {
				System.out.println("Please Select Hit or Stand");
			}

		}
	}
	
	private void dealerTurn() {
		System.out.println("Dealer Hits");
		while(d.getHand().getHandValue() < 17) {
			d.addCard(d.dealCard());
			this.getDealerHandToPlay();
			if(d.getHand().isBust()) {
				System.out.println("Dealer Busts. You Win");
				System.exit(0);
			}
			else if(d.getHand().isBlackJack()) {
				System.out.println("Dealer Hits 21. You Lose");
				System.exit(0);
			}
		}
	}
	
	private void whoWins() {
		int playerValue = p.getHand().getHandValue();
		int dealerValue = d.getHand().getHandValue();
		this.getDealerHandToPlay();
		this.getPlayerHand();
		if(playerValue > dealerValue) {
			System.out.println("Player Wins!");
		} else if(playerValue < dealerValue){
			System.out.println("Dealer Wins!");
		} else {
			System.out.println("Its a push!");
		}
	}
}
