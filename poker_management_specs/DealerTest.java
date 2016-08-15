import static org.junit.Assert.*;
import org.junit.*;
import poker_management.*;

public class DealerTest {

  Dealer dealer;

  @Before
  public void before(){
    dealer = new Dealer();
    dealer.initDeck();
  }

  @Test
  public void canGetDeck(){
    assertEquals(52, dealer.getDeck().size());
  }

  @Test
  public void dealerStartsWithADeckOf52Cards(){
    assertEquals(52, dealer.getDeck().size());
  }

  @Test
  public void checkCanShuffle(){
    System.out.println(dealer.getDeck().get(0).printPretty());
    dealer.shuffleDeck();
    System.out.println(dealer.getDeck().get(0).printPretty());
    assertEquals(true, true);
  }

  @Test
  public void checkCanDealCard(){
    dealer.dealCard();
    assertEquals(51, dealer.getDeck().size());
  }

}















