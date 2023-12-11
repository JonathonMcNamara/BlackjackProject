package com.skilldistillery.blackjack.entities;

public class Player {
	
	protected Hand hand;
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	
	public void addCard(Card card){
		hand.addCard(card);
	}
	
	public String getPlayerHand() {
		return hand.toString();
	}
	
	public String getDealerHand() {
		return hand.toStringDealer();
	}
	
	public void getPlayerHandValue() {
		hand.getHandValue();
	}
	
	public BlackjackHand getHand() {
		return (BlackjackHand) hand;
	}
	

}
