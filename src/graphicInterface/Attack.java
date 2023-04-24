package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entities.AttackBoard;
import entities.DefenseBoard;
import entities.Player;
import exceptions.InvalidAttackException;
import procedures.Check;
import procedures.TimerAttack;

public class Attack implements ActionListener{
	private AttackBoard attackBoardP1 = new AttackBoard();
	private AttackBoard attackBoardP2 = new AttackBoard();
	private JLabel titleAttack;
	private JLabel titleInitial;
	private JLabel timerLabel= new JLabel("00:00:00");
	private TimerAttack timer = new TimerAttack(timerLabel);
	
	private int numberX;
	private int numberY;
	private Check check;
	private JPanel panelTitle;
	private JPanel panelBoard;
	private Player p1;
	private Player p2;
	private Janela janela;
	private Defense defense;
	
	public Attack(Janela janela,JPanel panelTitle, JPanel panelBoard,Player p1,Player p2,Check check,Defense defense) {
		this.defense=defense;
		this.janela=janela;
		this.check=check;
		this.panelTitle=panelTitle;
		this.panelBoard=panelBoard;
		this.p1=p1;
		this.p2=p2;
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				attackBoardP1.getGridButton()[i][j].addActionListener(this);
			}
		}
		for(int i=0; i<10;i++) {
			for(int j=0; j<10 ; j++) {
				attackBoardP2.getGridButton()[i][j].addActionListener(this);
			}
		}
		addBoard(attackBoardP1);
		createPanelAttack(p1);
		timer.start();
		timer.resetTimer();
		timer.playP1();
	}
	
	public void reset() {
		p1.setName("");
		p2.setName("");
		
		defense.getShip().setQuantShip1(1);
		defense.getShip().setQuantShip2(1);
		defense.getShip().setQuantShip3(1);
		defense.getShip().setQuantShip4(1);
		defense.getShip().setQuantPortaAvioes(1);
		defense.getShip().setQuantShip1Final(1);
		defense.getShip().setQuantShip2Final(1);
		defense.getShip().setQuantShip3Final(1);
		defense.getShip().setQuantShip4Final(1);
		defense.getShip().setQuantPortaAvioesFinal(1);
		
		p1.setTries(5);
		p1.setAttackTries(3);
		p1.setVictory(false);
		
		p2.setTries(5);
		p2.setAttackTries(3);
		p2.setVictory(false);
		
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				defense.getDefenseBoardP1().getGridButton()[i][j].setText("");
				defense.getDefenseBoardP1().getGridButton()[i][j].removeActionListener(this);
				
				defense.getDefenseBoardP2().getGridButton()[i][j].setText("");
				defense.getDefenseBoardP2().getGridButton()[i][j].removeActionListener(this);
				
				attackBoardP1.getGridButton()[i][j].setText("");
				attackBoardP1.getGridButton()[i][j].removeActionListener(this);
				
				attackBoardP2.getGridButton()[i][j].setText("");
				attackBoardP2.getGridButton()[i][j].removeActionListener(this);
			}
		}
			
		panelTitle.removeAll();
		panelBoard.removeAll();
		
		numberX = 0;
		numberY = 0;
		defense.getShip().setLength(1);
		defense.getShip().setSelectedShip("");
		
		timerLabel.setText("");
		timer.resetTimer();
		this.panelTitle.setVisible(false);
		
	}
	public void addBoard(AttackBoard attackBoard) {
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
				panelBoard.add(attackBoard.getGridButton()[i][j]);
			}
		}
		
	}
	public void createPanelAttack(Player p) {
		panelTitle.removeAll();
		
		titleAttack= new JLabel(p.getName() +" - Hora de atacar:");
		titleAttack.setFont(new Font("Verdana",Font.PLAIN,30));
		
		timerLabel.setFont(new Font("Verdana",Font.PLAIN,20));
		
		panelTitle.add(titleAttack);
		panelTitle.add(timerLabel,BorderLayout.EAST); 
		janela.add(panelBoard);
		
	}
	
	public void attackBoardAction(AttackBoard attackBoard, DefenseBoard defenseBoard, Player p, int i, int j) throws InvalidAttackException{
		InvalidAttackException e1 = new InvalidAttackException();
		numberX=i;
		numberY=j;
		
		if(check.checkAttackBoard(attackBoard, i, j)==false) {
			throw e1;
		}else {
			setAttack(attackBoard);
			check.checkRight(defenseBoard, p, numberX, numberY,attackBoard);
			check.checkVictory(defenseBoard, attackBoard, p);
			p.setAttackTries(p.getAttackTries()-1);
		}
		
	}
	
	public void setAttack(AttackBoard attackBoard) {
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(j==numberY && i == numberX ){ 
					attackBoard.getGridButton()[i][j].setText("X");
				}
			}
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		first:
			for(int i=0; i<10;i++) {
				for(int j=0; j<10 ; j++) {
					if(e.getSource()==attackBoardP1.getGridButton()[i][j]) {
						try {
							attackBoardAction(attackBoardP1, defense.getDefenseBoardP2(), p1, i, j);
							if (p1.isVictory()==true) {
								timer.pauseP1();
								p1.putOnRecords(timerLabel);
								JOptionPane.showMessageDialog(null,"Parabéns "+ p1.getName() +" - Você venceu a partida");
								panelBoard.setVisible(false);
								panelTitle.removeAll();
								panelTitle.setVisible(false);
								titleInitial = new JLabel("Batalha Naval");
								titleInitial.setFont(new Font("Verdana",Font.PLAIN,60));
								panelTitle.add(titleInitial);
								panelTitle.setVisible(true);
								reset();
								p1.setAttackTries(3);
								Initial initial = new Initial(janela, p1, p2, defense.getShip(), check);
								break first;
							}
						} catch (InvalidAttackException e1) {
							JOptionPane.showMessageDialog(null,"Esse ataque já foi feito antes, tente novamente");
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
						try {
							attackBoardAction(attackBoardP2, defense.getDefenseBoardP1(), p2, i, j);
							if(p2.isVictory()==true) {
								timer.pauseP2();
								p2.putOnRecords(timerLabel);
								JOptionPane.showMessageDialog(null,"Parabéns "+ p2.getName() +" - Você venceu a partida");
								panelBoard.setVisible(false);
								panelTitle.removeAll();
								panelTitle.setVisible(false);
								panelTitle.add(titleInitial);
								panelTitle.setVisible(true);
								p2.setAttackTries(3);
								reset();
								Initial initial = new Initial(janela, p1, p2, defense.getShip(), check);
								break second;
							}
						} catch (InvalidAttackException e1) {
							JOptionPane.showMessageDialog(null,"Esse ataque já foi feito antes, tente novamente");
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


