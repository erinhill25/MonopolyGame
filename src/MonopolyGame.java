import java.util.*;

public class MonopolyGame {
	
	private static final int ROUNDS_TOTAL = 20;
	private static final int PLAYERS_TOTAL = 2;
	private List<Player> players = new ArrayList<Player>(PLAYERS_TOTAL);
	
	private Board board = new Board();
	private Die[] dice = { new Die(), new Die() };
	
	public MonopolyGame() {
		Player p;
		p = new Player("Horse", dice, board);
		players.add(p);
		p = new Player("Car", dice, board);
		players.add(p);
	}
	
	public void playGame() {
		for(int i=0; i< ROUNDS_TOTAL; i++) {
			playRound();
		}
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	private void playRound() {
		
		for(Iterator<Player> iter = players.iterator(); iter.hasNext();) {
			
			Player player = (Player) iter.next();
			player.takeTurn();
		}
		
	}
	
	public static void main(String[] args) {
		MonopolyGame g = new MonopolyGame();
		g.playGame();
	}

}
