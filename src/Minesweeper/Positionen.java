package Minesweeper;

import java.util.Random;

public class Positionen
{
	static final int MINEN = 24;
	private Mine[] arrayMinen;

	public Mine get(int index)
	{
		return arrayMinen[index];
	}

	public Positionen(int x, int y)
	{
		Random generator = new Random();
		this.arrayMinen = new Mine[MINEN];
		for (int i = 0; i < MINEN; i++)
		{
			int xKord = generator.nextInt(x);
			int yKord = generator.nextInt(y);

			Mine neueMine = new Mine(xKord, yKord);

			boolean uniq = true;

			for (int j = 0; j < i; j++)
			{
				if (arrayMinen[j].istAnPosition(neueMine))
				{
					uniq = false;
					i--;
				}
			}

			if (uniq)
			{
				arrayMinen[i] = neueMine;
			}

		}
	}

	/**
	 * Überprüft ob sich an Position eine Mine befindet
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean istHierMine(int x, int y)
	{
		boolean besetzt = false;

		for (int i = 0; i < arrayMinen.length; i++)
		{
			besetzt = arrayMinen[i].getX() == x && arrayMinen[i].getY() == y;
			if (besetzt)
			{
				return besetzt;
			}
		}
		return besetzt;
	}

	/**
	 * Zählt die Nachbarn
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int zaehleNachbarn(int x, int y)
	{
		int zaehler = 0;

		for (int i = x - 1; i < x + 2; i++)
		{
			for (int m = y - 1; m < y + 2; m++)
			{
				if (istHierMine(i, m))
				{
					zaehler++;
				}
			}
		}
		return zaehler;

	}
}
