package Minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MineTimer extends JLabel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	Timer gameTimer = new Timer(1000, this);
	static private MineTimer instance = null;
	private static int gameSec = 0;

	static public MineTimer getInstance()
	{
		if (instance == null)
		{
			instance = new MineTimer();
		}
		return instance;
	}

	/**
	 * Logik des Timer sowie Abbruchbedingungen bei den einzelnen States
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (Spiel.state)
		{
		case RUNNING:
			setGameSec(getGameSec() + 1);
			String gameSecToString = "" + getGameSec();
			super.setText(gameSecToString);
			break;

		case LOSE:
			stopTimer();
			break;

		case WIN:
			startTimer();
			break;
		}
	}

	/**
	 * Startet den Timer
	 */
	public void startTimer()
	{
		gameTimer.start();
	}

	/**
	 * Stoppt den Timer
	 */
	public void stopTimer()
	{
		gameTimer.stop();
	}
	
	public void resetTimer()
	{
		gameSec = 0;
	}

	public static int getGameSec()
	{
		return gameSec;
	}

	public static void setGameSec(int gameSec)
	{
		MineTimer.gameSec = gameSec;
	}
}