package com.skilldistillery.blackjack.entities;

import java.util.Objects;

import com.skilldistillery.blackjack.entities.Card;

public class Card {

	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Card(Card dealCard) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	
	  @Override
	  public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(rank);
	    builder.append(" of ");
	    builder.append(suit);
	    return builder.toString();
	  }
	
	
	

	public int getValue() {
		return rank.getValue();
	}
	
	
	
	

}
