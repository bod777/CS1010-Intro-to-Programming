package connect4Game;

public interface Connect4GridInterface{
	public void emptyGrid();
	public String toString(ConnectPlayer yellowPlayer, ConnectPlayer redPlayer);
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull();  
}
