package Minesweeper;

import java.util.ArrayList;
import java.util.ListIterator;

public class Highscore extends ArrayList<Score>
{
	private static final long serialVersionUID = 1L;

	private Highscore(String playerName, int seconds)
	{

	}

	ArrayList<Score> scoreList = new ArrayList<>();
	static private Highscore instance = null;

	static public Highscore getInstance()
	{
		if (instance == null)
		{
			instance = new Highscore(null, 0);
		}
		return instance;
	}

	/**
	 * Funktion um Namen und Sekunden in die ArrayList hinzuzufügen.
	 * 
	 * @param playerName
	 * @param seconds
	 */
	public void addScore(String playerName, int seconds, String timer)
	{
		boolean scoreSet = false;

		for (ListIterator<Score> li = this.listIterator(0); li.hasNext();)
		{
			if (seconds <= li.next().getSec())
			{
				this.add(li.nextIndex(), new Score(playerName, timer, seconds));
				scoreSet = true;
			}
		}
		if (!scoreSet)
		{
			this.add(new Score(playerName, timer, seconds));
		}
		
	}
}
