package procedures;

import entities.AttackBoard;
import entities.DefenseBoard;

public class Check {
	private int right=0;
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
		
		if(defenseBoard.getBoard()[intNumberX][intNumberY].getText().equals("N")) {
			this.right++;
		}
	}
	
	public void checkHit() {
		
		if(this.right>=1) {
			System.out.println("Você acertou o tiro pelo menos uma vez");
		}else {
			System.out.println("Você não acertou nenhum tiro");
		}
	}
	
	public void checkVictory(DefenseBoard defenseBoard,AttackBoard attackBoard) {
		
		int contVictory = 0;	 
		int quant=0;
		
		for(int i =0;i< 10;i++) {
				for(int j=0;j< 10;j++) {
				if(defenseBoard.getBoard()[i][j].equals("N")) {
					quant++;
				}
			}
		}
			
	
		
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(defenseBoard.getBoard()[i][j]==attackBoard.getBoard()[i][j] && defenseBoard.getBoard()[i][j].equals("N")) {
					contVictory++;
				}
			}
		}
		
		if(contVictory == quant) {
			this.victory = true;
		}
	}

}
