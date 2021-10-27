package Minesweeper;

import javax.swing.JDialog;
import javax.swing.JTable;

public class Dialog extends JDialog
{
	private static final long serialVersionUID = 1L;

	public Dialog()
	{
		JTable table = new JTable(new TableModel());
		this.add(table);
		this.setTitle("Scoreboard");
		this.setSize(400, 200);
		this.setModal(true);
		this.setVisible(true);

		pack();
	}
}
