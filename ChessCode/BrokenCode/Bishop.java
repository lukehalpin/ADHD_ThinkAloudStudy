/**
 * 
 * @author Joe Finney, Luke Halpin
 */

public class Bishop extends ChessPiece {
	public Bishop(ChessSquare s) {
		super("pieces/Bishop.jpg", s);
	}

	public boolean canMoveTo(ChessSquare s) {
		if (Math.abs(square.xLocation - s.xLocation) == Math.abs(square.yLocation - s.yLocation))
			return true;

		return false;
	}

	public boolean collision(ChessSquare b, ChessPiece[] pieces) {
		if (diaganolCheck(b, pieces)) {
			return true;
		}
		return false;
	}
}
