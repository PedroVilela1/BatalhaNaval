package entities;

import interfaces.BoardInterface;

public abstract class Board implements BoardInterface{
	private String[][] board = new String[10][10];
	
	public String[][] getBoard() {
		return board;
	}
	
	public void setBoard(String Board,int i,int j) {
		this.board[i][j]= Board;
	}
	
	public void createBoard() {
		for(int i=0;i<this.board.length;i++) {
			for(int j=0;j<this.board.length;j++) {
				this.board[i][j]="O";	
			}
		}
	}
	
	public void printBoard() {
		for(int i=0;i<this.board.length;i++) {
			for(int j=0;j<this.board.length;j++) {
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
				System.out.print(this.board[i][j]);	
			}
			System.out.println();
		}
		System.out.print("  ");
		for(int i=0;i<this.board.length;i++) {
			System.out.print(i);
		}
		System.out.println();
		
	}
	
}
