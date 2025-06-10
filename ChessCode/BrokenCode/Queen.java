/**
 * 
 * @author Joe Finney, Luke Halpin
 */

public class Queen extends ChessPiece {
	public Queen(ChessSquare s) {
		super("pieces/Queen.jpg", s);
	}

	public boolean canMoveTo(ChessSquare s) {
		if (Math.abs(square.xLocation - s.xLocation) == Math.abs(square.yLocation - s.yLocation) ||
				((square.xLocation == s.xLocation) || (square.yLocation == s.yLocation)))
			return true;

		return false;
	}

	public boolean collision(ChessSquare b, ChessPiece[] pieces) {
		if (nonDiaganolCheck(b, pieces) || diaganolCheck(b, pieces)) {
			return true;
		}
		return false;
	}
}
