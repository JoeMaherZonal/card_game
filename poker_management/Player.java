package poker_management;
import java.util.*;

public class Player {

  private String name;
  private ArrayList<Card> hand;
  private int chips;
  private int points;

  public Player(String name){

    this.name = name;
    this.hand = new ArrayList<Card>();
    this.chips = 0;
    this.points = 0;

  }

  public String getName(){
    return this.name;
  }

  public ArrayList<Card> getHand(){
    return this.hand;
  }

  public void receiveCard(Card card){
    this.hand.add(card);
  }

  public void receiveOrderedHand(ArrayList<Card> orderedCards){
    this.hand = orderedCards;
  }

}





















