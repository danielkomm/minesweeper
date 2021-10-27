package Minesweeper;

public class TestHighScore
{
	public static void main(String[] args)
	{

		Highscore test = Highscore.getInstance();
		test.addScore("Daniel", 20, "20");
		for (int i = 0; i < test.scoreList.size(); i++)
		{
			System.out.println(test.scoreList.get(i).getName());
			System.out.println(test.scoreList.get(i).getSec());
		}
	}
}