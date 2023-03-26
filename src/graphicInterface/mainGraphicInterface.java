package graphicInterface;

import javax.swing.JFrame;

public class mainGraphicInterface {

	public static void main(String[] args) {
		Janela janela = new Janela();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(1080,720);
		janela.setVisible(true);
	}
	
}
