package interfaces;

import javax.swing.JButton;

public interface BoardInterface {
	JButton [][]gridButton = new JButton[10][10];
	
	public JButton [][] getGridButton();
	public void setGridButton(JButton [][] gridButton);
}
