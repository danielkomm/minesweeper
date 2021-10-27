package Minesweeper;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;
	Highscore highscore;

	public TableModel()
	{
		highscore = Highscore.getInstance();
	}

	@Override
	public int getRowCount()
	{
		if (highscore.size() < 2)
		{
			return highscore.size();
		}
		return 2;
	}

	@Override
	public int getColumnCount()
	{
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		Score scoreRank = highscore.get(rowIndex);

		String playerName = scoreRank.getName();
		String playerTime = "" + scoreRank.getSec() + " Sekunden";
		String value = null;

		if (columnIndex == 0)
		{
			value = playerName;
		} else if (columnIndex == 1)
		{
			value = playerTime;
		}
		return value;
	}
}
