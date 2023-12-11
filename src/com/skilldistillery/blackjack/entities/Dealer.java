package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends Player{
	
	public Hand hand;
	private Deck deck = new Deck();
	
	
	public Card dealCard() {
		return deck.dealCard();
	}
	
	

}
