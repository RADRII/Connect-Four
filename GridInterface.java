public interface GridInterface 
{
	public void emptyGrid();
	public String toString();
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4(int rowPlaced, int colPlaced, String whoPlaced);
	public boolean isGridFull();   
}
