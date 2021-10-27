package Minesweeper;

public class Anzeige
{
	private char[][] feld;

	// final = unveränderbare definition
	static final int X = 12;
	static final int Y = 16;
	static final char LEER = '.';
	static final char MINE = '#';
	static final char FLAGGE = 'F';
	public static Gamestate state;

	public Anzeige()
	{
		state = Gamestate.RUNNING;
		this.feld = new char[X][Y]; // 12 Spalten 16 Reihen
		for (int i = 0; i < X; i++) // Durchlauf Spalten
		{
			for (int j = 0; j < Y; j++) // Durchlauf Reihen
			{
				feld[i][j] = LEER;
			}
		}
	}

	/**
	 * Beim Aufruf zählt er die noch nicht aufgedeckten Felder
	 * 
	 * @return
	 */
	public int getHidden()
	{
		int counter = 0;
		for (int i = 0; i < X; i++)
		{
			for (int j = 0; j < Y; j++)
			{
				if (feld[i][j] == LEER)
				{
					counter++;
				}
			}
		}
		return counter;
	}

	/**
	 * Beim Aufruf zählt er die markierten Felder
	 * 
	 * @return
	 */
	public int getMarked()
	{
		int counter = 0;
		for (int i = 0; i < X; i++)
		{
			for (int j = 0; j < Y; j++)
			{
				if (feld[i][j] == FLAGGE)
				{
					counter++;
				}
			}
		}
		return counter;
	}

	/**
	 * Gibt das betroffene Feld zurück
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public char get(int x, int y)
	{
		return feld[x][y];
	}

	/**
	 * Trägt Mine ins Feld ein
	 * 
	 * @param x
	 * @param y
	 */
	public void mineGetroffen(int x, int y)
	{
		feld[x][y] = MINE;
	}

	/**
	 * Trägt Nachbarminen ein
	 * 
	 * @param x
	 * @param y
	 * @param mineNachbar
	 */
	public void nichtGetroffen(int x, int y, char mineNachbar)
	{
		feld[x][y] = mineNachbar;
	}

	/**
	 * Setzt beim rechts Klick eine Flagge
	 * 
	 * @param x
	 * @param y
	 */
	public void setFlagge(int x, int y)
	{
		feld[x][y] = FLAGGE;
	}
}