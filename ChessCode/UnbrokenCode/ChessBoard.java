
/**
 * 
 * @author Joe Finney, Luke Halpin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame implements ActionListener {
	private JPanel boardPanel = new JPanel();
	private ChessSquare[][] squares = new ChessSquare[8][8];
	private ChessPiece[] pieces = new ChessPiece[16];
	private ChessPiece pieceMoving = null;

	public ChessBoard() {
		// Set up window
		this.setTitle("Wizard Chess");
		this.setSize(450, 450);
		this.setContentPane(boardPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boardPanel.setLayout(new GridLayout(8, 8));

		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				squares[x][y] = new ChessSquare(x, y, "pieces/EmptySquare.jpg");
				squares[x][y].addActionListener(this);

				boardPanel.add(squares[x][y]);
			}
		}

		// Add the p(r)awns
		for (int x = 0; x < 8; x++) {
			pieces[x] = new Prawn(squares[x][6]);
		}

		// Add the Rooks
		pieces[8] = new Rook(squares[0][7]);
		pieces[9] = new Rook(squares[7][7]);

		// The Bishops...
		pieces[10] = new Bishop(squares[2][7]);
		pieces[11] = new Bishop(squares[5][7]);

		// The Knights
		pieces[12] = new Knight(squares[1][7]);
		pieces[13] = new Knight(squares[6][7]);

		// The King
		pieces[14] = new King(squares[3][7]);

		// the Queen
		pieces[15] = new Queen(squares[4][7]);

		// make our window visible
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// The button that has been pressed.
		ChessSquare b = (ChessSquare) e.getSource();

		// If we haven't clicked on a piece yet, record which piece has been clicked
		// then exit, and wait for another click
		if (pieceMoving == null) {
			for (int i = 0; i < pieces.length; i++) {
				if (pieces[i].square == b) {
					pieceMoving = pieces[i];
					pieceMoving.square.setBackground(Color.yellow);
				}
			}

			return;
		}

		// If piece is clicked again it is deselected
		if (pieceMoving.square == b) {
			pieceMoving.square.setBackground(new JButton().getBackground());
			pieceMoving = null;
			return;
		}

		// If we've already had a click on a piece, then we just need to work out where
		// to go and check the space is empty
		if (pieceMoving.canMoveTo(b)) {
			// for (ChessPiece chessPiece : pieces) {
			// if (pieceMoving != chessPiece) {
			// if (b == chessPiece.square || pieceMoving.collision(chessPiece, b, pieces)) {
			// return;
			// }
			// }
			// }
			if (pieceMoving.collision(b, pieces)) {
				return;
			}
			pieceMoving.square.setBackground(new JButton().getBackground());
			pieceMoving.moveTo(b);
			pieceMoving = null;
		}
	}
}
