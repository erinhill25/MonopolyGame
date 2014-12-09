import java.util.*;

public class MonopolyGame extends Observable {
	
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
		
		this.setChanged();
		this.notifyObservers(new ObservableArgument("saveGame", true));
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	private void playRound() {
		
		for(Iterator<Player> iter = players.iterator(); iter.hasNext();) {
			
			Player player = (Player) iter.next();
			GameMove move = player.takeTurn();
			
			this.setChanged();
			this.notifyObservers(new ObservableArgument("update", move));
		}
		
	}
	
	public void loadGame() {
	    
	    this.setChanged();
        this.notifyObservers(new ObservableArgument("loadGame", true));
	}
	
	public static void main(String[] args) {
		MonopolyGame g = new MonopolyGame();
		
		GameObserver observer = new GameObserver();
		g.addObserver(observer);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Start a new game or load? N = new game, L = load");
		String s = in.nextLine();
		if(s.equals("n")) {
		    
		    g.playGame();
		
		} else {
		    
		    g.loadGame(); 
		    
		}
		
		in.close();
	}

}
