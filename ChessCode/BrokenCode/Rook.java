/**
 * 
 * @author Joe Finney, Luke Halpin
 */

public class Rook extends ChessPiece {
	public Rook(ChessSquare s) {
		super("pieces/Rook.jpg", s);
	}

	public boolean canMoveTo(ChessSquare s) {
		if (square.xLocation == s.xLocation || square.yLocation == s.yLocation)
			return true;

		return false;
	}

	public boolean collision(ChessSquare b, ChessPiece[] pieces) {
		if (nonDiaganolCheck(b, pieces)) {
			return true;
		}
		return false;
	}
}
