package poker_management;

public class Card {

  private SuitType suit;
  private ValueType value;

  public Card(SuitType suit, ValueType value){
    this.suit = suit;
    this.value = value;
  }

  public SuitType getSuit(){
    return this.suit;
  }

  public ValueType getValue(){
    return this.value;
  }

  public String printPretty(){
    String prettySuit = this.prettySuit(this.suit);
    String prettyValue = this.prettyValue(this.value);
    return prettyValue + prettySuit;
  }

  public String prettySuit(SuitType suit){
    switch (suit) {
      case HEARTS:
        return "♥️";
      case DIAMONDS:
        return "♦️️";
      case CLUBS:
        return "♣️";
      case SPADES:
        return "♠️";
      }
      return null;
  }

  public String prettyValue(ValueType value){
    switch (value) {
      case ACE:
        return "A";
      case TWO:
        return "2";
      case THREE:
        return "3";
      case FOUR:
        return "4";
      case FIVE:
        return "5";
      case SIX:
        return "6";
      case SEVEN:
        return "7";
      case EIGHT:
        return "8";
      case NINE:
        return "9";
      case TEN:
        return "10";
      case JACK:
        return "J";
      case QUEEN:
        return "Q";
      case KING:
        return "K";
      }
    return null;
  }

}