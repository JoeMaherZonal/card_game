import static org.junit.Assert.*;
import org.junit.*;
import poker_management.*;

public class GameTest {

  Game game;
  GameLogic gameLogic;
  Player player;

  @Before
  public void before(){
    game = new Game();
    gameLogic = new GameLogic();
    player = new Player("Joe");
  }

  @Test
  public void canAddPlayer(){
    game.addPlayer("player1");
    game.addPlayer("player2");
    assertEquals(2, game.getPlayers().size());
  }

  @Test
  public void canDealCardsToPlayers(){
    game.addPlayer("player1");
    game.dealCards(3);
    Player player1 = game.getPlayers().get(0);
    assertEquals(3, player1.getHand().size());
  }

  @Test
  public void canOrderCards(){
    // System.out.println(SuitType.valueOf("CLUBS").ordinal());
    Card card1 = new Card(SuitType.HEARTS, ValueType.TWO);
    Card card2 = new Card(SuitType.HEARTS, ValueType.THREE);
    Card card3 = new Card(SuitType.HEARTS, ValueType.FOUR);
    player.receiveCard(card3);
    player.receiveCard(card2);
    player.receiveCard(card1);
    assertEquals(ValueType.FOUR, player.getHand().get(0).getValue());
    gameLogic.sortCards(player);
    assertEquals(ValueType.TWO, player.getHand().get(0).getValue());
    assertEquals(ValueType.THREE, player.getHand().get(1).getValue());
    assertEquals(ValueType.FOUR, player.getHand().get(2).getValue());
  }

  @Test
  public void canReturnPointsofThreeOfAKindwithTwos(){
    Card card1 = new Card(SuitType.HEARTS, ValueType.TWO);
    Card card2 = new Card(SuitType.CLUBS, ValueType.TWO);
    Card card3 = new Card(SuitType.SPADES, ValueType.TWO);
    player.receiveCard(card3);
    player.receiveCard(card2);
    player.receiveCard(card1);
    int points = gameLogic.determinePoints(player);
    assertEquals(13, points);
  }

  @Test
  public void canReturnPointsofThreeOfAKindwithACE(){
    Card card1 = new Card(SuitType.HEARTS, ValueType.ACE);
    Card card2 = new Card(SuitType.CLUBS, ValueType.ACE);
    Card card3 = new Card(SuitType.SPADES, ValueType.ACE);
    player.receiveCard(card3);
    player.receiveCard(card2);
    player.receiveCard(card1);
    int points = gameLogic.determinePoints(player);
    assertEquals(2, points);
  }

  @Test canReturnAPairPoints(){
    Card card1 = new Card(SuitType.HEARTS, ValueType.ACE);
    Card card2 = new Card(SuitType.CLUBS, ValueType.ACE);
    Card card3 = new Card(SuitType.SPADES, ValueType.TWO);
    player.receiveCard(card3);
    player.receiveCard(card2);
    player.receiveCard(card1);
    int points = gameLogic.determinePoints(player);
    assertEquals(14, points);
  }

  @Test
  public void canReturnStraightFlush(){
    Card card1 = new Card(SuitType.HEARTS, ValueType.ACE);
    Card card2 = new Card(SuitType.HEARTS, ValueType.TWO);
    Card card3 = new Card(SuitType.HEARTS, ValueType.THREE);
    player.receiveCard(card3);
    player.receiveCard(card1);
    player.receiveCard(card2);
    int points = gameLogic.determinePoints(player);
    assertEquals(14, points);
  }

}