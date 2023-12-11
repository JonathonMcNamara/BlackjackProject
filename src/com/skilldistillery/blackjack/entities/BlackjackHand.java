package com.skilldistillery.blackjack.entities;

import java.lang.*;

public class BlackjackHand extends Hand{

	public BlackjackHand() {

	}
	
	public int getHandValue() {
		int handValue = 0;
		for(Card card: cards) {
			handValue = handValue + card.getValue();
		}
		return handValue;
	}
	
	public boolean isBlackJack() {
		return getHandValue() == 21;
	}
//	
	public boolean isBust() {
		return getHandValue() > 21;
	}
	
	
	
}			
	

