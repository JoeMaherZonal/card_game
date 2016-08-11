package black_jack_management;
import java.util.*;

public class Dealer {

  private ArrayList<Card> deck;

  public Dealer(){
    this.deck = new ArrayList<Card>();
  }

  public ArrayList<Card> getDeck(){
    return this.deck;
  }

  public void initDeck(){

    for(int i = 0; i < SuitType.values().length; i++){

      for(int n = 0; n < ValueType.values().length; n++){

        Card card = new Card(SuitType.values()[i], ValueType.values()[n]);
        this.deck.add(card);

      }
    }
  }

  public void shuffleDeck(){
    long seed = System.nanoTime();
    Collections.shuffle(this.deck, new Random(seed));
  }

  public Card dealCard(){
    this.shuffleDeck();
    Card card = this.deck.get(0);
    this.deck.remove(0);
    return card;
  }

}







