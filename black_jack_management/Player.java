package black_jack_management;
import java.util.*;

public class Player {

  private String name;
  private ArrayList<Card> hand;

  public Player(String name){

    this.name = name;
    this.hand = new ArrayList<Card>();

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

}





















