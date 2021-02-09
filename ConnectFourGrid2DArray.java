public class ConnectFourGrid2DArray implements GridInterface
{
	public String[][] board;

	public ConnectFourGrid2DArray()
	{
		String temp[][] ={
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"}};
		board = temp;
	}

	public void emptyGrid()
	{
		String temp[][] ={
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"},
				{"-","-","-","-","-","-","-"}};
		board = temp;
	}
	public boolean isValidColumn(int column) 
	{
		if(column > 6 || column < 0)
			return false;
		if(isColumnFull(column) == true)
			return false;
		return true;
	}
	public boolean isColumnFull(int column) 
	{
		if(board[0][column] != "-")
			return true;
		return false;
	}
	public void dropPiece(ConnectPlayer player, int column)
	{
		boolean dropped = false;
		int row = board.length - 1;

		while(dropped == false)
		{
			if(board[row][column] == "-")
			{
				board[row][column] = player.getLabel();
				dropped = true;
			}
			else
				row--;
		}

		boolean didThatPieceWin = didLastPieceConnect4(row,column,player.getLabel());
		if(didThatPieceWin == true)
			player.setWon();

		return;
	}
	public String toString()
	{
		String toReturn = "";
		toReturn += "     (1)   (2)   (3)   (4)   (5)   (6)   (7)\n";
		for (int row=0; row<board.length; row++)
		{
			toReturn+="(" + (row+1) + ")";
			for (int col =0; col<board[0].length; col++)
			{

				toReturn += " | " + board[row][col]+" |";
			}
			toReturn += "\n";

		}
		return toReturn;
	}

	@Override
	public boolean didLastPieceConnect4(int rowPlaced, int colPlaced, String whoPlaced)
	{
		//Check if it won vertically (col wise)
		int inARow = 0;
		for(int row = 0; row < board.length; row++)
		{
			if(board[row][colPlaced] == whoPlaced)
				inARow++;
			else
				inARow = 0;

			if(inARow >= 4)
				return true;
		}

		//Check if it won horizontally (row wise)

		inARow = 0;
		for(int col = 0; col < board[0].length; col++)
		{
			if(board[rowPlaced][col] == whoPlaced)
				inARow++;
			else
				inARow = 0;

			if(inARow >= 4)
				return true;
		}

		//check Diagnols

		Boolean diagnolWin = checkDiagnols( rowPlaced,  colPlaced, whoPlaced);
		if(diagnolWin == true)
			return true;

		return false;

	}
	public boolean checkDiagnols(int rowPlaced, int colPlaced, String whoPlaced)
	{

		int saveRow = rowPlaced;
		int saveCol = colPlaced; 

		//CHECK TOP LEFT TO BOTTOM RIGHT
		while(rowPlaced > 0 && colPlaced > 0)
		{
			rowPlaced --;
			colPlaced --;
		}

		int inARow = 0;
		while(rowPlaced < board.length && colPlaced < board[0].length)
		{
			if(board[rowPlaced][colPlaced] == whoPlaced)
				inARow++;
			else
				inARow = 0;

			if(inARow >= 4)
				return true;

			rowPlaced++;
			colPlaced++;
		}

		//CHECK BOTTOM LEFT TO TOP RIGHT
		while(saveCol > 0 && saveRow < board.length-1)
		{
			saveRow++;
			saveCol--;

		}

		inARow = 0;
		while(saveRow > -1 && saveCol < board[0].length)
		{
			if(board[saveRow][saveCol] == whoPlaced)
				inARow++;
			else
				inARow = 0;

			if(inARow >= 4)
				return true;

			saveRow--;
			saveCol++;
		}
		return false;
	}
	public boolean isGridFull() 
	{
		for(int col = 0; col < board[0].length; col++)
		{
			if(isColumnFull(col) == false)
				return false;
		}
		return true;
	}

	public int getColLength()
	{
		return board[0].length;
	}
	public int getRowLength()
	{
		return board.length;
	}
}
