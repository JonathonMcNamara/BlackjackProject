package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApplication {

	public static void main(String[] args) {
		BlackjackApplication bjA = new BlackjackApplication();
		bjA.run();
	}
	
	public void run() {
		Player p = new Player();
		Dealer d = new Dealer();
	}

}
