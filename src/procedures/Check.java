package procedures;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entities.AttackBoard;
import entities.DefenseBoard;
import entities.Player;
import entities.Ship;

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
				if(attackBoard.getGridButton()[i][j].getText()=="X"&& defenseBoard.getGridButton()[i][j].getText().equals("N")) {
					contVictory++;
				}
			}
		}
		
		if(contVictory == quant) {
			p.setVictory(true);
		}
		
	}
	
	public void checkRight(DefenseBoard defenseBoard,Player p,int numberX,int numberY,AttackBoard attackBoard) {
		if(defenseBoard.getGridButton()[numberX][numberY].getText().equals("N")) {
			p.setRight(p.getRight()+1);
			attackBoard.getGridButton()[numberX][numberY].setBackground(new Color(0,255,0));
		}else {
			attackBoard.getGridButton()[numberX][numberY].setBackground(new Color(255,0,0));
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
	
	public boolean checkDefenseBoard(Ship ship,DefenseBoard defenseBoard,JButton orientationButton,int numberX,int numberY) {
		boolean response = true;
		if(orientationButton.getText()=="↑") {
			if(ship.getSelectedShip()=="Ship1") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"){
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship2") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-1][numberY].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship3") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-1][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-2][numberY].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship4") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-1][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-2][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-3][numberY].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="PortaAvioes") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-1][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-2][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX-2][numberY-1].getText()=="N"||defenseBoard.getGridButton()[numberX-2][numberY+1].getText()=="N") {
					response = false;
				}
			}
		}else if(orientationButton.getText()=="→") {
			if(ship.getSelectedShip()=="Ship1") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"){
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship2") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY+1].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship3") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY+1].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY+2].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship4") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY+1].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY+2].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY+3].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="PortaAvioes") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY+1].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY+2].getText()=="N"||defenseBoard.getGridButton()[numberX-1][numberY+2].getText()=="N"||defenseBoard.getGridButton()[numberX+1][numberY+2].getText()=="N") {
					response = false;
				}
			}
		}else if(orientationButton.getText()=="↓") {
			if(ship.getSelectedShip()=="Ship1") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"){
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship2") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+1][numberY].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship3") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+1][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+2][numberY].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship4") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+1][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+2][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+3][numberY].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="PortaAvioes") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+1][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+2][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX+2][numberY-1].getText()=="N"||defenseBoard.getGridButton()[numberX+2][numberY+1].getText()=="N") {
					response = false;
				}
			}
		}else if(orientationButton.getText()=="←") {
			if(ship.getSelectedShip()=="Ship1") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"){
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship2") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY-1].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship3") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY-1].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY-2].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="Ship4") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY-1].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY-2].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY-3].getText()=="N") {
					response = false;
				}
			}else if(ship.getSelectedShip()=="PortaAvioes") {
				if(defenseBoard.getGridButton()[numberX][numberY].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY-1].getText()=="N"||defenseBoard.getGridButton()[numberX][numberY-2].getText()=="N"||defenseBoard.getGridButton()[numberX-1][numberY-2].getText()=="N"||defenseBoard.getGridButton()[numberX+1][numberY-2].getText()=="N") {
					response = false;
				}
			}
		}
			return response;
			
	}
	
	public boolean checkAttackBoard(AttackBoard attackBoard,int numberX,int numberY) {
		boolean response=true;
		if(attackBoard.getGridButton()[numberX][numberY].getText()=="X"){
			response = false;
		}
		return response;
	}

}
