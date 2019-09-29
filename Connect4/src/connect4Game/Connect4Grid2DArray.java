package connect4Game;

public class Connect4Grid2DArray implements Connect4GridInterface{
	
	public static final int NUMBER_OF_ROWS = 6;
	public static final int NUMBER_OF_COLUMNS = 7;
	public ConnectPlayer[][] grid ;
	
	public Connect4Grid2DArray(){
		grid = new ConnectPlayer[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		this.emptyGrid();
	}
	public void emptyGrid() {
		for (int row = 0; (row < NUMBER_OF_ROWS); row++) {
			for (int column = 0; (column < NUMBER_OF_COLUMNS); column++) {
				grid[row][column] = null;
			}
		}
	}
	public String toString(ConnectPlayer yellowPlayer, ConnectPlayer redPlayer) {
		String gridRows="";
		for (int count = 12; (count >=0); count--)
		{
			gridRows = gridRows+"\n|";
			if (count%2==1)	{
				for (int column = 0; (column < 7); column++)
				{
					if (grid[(count-1)/2][column]==redPlayer) {
						gridRows = gridRows+" R |";
					}
					else if (grid[(count-1)/2][column]==yellowPlayer) {
						gridRows = gridRows+" Y |";
					}
					else {
						gridRows = gridRows+"   |";
					}
				}
			}
			else
			{
				gridRows = gridRows + "---|---|---|---|---|---|---|";
			}
		}
		return gridRows;
	}
	public boolean isValidColumn(int column) {
		boolean isValid=false;
		if (column < NUMBER_OF_COLUMNS && column > -1) {
			isValid = true;
		}
		return isValid;
	}
	public boolean isColumnFull(int column) {
		boolean isFull=true;
		if (this.isValidColumn(column)) {
			for (int row = 0; (row < NUMBER_OF_ROWS); row++) {
				if (grid[row][column] == null) {
					isFull=false;
				}
			}
		}
		return isFull;
	}
	public void dropPiece(ConnectPlayer player, int column) {
		if ((this.isValidColumn(column))&&(!this.isColumnFull(column))) {
			boolean finished=false;
			int row = 0;
			while(!finished) {
				if (grid[row][column] == null) {
					grid[row][column]=player;
					finished=true;
				}
				else if (row>NUMBER_OF_ROWS) {
					finished=true;
				}
				else {
					row++;
				}
			}
		}
		else {
			System.out.println("Sorry, but this move is not possible.");
		}
	}
	public boolean didLastPieceConnect4() {
		boolean victory = false;
		for (int column = 0; (column < NUMBER_OF_COLUMNS); column++)
		{
			for (int row = 0; (row < NUMBER_OF_ROWS); row++) 
			{
				if (grid[row][column]!=null) 
				{
					if (row<3) 
					{
						if ((grid[row][column]==grid[row+1][column])&&(grid[row+1][column]==
								grid[row+2][column])&&(grid[row+2][column]==grid[row+3][column]))
						{
							victory=true;
						}
					}
					if (column<4) 
					{
						if ((grid[row][column]==grid[row][column+1])&&(grid[row][column+1]
								==grid[row][column+2])&&(grid[row][column+2]==grid[row][column+3])) 
						{
							victory=true;
						}
					}
					if (row<3 && column<4) 
					{
						if ((grid[row][column]==grid[row+1][column+1])&&(grid[row+1][column+1]
							==grid[row+2][column+2])&&grid[row+2][column+2]==grid[row+3][column+3]) 
						{
							victory=true;
						}
					}
					if (row>3 && column>2) 
					{
						if ((grid[row][column]==grid[row+1][column-1])&&(grid[row+1][column-1]
							==grid[row+2][column-2])&&(grid[row+2][column-2]==grid[row+3][column-3])) 
						{
							victory = true;
						}
					}
				}
			}
		}
		return victory;
	}
	public boolean isGridFull() {
		boolean isFull=false;
		int fullColumn =0;
		for (int column = 0; (column < NUMBER_OF_COLUMNS); column++) {
			if (this.isColumnFull(column)) {
				fullColumn++;
			}
		}
		if (fullColumn == 7) {
			isFull=true;
		}
		return isFull;
	}
}
