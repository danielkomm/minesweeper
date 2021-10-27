package Minesweeper;

import javax.swing.JOptionPane;

public class Spiel extends Anzeige
{
	private Positionen MINENPOSITIONEN = new Positionen(X, Y);
	private Highscore highscore = Highscore.getInstance();

	/**
	 * Logik des Spiel Prüft die einzelnen States sowie den MouseListener
	 * 
	 * @param x
	 * @param y
	 * @param leftClick
	 */
	public void suche(int x, int y, boolean leftClick)
	{
		switch (Spiel.state)
		{
		case RUNNING:
			if (MINENPOSITIONEN.istHierMine(x, y) && leftClick)
			{
				mineGetroffen(x, y);
				state = Gamestate.LOSE;
			} else if (!MINENPOSITIONEN.istHierMine(x, y) && leftClick)
			{
				char nachbarMinen = (char) (MINENPOSITIONEN.zaehleNachbarn(x, y) + '0');
				nichtGetroffen(x, y, nachbarMinen);
				nullAutomat(x, y, MINENPOSITIONEN.zaehleNachbarn(x, y));
				if ((getMarked() + getHidden()) <= Positionen.MINEN)
				{
					gewonnen();
				}
			} else if (!leftClick)
			{
				setFlagge(x, y);
			}
			break;

		case WIN:
			System.out.println("You have won!");
			break;

		case LOSE:
			System.out.println("You have lost!");
			break;
		}
	}

	// Funktion die nur beim Sieg aufgerufen wird, den State auf WIN setzt und die
	// Funktion getPlayerName aufruft.
	private void gewonnen()
	{
		state = Gamestate.WIN;
		String name = getPlayerName();
		highscore.addScore(name, MineTimer.getGameSec(), null);
		new Dialog();
	}

	// Funktion die beim Sieg den Spielernamen abfragt.
	private String getPlayerName()
	{
		String playerName = JOptionPane.showInputDialog(null, "Enter your player name.");
		if (playerName != null)
		{
			if (playerName != null)
			{

			}
		}
		return playerName;

	}

	// Generiert 0 wenn keine Mine in der Nähe ist
	private void nullAutomat(int x, int y, int nachbarMinen)
	{
		if (nachbarMinen == 0)
		{

			int minX = 0;
			int minY = 0;
			int maxX = 0;
			int maxY = 0;

			if (x == 0)
			{// schützt vor "out of bounds"
				minX++;
			} else if (x == X - 1)
			{
				maxX--;
			}

			if (y == 0)
			{
				minY++;
			} else if (y == Y - 1)
			{
				maxY--;
			}

			for (int i = x - 1 + minX; i < x + 2 + maxX; i++)
			{ // deckt nachbarn auf.
				for (int m = y - 1 + minY; m < y + 2 + maxY; m++)
				{

					if (i != x || m != y)
					{
						// erhält Anzahl der Nachbarminen als Typ char
						char nextNachbarMinen = (char) (MINENPOSITIONEN.zaehleNachbarn(i, m) + '0');
						nichtGetroffen(i, m, nextNachbarMinen);

					}
				}
			}
		}
	}
}
