package graphicInterface;

import java.awt.Color;

import javax.swing.JButton;

public abstract class Board {
	private JButton [][]gridButton = new JButton[10][10];
	
	public void createBoard() {
		for(int i=0; i<10;i++) {
				for(int j=0; j<10 ; j++) {
					gridButton[i][j]= new JButton("0");
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
