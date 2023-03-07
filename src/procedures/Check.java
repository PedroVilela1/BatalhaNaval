package procedures;

import entities.AttackBoard;
import entities.DefenseBoard;

public class Check {
	private int right;
	private boolean victory = false;
	
	
	public void setRight(int right) {
		this.right = right;
	}
	
	public boolean getVictory() {
		return victory;
	}

	public void checkRight(DefenseBoard defenseBoard, String numberX, String numberY) {
		int intNumberX = Integer.parseInt(numberX);
		int intNumberY = Integer.parseInt(numberY);
		
		if(defenseBoard.getBoard()[intNumberX][intNumberY].equals("N")) {
			this.right++;
		}
		
	}
	
	public void checkHit() {
		if(this.right>0) {
			System.out.println("Você acertou o tiro pelo menos uma vez");
		}
	}
	public void checkVictory(DefenseBoard defenseBoard,AttackBoard attackBoard) {
		
		int contVictory = 0;
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
					if(defenseBoard.getBoard()[i][j]==attackBoard.getBoard()[i][j]) {
						contVictory++;
					}
			}
		}
		if(contVictory == 100) {
			System.out.println("VOCE GANHOU A PARTIDA");
		}
		
		
		
	}

	

	
}
