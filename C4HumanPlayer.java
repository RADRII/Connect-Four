import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer
{
	String name;
	static Scanner sc = new Scanner(System.in);

	public C4HumanPlayer(String label, String name)
	{
		super(label);
		this.name = name;
	}

	@Override
	public void whereToDrop(ConnectFourGrid2DArray board) 
	{
		int colPicked = -1;
		while(board.isValidColumn(colPicked) == false)
		{
			System.out.println(name + ", which column would you like to put your piece?");
			colPicked = sc.nextInt();
			colPicked--;
		}

		
		board.dropPiece(this, colPicked);
		return;

	}

}
