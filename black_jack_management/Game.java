package black_jack_management;
import java.util.*;

public class Game {

  private ArrayList<Player> players;
  private Dealer dealer;

  public Game(){
    this.players = new ArrayList<Player>();
    this.dealer = new Dealer();
    this.dealer.initDeck();
  }

  public void addPlayer(String name){
    Player player = new Player(name);
    this.players.add(player);
  }

}

