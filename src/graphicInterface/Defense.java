package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.DefenseBoard;
import entities.Player;
import entities.Ship;
import exceptions.NotSelectedException;
import exceptions.OutOfBoundsException;
import exceptions.QuantShipException;
import exceptions.ShipUnderOtherShipException;
import procedures.Check;

public class Defense implements ActionListener{
	private DefenseBoard defenseBoardP1 = new DefenseBoard();
	private DefenseBoard defenseBoardP2 = new DefenseBoard();
	
	private JPanel panelBoard= new JPanel(new GridLayout(11,11));
	private JPanel panelButtons = new JPanel(new GridLayout(6,1));
	private JLabel titleDefense;
	private JButton ship1Button = new JButton("Ship1");
	private JButton ship2Button = new JButton("Ship2");
	private JButton ship3Button = new JButton("Ship3");
	private JButton ship4Button = new JButton("Ship4"); 
	private JButton portaAvioesButton = new JButton("PortaAvioes");
	private JButton orientationButton = new JButton("↑");
	private Ship ship;
	private Player p1;
	private Player p2;
	private Check check;
	
	

	private int numberX;
	private int numberY;

	private Janela janela;
	private JPanel panelTitle;
	private RequestName requestName;
	
	public Defense(Janela janela,JPanel panelTitle,Player p1,Player p2,Ship ship, Check check,RequestName requestName) {
		panelButtons.removeAll();
		this.requestName=requestName;
		this.janela=janela;
		this.panelTitle=panelTitle;
		this.ship=ship;
		this.p1=p1;
		this.p2=p2;
		this.check=check;
		ship1Button.addActionListener(this);
		ship2Button.addActionListener(this);
		ship3Button.addActionListener(this);
		ship4Button.addActionListener(this);
		portaAvioesButton.addActionListener(this);
		orientationButton.addActionListener(this);
		
		for(int i=0; i<10;i++) {
				for(int j=0; j<10 ; j++) {
					defenseBoardP1.getGridButton()[i][j].addActionListener(this);
			}
		}
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				defenseBoardP2.getGridButton()[i][j].addActionListener(this);
		}
	}
		setOptionsShips();
		switchColorShipButtons();
		configBoard(defenseBoardP1);
		configPanel(p1);
	}
		
		
			
	public DefenseBoard getDefenseBoardP2() {
		return defenseBoardP2;
	}
	public DefenseBoard getDefenseBoardP1() {
		return defenseBoardP1;
	}

	public JButton getShip1Button() {
		return ship1Button;
	}



	public void setShip1Button(JButton ship1Button) {
		this.ship1Button = ship1Button;
	}



	public JButton getShip2Button() {
		return ship2Button;
	}



	public void setShip2Button(JButton ship2Button) {
		this.ship2Button = ship2Button;
	}



	public JButton getShip3Button() {
		return ship3Button;
	}



	public void setShip3Button(JButton ship3Button) {
		this.ship3Button = ship3Button;
	}



	public JButton getShip4Button() {
		return ship4Button;
	}



	public void setShip4Button(JButton ship4Button) {
		this.ship4Button = ship4Button;
	}



	public JButton getPortaAvioesButton() {
		return portaAvioesButton;
	}



	public void setPortaAvioesButton(JButton portaAvioesButton) {
		this.portaAvioesButton = portaAvioesButton;
	}



	public Ship getShip() {
		return ship;
	}



	public void setShip(Ship ship) {
		this.ship = ship;
	}



	public Check getCheck() {
		return check;
	}



	public void setCheck(Check check) {
		this.check = check;
	}
	public void setDefenseBoardP2(DefenseBoard defenseBoardP2) {
		this.defenseBoardP2 = defenseBoardP2;
	}



	public void configBoard(DefenseBoard defenseBoard) {
		panelBoard.removeAll();
		JLabel letterBlank = new JLabel("-");
		letterBlank.setFont(new Font("Verdana",Font.PLAIN,20));
		letterBlank.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letterBlank);

		JLabel letter1 = new JLabel("1");
		letter1.setFont(new Font("Verdana",Font.PLAIN,20));
		letter1.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter1);

		JLabel letter2 = new JLabel("2");
		letter2.setFont(new Font("Verdana",Font.PLAIN,20));
		letter2.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter2);


		JLabel letter3 = new JLabel("3");
		letter3.setFont(new Font("Verdana",Font.PLAIN,20));
		letter3.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter3);


		JLabel letter4 = new JLabel("4");
		letter4.setFont(new Font("Verdana",Font.PLAIN,20));
		letter4.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter4);


		JLabel letter5 = new JLabel("5");
		letter5.setFont(new Font("Verdana",Font.PLAIN,20));
		letter5.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter5);

		JLabel letter6 = new JLabel("6");
		letter6.setFont(new Font("Verdana",Font.PLAIN,20));
		letter6.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter6);

		JLabel letter7 = new JLabel("7");
		letter7.setFont(new Font("Verdana",Font.PLAIN,20));
		letter7.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter7);

		JLabel letter8 = new JLabel("8");
		letter8.setFont(new Font("Verdana",Font.PLAIN,20));
		letter8.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter8);

		JLabel letter9 = new JLabel("9");
		letter9.setFont(new Font("Verdana",Font.PLAIN,20));
		letter9.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter9);

		JLabel letter10 = new JLabel("10");
		letter10.setFont(new Font("Verdana",Font.PLAIN,20));
		letter10.setHorizontalAlignment(JLabel.CENTER);
		panelBoard.add(letter10);

		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				if(j==0) {
					if(i==0) {
						JLabel letter = new JLabel("A");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==1) {
						JLabel letter = new JLabel("B");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==2) {
						JLabel letter = new JLabel("C");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==3) {
						JLabel letter = new JLabel("D");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==4) {
						JLabel letter = new JLabel("E");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==5) {
						JLabel letter = new JLabel("F");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==6) {
						JLabel letter = new JLabel("G");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==7) {
						JLabel letter = new JLabel("H");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==8) {
						JLabel letter = new JLabel("I");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);
					}else if(i==9) {
						JLabel letter = new JLabel("J");
						letter.setFont(new Font("Verdana",Font.PLAIN,20));
						letter.setHorizontalAlignment(JLabel.CENTER);
						panelBoard.add(letter);

					}
				}
				
				panelBoard.add(defenseBoard.getGridButton()[i][j]);
			}
		}
		

	}
	
	public void configPanel(Player p) {
		panelTitle.removeAll();
		this.panelButtons.removeAll();
		

		this.orientationButton.setText("↑");
		this.orientationButton.setBackground(new Color(255,255,255));
		this.orientationButton.setFont(new Font("cascadia",Font.PLAIN,50));

		this.titleDefense= new JLabel(p.getName() +" - Coloque seu Barco:");
		this.titleDefense.setFont(new Font("Verdana",Font.PLAIN,30));

		

		panelTitle.add(titleDefense);
		panelButtons.add(ship1Button);
		panelButtons.add(ship2Button);
		panelButtons.add(ship3Button);
		panelButtons.add(ship4Button);
		panelButtons.add(portaAvioesButton);
		panelButtons.add(orientationButton);

		janela.add(panelBoard);
		janela.add(panelButtons, BorderLayout.EAST);
		panelBoard.setVisible(true);
		panelButtons.setVisible(true);
	}
		
		
	
	
	public void defenseBoardAction(DefenseBoard defenseBoard,Player p,int i, int j) throws NotSelectedException, OutOfBoundsException, ShipUnderOtherShipException, QuantShipException{
		NotSelectedException e1 = new NotSelectedException();
		OutOfBoundsException e2 = new OutOfBoundsException();
		ShipUnderOtherShipException e3 = new ShipUnderOtherShipException();
		QuantShipException e4 = new QuantShipException();
		numberX=i;
		numberY=j;
		
		if(ship.getSelectedShip()=="") {
			throw e1;
		}else if(ship.getSelectedShip()=="Ship1" && ship.getQuantShip1()==0){
			throw e4;
		}else if(ship.getSelectedShip()=="Ship2" && ship.getQuantShip2()==0){
			throw e4;
		}else if(ship.getSelectedShip()=="Ship3" && ship.getQuantShip3()==0){
			throw e4;
		}else if(ship.getSelectedShip()=="Ship4" && ship.getQuantShip4()==0){
			throw e4;
		}else if(ship.getSelectedShip()=="PortaAvioes" && ship.getQuantPortaAvioes()==0){
			throw e4;
		}else if(numberX-ship.getLength()+1<0 && orientationButton.getText() == "↑"){
			throw e2;
		}else if((numberY==9||numberY==0) && orientationButton.getText() == "↑" && ship.getSelectedShip() == "PortaAvioes" ) {
			throw e2;
		}else if(numberY+ship.getLength()>10 && orientationButton.getText() == "→"){
			throw e2;
		}else if((numberX==9||numberX==0) && orientationButton.getText() == "→" && ship.getSelectedShip() == "PortaAvioes" ) {
			throw e2;
		}else if(numberX+ship.getLength()>10 && orientationButton.getText() == "↓") {
			throw e2;
		}else if((numberY==9||numberY==0) && orientationButton.getText() == "↓" && ship.getSelectedShip() == "PortaAvioes") {
			throw e2;
		}else if(numberY-ship.getLength()+1<0 && orientationButton.getText() == "←") {
			throw e2;
		}else if((numberX==9||numberX==0) && orientationButton.getText() == "←" && ship.getSelectedShip() == "PortaAvioes" ) {
			throw e2;
		}else if(check.checkDefenseBoard(ship, defenseBoard, orientationButton, numberX, numberY)==false){
			throw e3;
		}else {	
			if(ship.getSelectedShip()=="Ship1") {
				ship.setQuantShip1(ship.getQuantShip1()-1);
			}
			if(ship.getSelectedShip()=="Ship2") {
				ship.setQuantShip2(ship.getQuantShip2()-1);
			}
			if(ship.getSelectedShip()=="Ship3") {
				ship.setQuantShip3(ship.getQuantShip3()-1);
			}
			if(ship.getSelectedShip()=="Ship4") {
				ship.setQuantShip4(ship.getQuantShip4()-1);
			}
			if(ship.getSelectedShip()=="PortaAvioes") {
				ship.setQuantPortaAvioes(ship.getQuantPortaAvioes()-1);
			}
			setPositionShip(defenseBoard);
			p.setTries(p.getTries()-1);
			
		}
		
	}
	public void setPositionShip(DefenseBoard defenseBoard) {
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(orientationButton.getText()=="↑" ) {
					if(j==numberY && i <= numberX && i > (numberX-ship.getLength())){ 
						defenseBoard.getGridButton()[i][j].setText("N");
					}
					if(ship.getSelectedShip().equals("PortaAvioes")) {
						defenseBoard.getGridButton()[numberX-ship.getLength()+1][numberY+1].setText("N");
						defenseBoard.getGridButton()[numberX-ship.getLength()+1][numberY-1].setText("N");
					}
				}
				if(orientationButton.getText()=="→") {
					if(j>=numberY && i == numberX && j < (numberY + ship.getLength())){ 
						defenseBoard.getGridButton()[i][j].setText("N");
					}
					if(ship.getSelectedShip().equals("PortaAvioes")) {
						defenseBoard.getGridButton()[numberX+1][numberY+ship.getLength()-1].setText("N");
						defenseBoard.getGridButton()[numberX-1][numberY+ship.getLength()-1].setText("N");
					}
				}
				if(orientationButton.getText()=="↓") {
					if(j==numberY && i >= numberX && i < (numberX+ship.getLength())){ 
						defenseBoard.getGridButton()[i][j].setText("N");
					}
					if(ship.getSelectedShip().equals("PortaAvioes")) {
						defenseBoard.getGridButton()[numberX+ship.getLength()-1][numberY+1].setText("N");
						defenseBoard.getGridButton()[numberX+ship.getLength()-1][numberY-1].setText("N");
					}
				}
				if(orientationButton.getText()=="←") {
					if(j<=numberY && i == numberX && j > (numberY - ship.getLength())){ 
						defenseBoard.getGridButton()[i][j].setText("N");
					}
					if(ship.getSelectedShip().equals("PortaAvioes")) {
						defenseBoard.getGridButton()[numberX+1][numberY-ship.getLength()+1].setText("N");
						defenseBoard.getGridButton()[numberX-1][numberY-ship.getLength()+1].setText("N");
					}
				}
			}
		}
		
	}
	
	public void switchColorShipButtons() {
		if(ship.getSelectedShip() =="Ship1" && ship.getQuantShip1()>0) {
			ship1Button.setBackground(new Color(0,255,0));
		}else if(ship.getQuantShip1()>0){
			ship1Button.setBackground(new Color(255,255,255));
		}
		
		if(ship.getSelectedShip() =="Ship2" && ship.getQuantShip2()>0) {
			ship2Button.setBackground(new Color(0,255,0));
		}else if(ship.getQuantShip2()>0){
			ship2Button.setBackground(new Color(255,255,255));
		}
		
		if(ship.getSelectedShip() =="Ship3" && ship.getQuantShip3()>0) {
			ship3Button.setBackground(new Color(0,255,0));
		}else if(ship.getQuantShip3()>0){
			ship3Button.setBackground(new Color(255,255,255));
		}
		
		if(ship.getSelectedShip() =="Ship4" && ship.getQuantShip4()>0) {
			ship4Button.setBackground(new Color(0,255,0));
		}else if(ship.getQuantShip4()>0){
			ship4Button.setBackground(new Color(255,255,255));
		}
		
		if(ship.getSelectedShip() =="PortaAvioes" && ship.getQuantPortaAvioes()>0) {
			portaAvioesButton.setBackground(new Color(0,255,0));
		}else if(ship.getQuantPortaAvioes()>0){
			portaAvioesButton.setBackground(new Color(255,255,255));
		}
		
	}
	
	public void setOptionsShips() {
		if(ship.getQuantShip1()==0) {
			this.ship1Button.setBackground(new Color(255,0,0));
		}
		
		if(ship.getQuantShip2()==0) {
			this.ship2Button.setBackground(new Color(255,0,0));
		}
		
		if(ship.getQuantShip3()==0) {
			this.ship3Button.setBackground(new Color(255,0,0));
		}
		
		if(ship.getQuantShip4()==0) {
			this.ship4Button.setBackground(new Color(255,0,0));
		}
		
		if(ship.getQuantPortaAvioes()==0) {
			this.portaAvioesButton.setBackground(new Color(255,0,0));
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==ship1Button ) {
			ship.setSelectedShip("Ship1");
			ship.setLength(1);
		}else if(e.getSource()== ship2Button) {
			ship.setSelectedShip("Ship2");
			ship.setLength(2);
		}else if(e.getSource()== ship3Button) {
			ship.setSelectedShip("Ship3");
			ship.setLength(3);
		}else if(e.getSource()== ship4Button) {
			ship.setSelectedShip("Ship4");
			ship.setLength(4);
		}else if(e.getSource()== portaAvioesButton) {
			ship.setSelectedShip("PortaAvioes");
			ship.setLength(3);
		}
		
		if(e.getSource()==orientationButton) {
			if(orientationButton.getText()=="↑") {
				orientationButton.setText("→");
			}else if(orientationButton.getText()=="→") {
				orientationButton.setText("↓");
			}else if(orientationButton.getText()=="↓") {
				orientationButton.setText("←");
			}else if(orientationButton.getText()=="←") {
				orientationButton.setText("↑");
			}
			
		}
		
		
		switchColorShipButtons();
		setOptionsShips();
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				if(e.getSource()==defenseBoardP1.getGridButton()[i][j]) {
					try {
						defenseBoardAction(defenseBoardP1,p1,i, j);
					} catch (NotSelectedException e1) {
						JOptionPane.showMessageDialog(null,"Selecione primeiro o navio desejado");
					} catch (OutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null,"O navio fica fora da grelha, tente novamente");
					} catch (ShipUnderOtherShipException e3) {
						JOptionPane.showMessageDialog(null,"O navio fica por cima de outro, tente novamente");
					} catch (QuantShipException e4) {
						JOptionPane.showMessageDialog(null,"Não tem mais navio disponível");
					} 
				}
			}
		}

		setOptionsShips();

		if(p1.getTries() == 0) {
			panelBoard.setVisible(false);
			panelButtons.setVisible(false);
			panelTitle.setVisible(false);
			panelBoard.removeAll();
			requestName.getPanelName().setVisible(true);
			requestName.requestName(2);

			ship.setQuantShip1(ship.getQuantShip1Final());
			ship.setQuantShip2(ship.getQuantShip2Final());
			ship.setQuantShip3(ship.getQuantShip3Final());
			ship.setQuantShip4(ship.getQuantShip4Final());
			ship.setQuantPortaAvioes(ship.getQuantPortaAvioesFinal());
			ship.setSelectedShip("");

			p1.setTries(1);
		}

		setOptionsShips();
		switchColorShipButtons();
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				if(e.getSource()==defenseBoardP2.getGridButton()[i][j]) {
					try {
						defenseBoardAction(defenseBoardP2,p2,i, j);
					} catch (NotSelectedException e1) {
						JOptionPane.showMessageDialog(null,"Selecione primeiro o navio desejado");
					} catch (OutOfBoundsException e2) {
						JOptionPane.showMessageDialog(null,"O navio fica fora da grelha, tente novamente");
					} catch (ShipUnderOtherShipException e3) {
						JOptionPane.showMessageDialog(null,"O navio fica por cima de outro, tente novamente");
					} catch (QuantShipException e4) {
						JOptionPane.showMessageDialog(null,"Não tem mais navio disponível");
					} 
				}
			}
		}

		setOptionsShips();
		switchColorShipButtons();
		if(p2.getTries() == 0) {
			panelBoard.setVisible(false);
			panelButtons.setVisible(false);
			panelTitle.setVisible(false);
			Attack attack = new Attack(janela, panelTitle, panelBoard, p1,p2,check,this);
			panelBoard.setVisible(true);
			panelTitle.setVisible(true);
			p2.setTries(1);
		}


	}





}
