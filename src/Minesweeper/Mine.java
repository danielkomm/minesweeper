package Minesweeper;

public class Mine
{
	private int x, y;

	public Mine(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	/**
	 * Prüft ob sich an dieser Position schon eine Mine befindet
	 * 
	 * @param mineZumVergleich
	 * @return
	 */
	public boolean istAnPosition(Mine mineZumVergleich)
	{
		if (this.getX() == mineZumVergleich.getX() && this.getY() == mineZumVergleich.getY())
		{
			return true;
		} else
		{
			return false;
		}
	}

}
