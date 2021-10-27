package Minesweeper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MinePanel extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L; // Wird von JComponent gefordert.
	private Spiel minesweeper = new Spiel();

	public MinePanel()
	{
		this.addMouseListener(this);
	}

	/**
	 * Ist für alle Zeichnungen verantwortlich
	 */
	@Override
	public void paint(Graphics gr)
	{
		super.paint(gr);
		// gr.setFont(new java.awt.Font("Ariel",0,30));
		gr.setColor(Color.BLACK);

		for (int i = 1; i < Spiel.X; i++)
		{
			gr.drawLine((getWidth() / Spiel.X) * i, 0, (getWidth() / Spiel.X) * i, getHeight());
		}

		for (int j = 1; j < Spiel.Y; j++)
		{
			gr.drawLine(0, (getHeight() / Spiel.Y) * j, getWidth(), (getHeight() / Spiel.Y) * j);
		}
		for (int k = 0; k < Anzeige.X; k++)
		{
			for (int l = 0; l < Anzeige.Y; l++)
			{
				char raute = '#';
				if (minesweeper.get(k, l) == raute)
				{
					gr.drawString(Character.toString(minesweeper.get(k, l)),
							(getWidth() / Spiel.X) * k + ((getWidth() / Spiel.X) / 3),
							(getHeight() / Spiel.Y) * l + ((getHeight() / Spiel.Y) / (1)));
				} else
				{
					gr.drawString(Character.toString(minesweeper.get(k, l)),
							(getWidth() / Spiel.X) * k + ((getWidth() / Spiel.X) / 2),
							(getHeight() / Spiel.Y) * l + ((getHeight() / Spiel.Y) / 2));
				}
			}

		}
		switch (Spiel.state)
		{
		case LOSE:
			this.setBackground(Color.RED);
			break;

		case WIN:
			this.setBackground(Color.GREEN);
			break;

		case RUNNING:
			break;
		}
	}
	
/**
 * MouseEventListener
 */
	@Override
	public void mouseClicked(MouseEvent e)
	{
		int mousePressX = e.getX();
		int mousePressY = e.getY();
		int mouseButton = e.getButton();
		System.out.println(mouseButton);
		repaint();

		int minePanelWidth = getWidth() / Anzeige.X;
		int minePanelHeight = getHeight() / Anzeige.Y;

		int minePanelClickedX = mousePressX / minePanelWidth;
		int minePanelClickedY = mousePressY / minePanelHeight;
		System.out.println("X: " + minePanelClickedX);
		System.out.println("Y: " + minePanelClickedY);

		boolean leftClick = mouseButton == 1;

		minesweeper.suche(minePanelClickedX, minePanelClickedY, leftClick);

	}

	@Override
	public void mousePressed(MouseEvent e)
	{

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}
}