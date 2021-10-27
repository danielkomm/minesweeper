package Minesweeper;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MineFrame extends JFrame
{
	public static final int WINDOW_HEIGHT = 640;
	public static final int WINDOW_WIDTH = 480;

	private static final long serialVersionUID = 1L; // Wird von JComponent gefordert.

	public MineFrame()
	{
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, new MinePanel());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JButton restart = new JButton("Neues Spiel");
		MineTimer gameTimer = new MineTimer();
		gameTimer.startTimer();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.add(panel2);
		panel1.add(gameTimer);
		panel2.setLayout(new GridLayout());
		panel2.add(restart);
		restart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				gameTimer.stopTimer();
				gameTimer.resetTimer();
				dispose();
				new MineFrame();
			}
		});

		this.add(BorderLayout.SOUTH, panel1);
		this.add(new MinePanel());
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setVisible(true);
		this.setTitle("Minesweeper by Daniel K.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args)
	{
		new MineFrame();
	}
}
