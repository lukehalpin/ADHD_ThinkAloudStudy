/**
 * 
 * @author Joe Finney, Luke Halpin
 */

public class Pawn extends ChessPiece {
	public Pawn(ChessSquare s) {
		super("pieces/Pawn.jpg", s);
	}

	public boolean canMoveTo(ChessSquare s) {
		if (square.xLocation == s.xLocation
				&& (square.yLocation == s.yLocation + 1 || (square.yLocation == 6 && s.yLocation = 4)))
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
