
public class Board extends Player{
	private String[][] defenseBoard = new String[10][10];
	private String[][] attackBoard = new String[10][10];
	
	public String[][] getDefenseBoard() {
		return defenseBoard;
	}
	public void setDefenseBoard(String defenseBoard,int i,int j) {
		this.defenseBoard[i][j]= defenseBoard;
	}
	public String[][] getAttackBoard() {
		return attackBoard;
	}
	public void setAttackBoard(String[][] attackBoard) {
		this.attackBoard = attackBoard;
	}
	
	public void createDefenseBoard() {
		for(int i=0;i<this.defenseBoard.length;i++) {
			for(int j=0;j<this.defenseBoard.length;j++) {
				this.defenseBoard[i][j]="O";	
			}
		}
	}
	
	public void createAttackBoard() {
		for(int i=0;i<this.attackBoard.length;i++) {
			for(int j=0;j<this.attackBoard.length;j++) {
				this.attackBoard[i][j]="O";
			}
		}
	}
	
	public void printDefenseBoard() {
		for(int i=0;i<this.defenseBoard.length;i++) {
			for(int j=0;j<this.defenseBoard.length;j++) {
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
				System.out.print(this.defenseBoard[i][j]);	
			}
			System.out.println();
		}
		System.out.print("  ");
		for(int i=0;i<this.defenseBoard.length;i++) {
			System.out.print(i);
		}
		System.out.println();
		
	}
	
}
