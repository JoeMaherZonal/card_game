import static org.junit.Assert.*;
import org.junit.*;
import black_jack_management.*;

public class PlayerTest {

  Player player;
  Dealer dealer;

  @Before
  public void before(){
    player = new Player("Megan");
    dealer = new Dealer();
    dealer.initDeck();
  }

  @Test
  public void canGetName(){
    assertEquals("Megan", player.getName());
  }

  @Test
  public void canGetHand(){
    player.receiveCard(dealer.dealCard());
    assertEquals(1, player.getHand().size());
  }

}