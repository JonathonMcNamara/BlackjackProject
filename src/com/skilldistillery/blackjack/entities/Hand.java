package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cards = new ArrayList<>();

	public Hand() {

	}
	
	public abstract int getHandValue();

	public void addCard(Card card) {
		cards.add(card);
	}
	
	public List<Card> getCards(){
		return cards;
	}

	@Override
	public String toString() {
		return "Player Hand: " + cards;
	}
	
	public String toStringDealer() {
		return " " + cards;
	}
	
}
