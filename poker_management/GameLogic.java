package poker_management;
import java.util.*;

public class GameLogic {

  public int determinePoints(Player player){
    sortCards(player);
    Card card1 = player.getHand().get(0);
    Card card2 = player.getHand().get(1);
    Card card3 = player.getHand().get(2);
    int card1EnumIndex = card1.getValue().ordinal();
    int card2EnumIndex = card2.getValue().ordinal();
    int card3EnumIndex = card3.getValue().ordinal();

    //checking for three of a kind
    if( (card1.getValue() == card2.getValue()) && (card1.getValue() == card3.getValue()) ){
      if(card1.getValue() == ValueType.THREE){return 1;}
      if(card1.getValue() == ValueType.ACE){return 2;}
      if(card1.getValue() == ValueType.KING){return 3;}
      if(card1.getValue() == ValueType.QUEEN){return 4;}
      if(card1.getValue() == ValueType.JACK){return 5;}
      if(card1.getValue() == ValueType.TEN){return 6;}
      if(card1.getValue() == ValueType.NINE){return 7;}
      if(card1.getValue() == ValueType.EIGHT){return 8;}
      if(card1.getValue() == ValueType.SEVEN){return 9;}
      if(card1.getValue() == ValueType.SIX){return 10;}
      if(card1.getValue() == ValueType.FIVE){return 11;}
      if(card1.getValue() == ValueType.FOUR){return 12;}
      if(card1.getValue() == ValueType.TWO){return 13;}
    }

    //checking for a running flush
    if( (card3EnumIndex == (card2EnumIndex + 1) ) && (card2EnumIndex == (card1EnumIndex + 1)) ){
      int flushAddition = 12;
      if( card1.getSuit() == card2.getSuit() && card2.getSuit() == card3.getSuit() ){
        //we have a running flush
        flushAddition = 2;
      }
      if(card1.getValue() == ValueType.ACE && card2.getValue() == ValueType.TWO && card3.getValue() == ValueType.THREE)
        {return 14;}
      if(card1.getValue() == ValueType.ACE && card2.getValue() == ValueType.QUEEN && card3.getValue() == ValueType.KING)
        {return 15;}
      if(card1.getValue() == ValueType.JACK){return 16 + flushAddition;}
      if(card1.getValue() == ValueType.TEN){return 17 + flushAddition;}
      if(card1.getValue() == ValueType.NINE){return 18 + flushAddition;}
      if(card1.getValue() == ValueType.EIGHT){return 19 + flushAddition;}
      if(card1.getValue() == ValueType.SEVEN){return 20 + flushAddition;}
      if(card1.getValue() == ValueType.SIX){return 21 + flushAddition;}
      if(card1.getValue() == ValueType.FIVE){return 22 + flushAddition;}
      if(card1.getValue() == ValueType.FOUR){return 23 + flushAddition;}
      if(card1.getValue() == ValueType.THREE){return 24 + flushAddition;}
      if(card1.getValue() == ValueType.TWO){return 25 + flushAddition;}
    }

      //we have a flush
      if(card1.getValue() == ValueType.ACE && card2.getValue() == ValueType.TWO && card3.getValue() == ValueType.THREE){
         return 26 + getValueofCards(player);
      }

      //we have a pair
      if(card1.getValue() == card2.getValue() || card2.getValue() == card3.getValue() || card3.getValue == card1.getValue()){
        return 110 + getValueofCards(players)
      }

      return determineBestCard(player) + 300;
}

public int determineBestCard(Player player){
  card1Points = getValueofCard(player.getHand().get(0));
  card2Points = getValueofCard(player.getHand().get(1));
  card3Points = getValueofCard(player.getHand().get(2));
  if(card1Points > card2Points && card1Points > card3Points){
    return card1Points;
  }
  if(card2Points > card1Points && card2Points > card3Points){
    return card2Points;
  }
  if(card3Points > card2Points && card3Points > card1Points){
    return card3Points;
  }
}

public int getValueofCards(Player player){
  int total = 0;

  for(int i = 0; i < player.getHand().size(); i++){
    total = total + getValueofCard(player.getHand().get(i));
  }

  return total;
}

public int getValueofCard(Card card){
  if(card.getValue() == ValueType.ACE){return 15;}
  if(card.getValue() == ValueType.KING){return 16;}
  if(card.getValue() == ValueType.QUEEN){return 17;}
  if(card.getValue() == ValueType.JACK){return 18;}
  if(card.getValue() == ValueType.TEN){return 19;}
  if(card.getValue() == ValueType.NINE){return 20;}
  if(card.getValue() == ValueType.EIGHT){return 21;}
  if(card.getValue() == ValueType.SEVEN){return 22;}
  if(card.getValue() == ValueType.SIX){return 23;}
  if(card.getValue() == ValueType.FIVE){return 24;}
  if(card.getValue() == ValueType.FOUR){return 25;}
  if(card.getValue() == ValueType.THREE){return 26;}
  return 27;
}

public void sortCards(Player player){
  ArrayList<Card> orderedCards = new ArrayList<Card>();
  ArrayList<Card> dealtCards = player.getHand();

  for(int n = 0; n < ValueType.values().length; n++){
    for(int i = 0; i < dealtCards.size(); i++){
      if(dealtCards.get(i).getValue() == ValueType.values()[n]){
        orderedCards.add(dealtCards.get(i));
      }
    }
  }
  player.receiveOrderedHand(orderedCards);
}

}