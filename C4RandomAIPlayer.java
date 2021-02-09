import java.util.Random;
public class C4RandomAIPlayer extends ConnectPlayer
{
	static Random  rand = new Random ( );  
	
	public C4RandomAIPlayer(String label)
	{
		super(label);
	}

	@Override
	public void whereToDrop(ConnectFourGrid2DArray board) 
	{
		int column = -1;
		
		while(board.isValidColumn(column) == false)
		{
			column = rand.nextInt(board.getColLength());
		}
		
		System.out.println("The computer placed its chip into column " + column);
		
		board.dropPiece(this, column);
		return;
	}

}
