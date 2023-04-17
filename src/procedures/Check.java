package procedures;

import javax.swing.JOptionPane;

import entities.AttackBoard;
import entities.DefenseBoard;
import entities.Player;

public class Check {
	public void checkVictory(DefenseBoard defenseBoard,AttackBoard attackBoard,Player p) {
		int contVictory = 0;	 
		int quant=0;
		
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(defenseBoard.getGridButton()[i][j].getText().equals("N")) {
					quant++;
				}
			}
		}
			
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(defenseBoard.getGridButton()[i][j].getText().equals(attackBoard.getGridButton()[i][j].getText()) && defenseBoard.getGridButton()[i][j].getText().equals("N")) {
					contVictory++;
				}
			}
		}
		
		if(contVictory == quant) {
			p.setVictory(true);
		}
		
	}
	
	public void checkRight(DefenseBoard defenseBoard,Player p,int numberX,int numberY) {
		if(defenseBoard.getGridButton()[numberX][numberY].getText().equals("N")) {
			p.setRight(p.getRight()+1);
		}
		 
	}
	
	public void showRight(Player p) {
		if(p.getRight()>=1) {
			JOptionPane.showMessageDialog(null,"Voce acertou pelo menos 1 navio");
			p.setRight(0);
		}else {
			JOptionPane.showMessageDialog(null,"Voce nao acertou nenhum navio");
			p.setRight(0);
		}
		
	}
}
