package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class Janela extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private Player p1 = new Player();
	private Player p2 = new Player();
	private JPanel panelInitial = new JPanel(new GridLayout(4,1));
	private JPanel panelTitle = new JPanel(new FlowLayout());
	private JLabel titleInitial;
	
	private JButton newGameButton;
	private JButton instructionButton;
	private JButton recordeButton;
	private JButton exitButton;
	
	
	private JPanel panelGameMode = new JPanel(new FlowLayout());
	
	private JLabel titleGameMode;
			
	private JButton normalGameModeButton= new JButton("Modo Normal");
	private JButton customGameModeButton= new JButton("Modo Custom");
			
	private String gameModeName="";
	
	
	private JPanel panelCustom = new JPanel(new FlowLayout());
	private JTextField quantField;

	private JButton saveButtonCustom = new JButton("Salvar");
	private boolean loopAttack= false;
	
	
	
	private JPanel panelName = new JPanel(new FlowLayout());
	
	private JLabel titleName = new JLabel("Digite seu Nome:");;
	private JTextField nameField = new JTextField(30);;
	
	private JButton saveButtonP1 = new JButton("Salvar");
	private JButton saveButtonP2 = new JButton("Salvar");

	
	
	private JPanel panelBoard= new JPanel(new GridLayout(10,10));
	private DefenseBoard defenseBoardP1 = new DefenseBoard();
	private DefenseBoard defenseBoardP2 = new DefenseBoard();
	private AttackBoard attackBoardP1 = new AttackBoard();
	private AttackBoard attackBoardP2 = new AttackBoard();
	
	private int numberX;
	private int numberY;
	
	
	private JPanel panelButtons = new JPanel(new GridLayout(6,1));
	private JLabel titleDefense;
	private JLabel titleAttack;
	private int tries=4;
	private int length=1;
	
	
	private String selectedShip="Ship1";
	private JButton ship1Button = new JButton("Ship1");
	private JButton ship2Button = new JButton("Ship2");
	private JButton ship3Button = new JButton("Ship3");
	private JButton ship4Button = new JButton("Ship4"); 
	private JButton portaAvioesButton = new JButton("PortaAvioes"); 
	private JRadioButton optionShip1 = new JRadioButton("Ship1");
	private JRadioButton optionShip2 = new JRadioButton("Ship2");
	private JRadioButton optionShip3 = new JRadioButton("Ship3");
	private JRadioButton optionShip4 = new JRadioButton("Ship4");
	private JRadioButton optionPortaAvioes = new JRadioButton("PortaAvioes");
	
	private int time;
	private int right=0;
	private boolean victory = false;
	
	
	public Janela() {
		super("Batalha Naval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		createPanelInitial();
	}
	
	public void checkRight(DefenseBoard defenseBoard,Player p) {
		if(defenseBoard.getGridButton()[numberX][numberY].getText().equals("N")) {
			p.setRight(p.getRight()+1);
		}
	}
	
	public void createPanelInitial() {
		
		titleInitial = new JLabel("Batalha Naval");
		titleInitial.setFont(new Font("Verdana",Font.PLAIN,60));
		panelTitle.add(titleInitial);
		
		newGameButton = new JButton("Novo Jogo");
		newGameButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		newGameButton.addActionListener(this);
		
		instructionButton = new JButton("Instruções");
		instructionButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		instructionButton.addActionListener(this);
		
		recordeButton = new JButton("Recorde");
		recordeButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		recordeButton.addActionListener(this);
		
		exitButton = new JButton("Sair");
		exitButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		exitButton.addActionListener(this);
		
		
		panelInitial.add(newGameButton);
		panelInitial.add(instructionButton);
		panelInitial.add(recordeButton);
		panelInitial.add(exitButton);
		
		add(panelTitle,BorderLayout.NORTH);
		add(panelInitial);
		
		
	}
	
	public void createPanelGameMode() {
		panelTitle.removeAll();
		titleGameMode= new JLabel("Escolha seu modo de jogo:");
		titleGameMode.setFont(new Font("Verdana",Font.PLAIN,30));
		
		panelTitle.add(titleGameMode);
		
		normalGameModeButton.addActionListener(this);
		customGameModeButton.addActionListener(this);
		
		panelGameMode.add(normalGameModeButton);
		panelGameMode.add(customGameModeButton);
		
		add(panelGameMode);
	}
	
	public void requestName(JButton saveButton) {
		panelTitle.removeAll();
		titleName.setFont(new Font("Verdana",Font.PLAIN,60));
		panelTitle.add(titleName);
		
		saveButton.setFont(new Font("Verdana",Font.PLAIN,35));
		saveButton.addActionListener(this);
		
		panelName.add(nameField);
		panelName.add(saveButton);
		
		add(panelName);
	}
	
	public void requestShips() {
		panelTitle.removeAll();
		JLabel quantShips = new JLabel("Digite quantos navios poderão ser colocados: ");
		quantShips.setFont(new Font("Verdana",Font.PLAIN,20));
		quantField = new JTextField("4",10);
		this.tries = Integer.parseInt(quantField.getText());
		
		JLabel takeOffShips = new JLabel("Selecione os Navios que quiser retirar");
		takeOffShips.setFont(new Font("Verdana",Font.PLAIN,17));
		
		ship1Button.setBackground(new Color(0,255,0));
		optionShip1.addActionListener(this);
		optionShip2.addActionListener(this);
		optionShip3.addActionListener(this);
		optionShip4.addActionListener(this);
		optionPortaAvioes.addActionListener(this);
		saveButtonCustom.addActionListener(this);
		
		panelCustom.add(quantShips);
		panelCustom.add(quantField);
		
		panelCustom.add(takeOffShips);
		panelCustom.add(optionShip1);
		panelCustom.add(optionShip2);
		panelCustom.add(optionShip3);
		panelCustom.add(optionShip4);
		panelCustom.add(optionPortaAvioes);
		panelCustom.add(saveButtonCustom);
		
		
		add(panelCustom);
		
	}
	
	public void configBoard(DefenseBoard defenseBoard) {
		panelBoard.removeAll();
		defenseBoard.createBoard();
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				defenseBoard.getGridButton()[i][j].addActionListener(this);
				panelBoard.add(defenseBoard.getGridButton()[i][j]);
			}
		}
	}
	
	public void configBoard(AttackBoard attackBoard) {
		panelBoard.removeAll();
		attackBoard.createBoard();
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				attackBoard.getGridButton()[i][j].addActionListener(this);
				panelBoard.add(attackBoard.getGridButton()[i][j]);
			}
		}
	}
	
	public void createPanelDefense(Player p) {
		panelTitle.removeAll();
		panelButtons.removeAll();
		
		titleDefense= new JLabel(p.getName() +" - Coloque seu Barco:");
		titleDefense.setFont(new Font("Verdana",Font.PLAIN,30));
		panelTitle.add(titleDefense);
		
		ship1Button.addActionListener(this);
		ship2Button.addActionListener(this);
		ship3Button.addActionListener(this);
		ship4Button.addActionListener(this);
		portaAvioesButton.addActionListener(this);
		
		panelButtons.add(ship1Button);
		panelButtons.add(ship2Button);
		panelButtons.add(ship3Button);
		panelButtons.add(ship4Button);
		panelButtons.add(portaAvioesButton);
		
		
		add(panelBoard);
		add(panelButtons, BorderLayout.EAST);
		
	}
	
	public void createPanelAttack(Player p) {
		panelTitle.removeAll();
		panelButtons.removeAll();
		
		titleAttack= new JLabel(p.getName() +" - Hora de atacar:");
		titleAttack.setFont(new Font("Verdana",Font.PLAIN,30));
		panelTitle.add(titleAttack);
	
		add(panelBoard);
		
	}
	
	public void setPositionShip(int lengthShip, DefenseBoard defenseBoard) {
		this.length = lengthShip;
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(j==numberY && i <= numberX && i > (numberX-lengthShip)){ 
					defenseBoard.getGridButton()[i][j].setText("N");
				}
				if(selectedShip.equals("PortaAvioes")) {
					defenseBoard.getGridButton()[numberX-lengthShip+1][numberY+1].setText("N");
					defenseBoard.getGridButton()[numberX-lengthShip+1][numberY-1].setText("N");
				}
			}
		}
	}
	
	public void setAttack(AttackBoard attackBoard) {
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(j==numberY && i <= numberX ){ 
					attackBoard.getGridButton()[i][j].setText("X");
				}
			}
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGameButton ) {
			panelInitial.setVisible(false);
			createPanelGameMode();
			
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
			System.exit(0);
		}else if(e.getSource() == exitButton) {
			System.exit(0);
		}
	

		if(e.getSource() == normalGameModeButton ) {
			panelGameMode.setVisible(false);
			requestName(saveButtonP1);
		}else if(e.getSource() == customGameModeButton) {
			panelGameMode.setVisible(false);
			requestShips();
		}
		
		
		if(optionShip1.isSelected()) {
			this.ship1Button.setVisible(false);
		}
		if(optionShip2.isSelected()) {
			this.ship2Button.setVisible(false);
		}
		if(optionShip3.isSelected()) {
			this.ship3Button.setVisible(false);
		}
		if(optionShip4.isSelected()) {
			this.ship4Button.setVisible(false);
		}
		if(optionPortaAvioes.isSelected()) {
			this.portaAvioesButton.setVisible(false);
		}
		
		
		if(e.getSource()== saveButtonCustom) {
			p1.setTries(Integer.parseInt(quantField.getText()));
			panelCustom.setVisible(false);
			requestName(saveButtonP1);
		}
		
		
		if(e.getSource() == saveButtonP1) {
			p1.setName(nameField.getText());
			panelName.setVisible(false);
			panelName.removeAll();
			configBoard(defenseBoardP1);
			createPanelDefense(p1);
		}
		
		
		if(e.getSource()==ship1Button ) {
			this.selectedShip="Ship1";
			this.length= 1;
		}else if(e.getSource()== ship2Button) {
			this.selectedShip="Ship2";
			this.length = 2;
		}else if(e.getSource()== ship3Button) {
			this.selectedShip="Ship3";
			this.length = 3;
		}else if(e.getSource()== ship4Button) {
			this.selectedShip="Ship4";
			this.length = 4;
		}else if(e.getSource()== portaAvioesButton) {
			this.selectedShip="PortaAvioes";
			this.length = 3;
		}
		
		
		if(selectedShip =="Ship1") {
			ship1Button.setBackground(new Color(0,255,0));
		}else {
			ship1Button.setBackground(new Color(255,255,255));
		}
		
		if(selectedShip =="Ship2") {
			ship2Button.setBackground(new Color(0,255,0));
		}else {
			ship2Button.setBackground(new Color(255,255,255));
		}
			
		if(selectedShip =="Ship3") {
			ship3Button.setBackground(new Color(0,255,0));
		}else {
			ship3Button.setBackground(new Color(255,255,255));
		}
			
		if(selectedShip =="Ship4") {
			ship4Button.setBackground(new Color(0,255,0));
		}else {
			ship4Button.setBackground(new Color(255,255,255));
		}
		
		if(selectedShip =="PortaAvioes") {
			portaAvioesButton.setBackground(new Color(0,255,0));
		}else {
			portaAvioesButton.setBackground(new Color(255,255,255));
		}
		
		
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				if(e.getSource()==defenseBoardP1.getGridButton()[i][j]) {
					numberX=i;
					numberY=j;
					setPositionShip(length,defenseBoardP1);
					p1.setTries(p1.getTries()-1);
				}
			}
		}
		
		
		if(p1.getTries() == 0) {
			
			panelBoard.setVisible(false);
			panelButtons.setVisible(false);
			panelName.setVisible(true);
			nameField.setText("");
			requestName(saveButtonP2);
			p1.setTries(p1.getTries()+1);
		}
		if(e.getSource() == saveButtonP2) {
			p2.setName(nameField.getText());
			panelName.setVisible(false);
			panelBoard.setVisible(true);
			panelButtons.setVisible(true);
			configBoard(defenseBoardP2);
			createPanelDefense(p2);
		}
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				if(e.getSource()==defenseBoardP2.getGridButton()[i][j]) {
					numberX=i;
					numberY=j;
					setPositionShip(length,defenseBoardP2);
					p2.setTries(p2.getTries()-1);
					
				}
			}
		}
		
		if(p2.getTries() == 0) {
			
			
				panelBoard.setVisible(false);
				panelButtons.setVisible(false);
				
				configBoard(attackBoardP1);
				createPanelAttack(p1);
				
				panelBoard.setVisible(true);
				for(int a=0;a<3;) {
					for(int i=0; i<10;i++) {
						for(int j=0; j<10 ; j++) {
							if(e.getSource()==attackBoardP1.getGridButton()[i][j]) {
								numberX=i;
								numberY=j;
								a++;
								setAttack(attackBoardP1);
								checkRight(defenseBoardP2, p1);
							}
						}
					}
				}
				if(p1.getRight()>=1) {
					JOptionPane.showMessageDialog(null,"Voce acertou pelo menos 1 navio");
					p1.setRight(0);
				}else {
					JOptionPane.showMessageDialog(null,"Voce nao acertou nenhum navio");
					p1.setRight(0);
				}
			
			
			
				panelBoard.setVisible(false);
				panelButtons.setVisible(false);
				
				configBoard(attackBoardP2);
				createPanelAttack(p2);
				
				panelBoard.setVisible(true);
				for(int b=0;b<3;) {
					for(int i=0; i<10;i++) {
						for(int j=0; j<10 ; j++) {
							if(e.getSource()==attackBoardP2.getGridButton()[i][j]) {
								numberX=i;
								numberY=j;
								setAttack(attackBoardP2);
								b++;
								checkRight(defenseBoardP1, p2);
							}
						}
					}	
				}
				if(p2.getRight()>=1) {
					JOptionPane.showMessageDialog(null,"Voce acertou pelo menos 1 navio");
					p2.setRight(0);
				}else {
					JOptionPane.showMessageDialog(null,"Voce nao acertou nenhum navio");
					p2.setRight(0);
				}
			
		}
	}
}
	
	

