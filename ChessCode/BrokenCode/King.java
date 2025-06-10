/**
 * 
 * @author Joe Finney, Luke Halpin
 */

public class King extends ChessPiece {
	public King(ChessSquare s) {
		super("pieces/King.jpg", s);
	}

	public boolean canMoveTo(ChessSquare s) {
		if ((Math.abs(square.xLocation - s.xLocation) == 1) ||
				(Math.abs(square.yLocation - s.yLocation) == 1))
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
