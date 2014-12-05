
public class Player {

	private String name;
	private Piece piece;
	private Board board;
	private Die[] dice;
	
	public Player(String name, Die[] dice, Board board) {
		this.name = name;
		this.dice = dice;
		this.board = board;
		piece = new Piece(board.getStartSquare());
	}
	
	public GameMove takeTurn() {
		
		int rollTotal = 0;
		for(int i=0;i<dice.length;i++) {
			dice[i].roll();
			rollTotal += dice[i].getFaceValue();
		}
		Square oldLoc = piece.getLocation();
		Square newLoc = board.getSquare(piece.getLocation(), rollTotal);
		piece.setLocation(newLoc);
		
		return new GameMove(name, rollTotal, oldLoc.getIndex(), newLoc.getIndex());
		
	}
	
	public Square getLocation() {
		return piece.getLocation();
	}
	
	public String getName() {
		return name;
	}
	
}
