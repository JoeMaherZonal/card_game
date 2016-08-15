package poker_management;
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

  public void dealCards(int num){
    for(Player player : this.players){
      for(int i = 0; i < num; i++){
        player.receiveCard(this.dealer.dealCard());
      }
    }
  }

  public ArrayList<Player> getPlayers(){
    return this.players;
  }

}

