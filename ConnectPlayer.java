public abstract class ConnectPlayer
{
	protected String label;
	protected boolean won;
	
	public ConnectPlayer(String label)
	{
		this.label = label;
		won = false;
	}	
	public String getLabel()
	{
		return label;
	}
	public boolean getWon()
	{
		return won;
	}
	public void setWon()
	{
		won = true;
	}
	public abstract void whereToDrop(ConnectFourGrid2DArray board);
	
}
