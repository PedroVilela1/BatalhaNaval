package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.Player;
import entities.Ship;
import procedures.Check;

public class Initial implements ActionListener{
	private JPanel panelTitle = new JPanel(new FlowLayout());
	private JPanel panelInitial = new JPanel(new GridLayout(4,1));
	
	private JLabel titleInitial;
	
	private JButton newGameButton;
	private JButton instructionButton;
	private JButton recordeButton;
	
	private JButton exitButton;
	
	private Janela janela;
	
	private Player p1;
	private Player p2;
	private Ship ship;
	private Check check;
	
	public Initial(Janela janela,Player p1, Player p2, Ship ship,Check check) {
		panelInitial.removeAll();
		panelTitle.removeAll();
		this.janela = janela;
		this.check = check;
		this.p1 = p1;
		this.p2 = p2;
		this.ship = ship;
		
		createPanelInitial();
	}
	public void createPanelInitial() {
		titleInitial = new JLabel("Batalha Naval");
		titleInitial.setFont(new Font("Verdana",Font.PLAIN,60));
		
		newGameButton = new JButton("Novo Jogo");
		newGameButton.setFont(new Font("Verdana",Font.PLAIN,35));
		newGameButton.setBackground(new Color(255,255,255));
		
		instructionButton = new JButton("Instruções");
		instructionButton.setFont(new Font("Verdana",Font.PLAIN,35));
		instructionButton.setBackground(new Color(255,255,255));
		
		recordeButton = new JButton("Recorde");
		recordeButton.setFont(new Font("Verdana",Font.PLAIN,35));
		recordeButton.setBackground(new Color(255,255,255));
		
		exitButton = new JButton("Sair");
		exitButton.setFont(new Font("Verdana",Font.PLAIN,35));
		exitButton.setBackground(new Color(255,255,255));
		
		newGameButton.addActionListener(this);
		instructionButton.addActionListener(this);
		recordeButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		panelTitle.add(titleInitial);
		panelInitial.add(newGameButton);
		panelInitial.add(instructionButton);
		panelInitial.add(recordeButton);
		panelInitial.add(exitButton);
		janela.setVisible(false);
		janela.add(panelTitle,BorderLayout.NORTH);
		janela.add(panelInitial);
		janela.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGameButton ) {
			panelInitial.setVisible(false);
			GameMode gameMode = new GameMode(janela, panelTitle,ship,p1,p2,check);
			Menu menu = new Menu(janela, panelInitial, panelTitle, p1,p2,ship,check);
		}else if(e.getSource() == instructionButton) {
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
		}else if(e.getSource() == recordeButton) {
			JOptionPane.showMessageDialog(null, "Top 10 : \n" + p1.treatRecords());
		}else if(e.getSource() == exitButton) {
			System.exit(0);
		}
		
	}
	public JPanel getPanelInitial() {
		return panelInitial;
	}
	public void setPanelInitial(JPanel panelInitial) {
		this.panelInitial = panelInitial;
	}
	public Check getCheck() {
		return check;
	}
	public void setCheck(Check check) {
		this.check = check;
	}
}


