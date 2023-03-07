package entities;

public class Board {
	private String[][] Board = new String[10][10];
	
	public String[][] getBoard() {
		return Board;
	}
	
	public void setBoard(String Board,int i,int j) {
		this.Board[i][j]= Board;
	}
	
	public void createBoard() {
		for(int i=0;i<this.Board.length;i++) {
			for(int j=0;j<this.Board.length;j++) {
				this.Board[i][j]="O";	
			}
		}
	}
	
	public void printBoard() {
		for(int i=0;i<this.Board.length;i++) {
			for(int j=0;j<this.Board.length;j++) {
				if(j==0 ) {
					switch(i) {
						case 0:
							System.out.print("A-");
							break;
						case 1:
							System.out.print("B-");
							break;
						case 2:
							System.out.print("C-");
							break;
						case 3:
							System.out.print("D-");
							break;
						case 4:
							System.out.print("E-");
							break;
						case 5:
							System.out.print("F-");
							break;
						case 6:
							System.out.print("G-");
							break;
						case 7:
							System.out.print("H-");
							break;
						case 8:
							System.out.print("I-");
							break;
						case 9:
							System.out.print("J-");
							break;
		
					}
					
				}
				System.out.print(this.Board[i][j]);	
			}
			System.out.println();
		}
		System.out.print("  ");
		for(int i=0;i<this.Board.length;i++) {
			System.out.print(i);
		}
		System.out.println();
		
	}
	
}
