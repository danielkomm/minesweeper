package Minesweeper;

public class Test
{

	public static void main(String[] args)
	{
		Positionen test = new Positionen(Anzeige.X, Anzeige.Y);

		for (int i = 0; i < Positionen.MINEN; i++)
		{
			System.out.println(test.get(i).getX() + " - " + test.get(i).getY());
		}

	}

}
