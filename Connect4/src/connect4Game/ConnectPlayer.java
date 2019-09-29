package connect4Game;

import java.util.Random;

public abstract class ConnectPlayer {
	static final int NUMBER_OF_COLUMNS = 7;
	
	ConnectPlayer(){
		
	}
	int chooseColumn() {
		Random generator = new Random();
		return generator.nextInt(NUMBER_OF_COLUMNS);
	}
	public abstract boolean isHuman();
}
