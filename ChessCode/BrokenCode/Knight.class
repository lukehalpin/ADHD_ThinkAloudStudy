/**
 * 
 * @author Joe Finney, Luke Halpin
 */

public class Knight extends ChessPiece {
	public Knight(ChessSquare s) {
		super("pieces/Knight.jpg", s);
	}

	public boolean canMoveTo(ChessSquare s) {
		if ((Math.abs(square.xLocation - s.xLocation) == 2) && (Math.abs(square.yLocation - s.yLocation) == 1) ||
				(Math.abs(square.xLocation - s.xLocation) == 1) && (Math.abs(square.yLocation - s.yLocation) == 2))

			return true;

		return false;
	}

	public boolean collision(ChessSquare b, ChessPiece[] pieces) {
		for (ChessPiece chessPiece : pieces) {
			if (chessPiece.square.xLocation == b.xLocation && chessPiece.square.yLocation == b.yLocation) {
				return true;
			}
		}
		return false;
	}
}
