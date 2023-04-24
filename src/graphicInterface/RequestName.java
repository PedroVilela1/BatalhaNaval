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

public class RequestName implements ActionListener{
	private JPanel panelName = new JPanel(new FlowLayout());
	private JTextField nameField = new JTextField(13);
	private JLabel titleName = new JLabel("Digite seu Nome:");
	private JButton saveButtonP1 = new JButton("Salvar");
	private JButton saveButtonP2 = new JButton("Salvar");
	private Player p1;
	private Player p2;
	private Ship ship;
	private JPanel panelTitle;
	private Janela janela;
	private Check check;
	private Defense defense;
	
	
	public RequestName(Janela janela,JPanel panelTitle,Player p1,Player p2,Ship ship,Check check) {
		panelName.removeAll();
		this.check=check;
		this.janela=janela;
		this.panelTitle=panelTitle;
		this.ship=ship;
		this.p1=p1;
		this.p2=p2;
		
	}
	public void requestName(int whatPlayer) {
		panelTitle.setVisible(true);
		panelTitle.removeAll();
		
		titleName.setFont(new Font("Verdana",Font.PLAIN,60));
		
		saveButtonP1.setFont(new Font("Verdana",Font.PLAIN,35));
		saveButtonP2.setFont(new Font("Verdana",Font.PLAIN,35));
		
		nameField.setFont(new Font("Verdana",Font.PLAIN,30));
		
		saveButtonP1.addActionListener(this);
		saveButtonP1.setBackground(new Color(255,255,255));
		
		saveButtonP2.addActionListener(this);
		saveButtonP2.setBackground(new Color(255,255,255));
		
		panelTitle.add(titleName);
		panelName.add(nameField);
		
		if(whatPlayer==2) {
			panelName.add(saveButtonP2);
		}else {
			panelName.add(saveButtonP1);
		}
		
		
		janela.add(panelName);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == saveButtonP1) {
			p1.setName(nameField.getText());
			panelName.setVisible(false);
			panelName.removeAll();
			this.defense = new Defense(janela, panelTitle, p1, p2, ship, check,this);
			nameField.setText("");
		}
		if(e.getSource() == saveButtonP2) {
			p2.setName(nameField.getText());
			panelName.setVisible(false);
			panelName.removeAll();
			
				
			
			defense.configBoard(defense.getDefenseBoardP2());
			defense.configPanel(p2);
		}
		
		
	}
	public JPanel getPanelName() {
		return panelName;
	}
	public void setPanelName(JPanel panelName) {
		this.panelName = panelName;
	}

}
