package interfaces;

public interface BoardInterface {
	String[][] board = new String[10][10];
	
	public String[][] getBoard() ;
	
	public void setBoard(String Board,int i,int j) ;
	
	public void createBoard() ;
	
	public void printBoard();
	
}
