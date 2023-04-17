package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import entities.AttackBoard;
import entities.DefenseBoard;
import entities.Player;
import exceptions.NotSelectedException;
import procedures.Check;
import procedures.TimerAttack;

public class Janela extends JFrame implements ActionListener{
	private Player p1 = new Player();
	private Player p2 = new Player();
	private Check check = new Check();
	
	private DefenseBoard defenseBoardP1 = new DefenseBoard();
	private DefenseBoard defenseBoardP2 = new DefenseBoard();
	private AttackBoard attackBoardP1 = new AttackBoard();
	private AttackBoard attackBoardP2 = new AttackBoard();
	
	private JPanel panelInitial = new JPanel(new GridLayout(4,1));
	private JPanel panelTitle = new JPanel(new FlowLayout());
	private JPanel panelGameMode = new JPanel(new FlowLayout());
	private JPanel panelCustom = new JPanel(new FlowLayout());
	private JPanel panelName = new JPanel(new FlowLayout());
	private JPanel panelBoard= new JPanel(new GridLayout(10,10));
	private JPanel panelButtons = new JPanel(new GridLayout(6,1));
	
	private JLabel titleInitial;
	private JLabel titleGameMode;
	private JLabel titleName = new JLabel("Digite seu Nome:");
	private JLabel titleDefense;
	private JLabel titleAttack;
	
	private JLabel timerLabel= new JLabel("00:00:00");
	
	private JButton newGameButton;
	private JButton instructionButton;
	private JButton recordeButton;
	private JButton backButton = new JButton("Voltar");
	private JButton exitButton;
	private JButton normalGameModeButton= new JButton("Modo Normal");
	private JButton customGameModeButton= new JButton("Modo Custom");
	private JButton saveButtonCustom = new JButton("Salvar");
	private JButton saveButtonP1 = new JButton("Salvar");
	private JButton saveButtonP2 = new JButton("Salvar");
	private JButton ship1Button = new JButton("Ship1");
	private JButton ship2Button = new JButton("Ship2");
	private JButton ship3Button = new JButton("Ship3");
	private JButton ship4Button = new JButton("Ship4"); 
	private JButton portaAvioesButton = new JButton("PortaAvioes");
	private JButton orientationButton = new JButton("0");
	
	private JTextField quantField = new JTextField("4",10);
	private JTextField nameField = new JTextField(13);
	
	private JRadioButton optionShip1 = new JRadioButton("Ship1");
	private JRadioButton optionShip2 = new JRadioButton("Ship2");
	private JRadioButton optionShip3 = new JRadioButton("Ship3");
	private JRadioButton optionShip4 = new JRadioButton("Ship4");
	private JRadioButton optionPortaAvioes = new JRadioButton("PortaAvioes");
	
	private int numberX;
	private int numberY;
	private int length = 1;
	private String selectedShip="";
	private TimerAttack timer = new TimerAttack(timerLabel);
	
	public Janela() {
		super("Batalha Naval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		createPanelInitial();
		timer.start();
	}
	
	public void createPanelInitial() {
		titleInitial = new JLabel("Batalha Naval");
		titleInitial.setFont(new Font("Verdana",Font.PLAIN,60));
		
		newGameButton = new JButton("Novo Jogo");
		newGameButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		instructionButton = new JButton("Instruções");
		instructionButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		recordeButton = new JButton("Recorde");
		recordeButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		exitButton = new JButton("Sair");
		exitButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		
		newGameButton.addActionListener(this);
		instructionButton.addActionListener(this);
		recordeButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		panelTitle.add(titleInitial);
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
		
		normalGameModeButton.addActionListener(this);
		customGameModeButton.addActionListener(this);
		
		panelTitle.add(titleGameMode);
		panelGameMode.add(normalGameModeButton);
		panelGameMode.add(customGameModeButton);
		
		add(panelGameMode);
	}
	
	public void requestName(JButton saveButton) {
		panelTitle.removeAll();
		
		titleName.setFont(new Font("Verdana",Font.PLAIN,60));
		
		saveButton.setFont(new Font("Verdana",Font.PLAIN,35));
		
		nameField.setFont(new Font("Verdana",Font.PLAIN,30));
		
		saveButton.addActionListener(this);
		
		panelTitle.add(titleName);
		panelName.add(nameField);
		panelName.add(saveButton);
		
		add(panelName);
		
	}
	
	public void reset() {
		p1.setName("");
		p1.setTries(4);
		p1.setAttackTries(3);
		p1.setVictory(false);
		p2.setName("");
		p2.setTries(4);
		p2.setAttackTries(3);
		p2.setVictory(false);
		
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				defenseBoardP1.getGridButton()[i][j].setText("");
				defenseBoardP1.getGridButton()[i][j].removeActionListener(this);
				
				defenseBoardP2.getGridButton()[i][j].setText("");
				defenseBoardP2.getGridButton()[i][j].removeActionListener(this);
				
				attackBoardP1.getGridButton()[i][j].setText("");
				attackBoardP1.getGridButton()[i][j].removeActionListener(this);
				
				attackBoardP2.getGridButton()[i][j].setText("");
				attackBoardP2.getGridButton()[i][j].removeActionListener(this);
			}
		}
			
		panelInitial.removeAll();
		panelTitle.removeAll();
		panelGameMode.removeAll();
		panelCustom.removeAll();
		panelName.removeAll();
		panelBoard.removeAll();
		panelButtons.removeAll();
	
		newGameButton.removeActionListener(this);
		instructionButton.removeActionListener(this);
		recordeButton.removeActionListener(this);
		backButton.removeActionListener(this);
		exitButton.removeActionListener(this);
		normalGameModeButton.removeActionListener(this);
		customGameModeButton.removeActionListener(this);
		saveButtonCustom.removeActionListener(this);
		saveButtonP1.removeActionListener(this);
		saveButtonP2.removeActionListener(this);
		ship1Button.removeActionListener(this);
		ship2Button.removeActionListener(this);
		ship3Button.removeActionListener(this);
		ship4Button.removeActionListener(this);
		portaAvioesButton.removeActionListener(this);
		orientationButton.removeActionListener(this);
		
		orientationButton.setText("0");
		quantField.setText("4");
		nameField.setText("");

		optionShip1.removeActionListener(this);
		optionShip2.removeActionListener(this);
		optionShip3.removeActionListener(this);
		optionShip4.removeActionListener(this);
		optionPortaAvioes.removeActionListener(this);
		
		numberX = 0;
		numberY = 0;
		length = 1;
		selectedShip="";
		
		timerLabel.setText("");
		timer.resetTimer();
	}
	
	public void requestShips() {
		panelTitle.removeAll();
		JLabel quantShips = new JLabel("Digite quantos navios poderão ser colocados: ");
		quantShips.setFont(new Font("Verdana",Font.PLAIN,20));
		
		JLabel takeOffShips = new JLabel("Selecione os Navios que quiser retirar");
		takeOffShips.setFont(new Font("Verdana",Font.PLAIN,17));
		
		p1.setTries(Integer.parseInt(quantField.getText()));
		p2.setTries(Integer.parseInt(quantField.getText()));
		
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
		
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				defenseBoard.getGridButton()[i][j].addActionListener(this);
				panelBoard.add(defenseBoard.getGridButton()[i][j]);
			}
		}
		
	}
	
	public void configBoard(AttackBoard attackBoard) {
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				attackBoard.getGridButton()[i][j].addActionListener(this);
			}
		}
		
	}
	
	public void addBoard(AttackBoard attackBoard) {
		panelBoard.removeAll();
		
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				panelBoard.add(attackBoard.getGridButton()[i][j]);
			}
		}
		
	}
	
	public void createPanelDefense(Player p) {
		panelTitle.removeAll();
		panelButtons.removeAll();
		
		titleDefense= new JLabel(p.getName() +" - Coloque seu Barco:");
		titleDefense.setFont(new Font("Verdana",Font.PLAIN,30));
		
		ship1Button.addActionListener(this);
		ship2Button.addActionListener(this);
		ship3Button.addActionListener(this);
		ship4Button.addActionListener(this);
		portaAvioesButton.addActionListener(this);
		orientationButton.addActionListener(this);
		
		panelTitle.add(titleDefense);
		panelButtons.add(ship1Button);
		panelButtons.add(ship2Button);
		panelButtons.add(ship3Button);
		panelButtons.add(ship4Button);
		panelButtons.add(portaAvioesButton);
		panelButtons.add(orientationButton);
		
		add(panelBoard);
		add(panelButtons, BorderLayout.EAST);
		
	}
	
	public void createPanelAttack(Player p) {
		panelTitle.removeAll();
		
		titleAttack= new JLabel(p.getName() +" - Hora de atacar:");
		titleAttack.setFont(new Font("Verdana",Font.PLAIN,30));
		
		timerLabel.setFont(new Font("Verdana",Font.PLAIN,20));
		
		panelTitle.add(titleAttack);
		panelTitle.add(timerLabel,BorderLayout.EAST); 
		add(panelBoard);
		
	}
	
	public void setPositionShip(DefenseBoard defenseBoard) {
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(orientationButton.getText()=="0") {
					if(j==numberY && i <= numberX && i > (numberX-length)){ 
						defenseBoard.getGridButton()[i][j].setText("N");
					}
					if(selectedShip.equals("PortaAvioes")) {
						defenseBoard.getGridButton()[numberX-length+1][numberY+1].setText("N");
						defenseBoard.getGridButton()[numberX-length+1][numberY-1].setText("N");
					}
				}
				if(orientationButton.getText()=="90") {
					if(j>=numberY && i == numberX && j < (numberY + length)){ 
						defenseBoard.getGridButton()[i][j].setText("N");
					}
					if(selectedShip.equals("PortaAvioes")) {
						defenseBoard.getGridButton()[numberX+1][numberY+length-1].setText("N");
						defenseBoard.getGridButton()[numberX-1][numberY+length-1].setText("N");
					}
				}
				if(orientationButton.getText()=="180") {
					if(j==numberY && i >= numberX && i < (numberX+length)){ 
						defenseBoard.getGridButton()[i][j].setText("N");
					}
					if(selectedShip.equals("PortaAvioes")) {
						defenseBoard.getGridButton()[numberX+length-1][numberY+1].setText("N");
						defenseBoard.getGridButton()[numberX+length-1][numberY-1].setText("N");
					}
				}
				if(orientationButton.getText()=="270") {
					if(j<=numberY && i == numberX && j > (numberY - length)){ 
						defenseBoard.getGridButton()[i][j].setText("N");
					}
					if(selectedShip.equals("PortaAvioes")) {
						defenseBoard.getGridButton()[numberX+1][numberY-length+1].setText("N");
						defenseBoard.getGridButton()[numberX-1][numberY-length+1].setText("N");
					}
				}
			}
		}
		
	}
	
	public void setAttack(AttackBoard attackBoard) {
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(j==numberY && i == numberX ){ 
					attackBoard.getGridButton()[i][j].setText("N");
				}
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGameButton ) {
			panelInitial.setVisible(false);
			createPanelGameMode();
			panelGameMode.setVisible(true);
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
			JOptionPane.showMessageDialog(null, p1.readRecord());
		}else if(e.getSource() == exitButton) {
			System.exit(0);
		}
		
		if(e.getSource() == normalGameModeButton ) {
			panelGameMode.setVisible(false);
			panelName.setVisible(true);
			requestName(saveButtonP1);
		}else if(e.getSource() == customGameModeButton) {
			panelGameMode.setVisible(false);
			panelCustom.setVisible(true);
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
			panelName.setVisible(true);
			requestName(saveButtonP1);
		}
		
		if(e.getSource() == saveButtonP1) {
			p1.setName(nameField.getText());
			panelName.setVisible(false);
			panelName.removeAll();
			panelBoard.setVisible(true);
			panelButtons.setVisible(true);
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
		
		if(e.getSource()==orientationButton) {
			if(orientationButton.getText().equals("0")) {
				orientationButton.setText("90");
			}else if(orientationButton.getText().equals("90")) {
				orientationButton.setText("180");
			}else if(orientationButton.getText().equals("180")) {
				orientationButton.setText("270");
			}else if(orientationButton.getText().equals("270")) {
				orientationButton.setText("0");
			}
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
					if(selectedShip=="") {
						JOptionPane.showMessageDialog(null, "Primeiro selecione o navio");
					}else {
						numberX=i;
						numberY=j;
						setPositionShip(defenseBoardP1);
						p1.setTries(p1.getTries()-1);
					}
				}
			}
		}
		
		if(p1.getTries() == 0) {
			panelBoard.setVisible(false);
			panelButtons.setVisible(false);
			panelName.setVisible(true);
			selectedShip="";
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
					if(selectedShip=="") {
						JOptionPane.showMessageDialog(null,"Selecione primeiro o barco desejado");
					}else {
						numberX=i;
						numberY=j;
						setPositionShip(defenseBoardP2);
						p2.setTries(p2.getTries()-1);
					}
				}
			}
		}
		
		if(p2.getTries() == 0) {
			panelBoard.setVisible(false);
			panelButtons.setVisible(false);
			panelTitle.setVisible(false);
			configBoard(attackBoardP1);
			configBoard(attackBoardP2);
			addBoard(attackBoardP1);
			timer.resetTimer();
			timer.playP1();
			createPanelAttack(p1);
			panelBoard.setVisible(true);
			panelTitle.setVisible(true);
			p2.setTries(1);
		}
		first:
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				if(e.getSource()==attackBoardP1.getGridButton()[i][j]) {
					numberX=i;
					numberY=j;
					setAttack(attackBoardP1);
					check.checkRight(defenseBoardP2, p1,numberX,numberY);
					check.checkVictory(defenseBoardP2, attackBoardP1, p1);
					p1.setAttackTries(p1.getAttackTries()-1);
					if (p1.isVictory()==true) {
						timer.pauseP1();
						p1.putOnRecords(timerLabel);
						JOptionPane.showMessageDialog(null,"Parabéns "+ p1.getName() +" - Você venceu a partida");
						createPanelInitial();
						panelBoard.setVisible(false);
						panelTitle.removeAll();
						panelTitle.setVisible(false);
						panelTitle.add(titleInitial);
						panelTitle.setVisible(true);
						reset();
						createPanelInitial();
						panelInitial.setVisible(true);
						break first;
					}
				}
			}
		}
	
		if(p1.getAttackTries()==0) {
			timer.pauseP1();
			timerLabel.setText("");
			check.showRight(p1);
			panelTitle.setVisible(false);
			panelBoard.setVisible(false);
			addBoard(attackBoardP2);
			timer.playP2();
			createPanelAttack(p2);
			panelBoard.setVisible(true);
			panelTitle.setVisible(true);
			p1.setAttackTries(3);
			
		}
		second:
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				if(e.getSource()==attackBoardP2.getGridButton()[i][j]) {
					numberX=i;
					numberY=j;
					setAttack(attackBoardP2);
					check.checkRight(defenseBoardP1, p2,numberX,numberY);
					check.checkVictory(defenseBoardP1, attackBoardP2, p2);
					p2.setAttackTries(p2.getAttackTries()-1);
					if(p2.isVictory()==true) {
						timer.pauseP2();
						p2.putOnRecords(timerLabel);
						
						JOptionPane.showMessageDialog(null,"Parabéns "+ p2.getName() +" - Você venceu a partida");
						panelBoard.setVisible(false);
						panelTitle.removeAll();
						panelTitle.setVisible(false);
						panelTitle.add(titleInitial);
						panelTitle.setVisible(true);
						reset();
						createPanelInitial();
						panelInitial.setVisible(true);
						break second;
					}
				}
			}
		}

		if(p2.getAttackTries()==0) {
			timer.pauseP2();
			timerLabel.setText("");
			check.showRight(p2);
			panelTitle.setVisible(false);
			panelBoard.setVisible(false);
			addBoard(attackBoardP1);
			timer.playP1();
			createPanelAttack(p1);
			panelBoard.setVisible(true);
			panelTitle.setVisible(true);
			p2.setAttackTries(3);
		}
		
	}
}
	
	

