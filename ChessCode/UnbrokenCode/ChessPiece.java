
/**
 * 
 * @author Joe Finney, Luke Halpin
 */

import javax.swing.*;

public abstract class ChessPiece {
	private ImageIcon icon; // Image of this piece
	public ChessSquare square; // The ChessSquare we're curently drawn on

	public ChessPiece(String filename, ChessSquare s) {
		icon = new ImageIcon(filename);
		square = s;

		square.setIcon(icon);
	}

	/**
	 * Determines the direction of travel of the piece
	 * 
	 * @param s The target square the piece is traveling too
	 * @return positive negative or netural for x and y axis
	 */
	private int[] travel(ChessSquare s) {
		int[] result = { 0, 0 };
		if (s.xLocation < square.xLocation) {
			result[0] = -1;
		} else if (s.xLocation > square.xLocation) {
			result[0] = 1;
		} else {
			result[0] = 0;
		}
		if (s.yLocation < square.yLocation) {
			result[1] = -1;
		} else if (s.yLocation > square.yLocation) {
			result[1] = 1;
		} else {
			result[1] = 0;
		}
		return result;
	}

	/**
	 * Checks the lateral direction on the x or y axis of travel for any collisions
	 * 
	 * @param b      the target square of travel
	 * @param pieces The other pieces on the board
	 * @return true or false if there is anything in the way or at the destination
	 *         already
	 */
	public boolean nonDiaganolCheck(ChessSquare b, ChessPiece[] pieces) {
		int[] direction = travel(b);
		int x = square.xLocation;
		int y = square.yLocation;
		while (b.xLocation != x ^ b.yLocation != y) {
			x += direction[0];
			y += direction[1];
			for (ChessPiece i : pieces) {
				if (i.square.xLocation == x && i.square.yLocation == y) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks the diagnol direction of travel on the x and y axis for any collisions
	 * 
	 * @param b      the target square of travel
	 * @param pieces The other pieces on the board
	 * @return true or false if there is anything in the way or at the destination
	 *         already
	 */
	public boolean diaganolCheck(ChessSquare b, ChessPiece[] pieces) {
		int[] direction = travel(b);
		int x = square.xLocation;
		int y = square.yLocation;
		while (b.xLocation != x && b.yLocation != y) {
			x += direction[0];
			y += direction[1];
			for (ChessPiece i : pieces) {
				if (i.square.xLocation == x && i.square.yLocation == y) {
					return true;
				}
			}
		}
		return false;
	}

	public void moveTo(ChessSquare s) {
		square.setIcon(new ImageIcon("pieces/EmptySquare.jpg"));
		s.setIcon(icon);

		square = s;
	}

	public abstract boolean canMoveTo(ChessSquare s);

	public abstract boolean collision(ChessSquare b, ChessPiece[] pieces);
}
