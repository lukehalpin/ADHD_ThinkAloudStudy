
/**
 * 
 * @author Joe Finney, Luke Halpin
 */

import javax.swing.*;
import java.awt.*;

public class ChessSquare extends JButton {
	public int xLocation;
	public int yLocation;

	public ChessSquare(int x, int y, String Filename) {
		super(new ImageIcon(Filename));

		xLocation = x;
		yLocation = y;
	}
}
