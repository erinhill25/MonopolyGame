import java.util.*;

public class Board {

	private static final int SIZE = 40;
	
	private List<Square> squares = new ArrayList<Square>(SIZE);
	
	public Board() {
		buildSquares();
		linkSquares();
	}
	
	public Square getSquare(Square start, int distance) {
		
		int endIndex = (start.getIndex() + distance) % SIZE;
		return (Square) squares.get(endIndex);
		
	}
	
	public Square getStartSquare() {
		return (Square) squares.get(0);
	}
	
	public void buildSquares() {
		
		for(int i=1;i<=SIZE;i++) {
			build(i);
		}
		
	}
	
	public void build(int i) {
		
		Square s = new Square("Square " + i, i-1);
		squares.add(s);
		
	}
	
	public void linkSquares() {
		for(int i=0;i<SIZE-1; i++) {
			
			link(i);
		}
		Square first = (Square) squares.get(0);
		Square last = (Square) squares.get(SIZE-1);
		last.setNextSquare(first);
	}
	
	public void link(int i) {
		
		Square current = (Square) squares.get(i);
		Square next = (Square) squares.get(i+1);
		current.setNextSquare(next);
	}
	
}
