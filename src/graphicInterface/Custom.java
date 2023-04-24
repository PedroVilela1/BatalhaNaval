package graphicInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Player;
import entities.Ship;
import procedures.Check;

public class Custom implements ActionListener{
	private Ship ship;
	private Player p1;
	private Player p2;
	private Janela janela;
	private JPanel panelCustom = new JPanel(new FlowLayout());
	private JLabel titleShip1 = new JLabel("Ship1: ");
	private JLabel titleShip2 = new JLabel("Ship2: ");
	private JLabel titleShip3 = new JLabel("Ship3: ");
	private JLabel titleShip4 = new JLabel("Ship4: ");
	private JLabel titlePortaAvioes = new JLabel("Porta Avioes: ");
	
	private JTextField optionShip1 = new JTextField(2);
	private JTextField optionShip2 = new JTextField(2);
	private JTextField optionShip3 = new JTextField(2);
	private JTextField optionShip4 = new JTextField(2);
	private JTextField optionPortaAvioes = new JTextField(2);
	private JButton saveButtonCustom = new JButton("Salvar");
	private JPanel panelTitle;
	private Check check;
	private RequestName requestName;
	

	
	public Custom(Janela janela,JPanel panelTitle, Ship ship,Player p1, Player p2,Check check,RequestName requestName) {
		panelCustom.removeAll();
		this.requestName=requestName;
		this.check=check;
		this.janela=janela;
		this.ship=ship;
		this.p1=p1;
		this.p2=p2;
		this.panelTitle=panelTitle;
		
		panelTitle.removeAll();
	
		JLabel takeOffShips = new JLabel("Selecione a quantidade de navios que você deseja: ");
		takeOffShips.setFont(new Font("Verdana",Font.PLAIN,17));
		
		
		saveButtonCustom.addActionListener(this);
		saveButtonCustom.setBackground(new Color(255,255,255));
		
		titleShip1.setFont(new Font("Verdana",Font.PLAIN,15));
		titleShip2.setFont(new Font("Verdana",Font.PLAIN,15));
		titleShip3.setFont(new Font("Verdana",Font.PLAIN,15));
		titleShip4.setFont(new Font("Verdana",Font.PLAIN,15));
		titlePortaAvioes.setFont(new Font("Verdana",Font.PLAIN,15));
		
		optionShip1.setText("1");
		optionShip2.setText("1");
		optionShip3.setText("1");
		optionShip4.setText("1");
		optionPortaAvioes.setText("1");
		
		panelCustom.add(takeOffShips);
		panelCustom.add(titleShip1);
		panelCustom.add(optionShip1);
		panelCustom.add(titleShip2);
		panelCustom.add(optionShip2);
		panelCustom.add(titleShip3);
		panelCustom.add(optionShip3);
		panelCustom.add(titleShip4);
		panelCustom.add(optionShip4);
		panelCustom.add(titlePortaAvioes);
		panelCustom.add(optionPortaAvioes);
		
		panelCustom.add(saveButtonCustom);
		
		janela.add(panelCustom);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== saveButtonCustom) {
			ship.setQuantShip1(Integer.parseInt(optionShip1.getText()));
			ship.setQuantShip2(Integer.parseInt(optionShip2.getText()));
			ship.setQuantShip3(Integer.parseInt(optionShip3.getText()));
			ship.setQuantShip4(Integer.parseInt(optionShip4.getText()));
			ship.setQuantPortaAvioes(Integer.parseInt(optionPortaAvioes.getText()));
			
			ship.setQuantShip1Final(Integer.parseInt(optionShip1.getText()));
			ship.setQuantShip2Final(Integer.parseInt(optionShip2.getText()));
			ship.setQuantShip3Final(Integer.parseInt(optionShip3.getText()));
			ship.setQuantShip4Final(Integer.parseInt(optionShip4.getText()));
			ship.setQuantPortaAvioesFinal(Integer.parseInt(optionPortaAvioes.getText()));
			
			p1.setTries(ship.getQuantShip1() + ship.getQuantShip2() + ship.getQuantShip3() + ship.getQuantShip4() + ship.getQuantPortaAvioes());
			p2.setTries(ship.getQuantShip1() + ship.getQuantShip2() + ship.getQuantShip3() + ship.getQuantShip4() + ship.getQuantPortaAvioes());
			
			panelCustom.setVisible(false);
			this.requestName = new RequestName(janela, panelTitle,p1,p2,ship,check);
			requestName.requestName(1);
		}
		
	}

}
