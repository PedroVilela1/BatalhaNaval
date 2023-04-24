package graphicInterface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.Player;
import entities.Ship;
import procedures.Check;

public class Menu implements ActionListener {
	private JMenuBar menuBar = new JMenuBar();
	
    private JMenuItem recordMenu = new JMenuItem("Recorde");
    private JMenuItem exitMenu = new JMenuItem("Sair");
    private JMenuItem instructionMenu = new JMenuItem("Instruções");
    
    private JLabel titleInitial= new JLabel("Batalha Naval");
    
    private Player p1;
    private Player p2;
    
	private JPanel panelInitial;
    private JPanel panelBoard;
    private JPanel panelTitle;
    private JPanel panelGameMode;
    private JPanel panelButtons;
    private JPanel panelCustom;
    private JPanel panelName;

	private Janela janela;

	private Ship ship;

	private Check check;
    
    public Menu(Janela janela,JPanel panelInitial, JPanel panelTitle, Player p1, Player p2, Ship ship, Check check) {
    	this.ship=ship;
    	this.check=check;
    	this.janela=janela;
    	this.panelInitial=panelInitial;
    	this.panelTitle=panelTitle;
    	this.p1=p1;
    	this.p2=p2;
    	
		instructionMenu.addActionListener(this);
		recordMenu.addActionListener(this);
		exitMenu.addActionListener(this);
		
        menuBar.add(instructionMenu);
        menuBar.add(recordMenu);
        menuBar.add(exitMenu);
        
        janela.setJMenuBar(menuBar);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==instructionMenu){
			JOptionPane.showMessageDialog(null, "Instruções (2 jogadores):\r\n"
					+ "\r\n"
					+ "Ambos os jogadores colocam os\r\n"
					+ "Seus navios na grelha de Defesa\r\n"
					+ "\r\n"
					+ "(Quem jogar primeiro indica uma\r\n"
					+ "posição (exemplo: 6-5)\r\n"
					+ "\r\n"
					+ "Cada jogador tem direito a 3 tiros.\r\n"
					+ "No final das 3 jogadas o adversário\r\n"
					+ "indicará se acertou,dizendo “Tiro” \r\n"
					+ "(e o nome do navio onde acertou) \r\n"
					+ "ou “Água” caso não\r\n"
					+ "tenha acertado\r\n"
					+ "\r\n"
					+ "A pessoa deverá então marcar uma\r\n"
					+ "cruz ou ponto na grelha de Ataque\r\n"
					+ "para tentar\r\n"
					+ "\r\n"
					+ "Descobrir onde se encontram os\r\n"
					+ "Navios do adversário\r\n"
					+ "\r\n"
					+ "Se conseguir afundar um navio, o\r\n"
					+ "adversário terá de dizer “Afundou\r\n"
					+ "(o meu Porta-Aviões (ou outro navio)\r\n"
					+ "\r\n"
					+ "Ganha o que afundar todos os.\r\n"
					+ "navios primeiro.\r\n"
					+ "\r\n"
					+ "Boa Sorte\r\n"
					+ "\r\n"
					+ "");
		}else if(e.getSource()==recordMenu) {
			JOptionPane.showMessageDialog(null, "Top 10 : \n" + p1.treatRecords());
		}else if(e.getSource()==exitMenu) {
			System.exit(0);
		}
		
	}
}
