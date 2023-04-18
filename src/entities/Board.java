package entities;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

import interfaces.BoardInterface;

public abstract class Board implements BoardInterface{
	private JButton [][]gridButton = new JButton[10][10];
	public Board() {
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				
				gridButton[i][j]= new JButton(" ");
				gridButton[i][j].setBackground(new Color(255,255,255));
			}
		}	
	}
	
	
	public JButton [][] getGridButton() {
		return gridButton;
	}

	public void setGridButton(JButton [][] gridButton) {
		this.gridButton = gridButton;
	} 
}
