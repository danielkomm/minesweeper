
package Minesweeper;

public class Score
{
	private String name;
	private String sec;
	private int timer;

	public Score(String playerName, String seconds, int timerInSec)
	{
		this.name = playerName;
		this.sec = seconds;
		this.timer = timerInSec;
	}

	public int getTime()
	{
		return timer;
	}

	public String getName()
	{
		return name;
	}

	public String getSecInString()
	{
		return sec;
	}

	public int getSec()
	{
		return timer;
	}
}
