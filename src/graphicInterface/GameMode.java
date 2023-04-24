package graphicInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Player;
import entities.Ship;
import procedures.Check;

public class GameMode implements ActionListener{
	private JPanel panelGameMode = new JPanel(new FlowLayout());
	private JLabel titleGameMode;
	private JButton normalGameModeButton= new JButton("Modo Normal");
	private JButton customGameModeButton= new JButton("Modo Custom");
	private Janela janela;
	private JPanel panelTitle;
	private Ship ship;
	private Player p1;
	private Player p2;
	private Check check;
	private RequestName requestName;
	
	public GameMode(Janela janela,JPanel panelTitle,Ship ship,Player p1, Player p2,Check check) {
		panelGameMode.removeAll();
		this.check=check;
		this.janela=janela;
		this.panelTitle=panelTitle;
		this.ship=ship;
		this.p1=p1;
		this.p2=p2;
		panelTitle.removeAll();
		
		titleGameMode= new JLabel("Escolha seu modo de jogo:");
		titleGameMode.setFont(new Font("Verdana",Font.PLAIN,30));
		
		normalGameModeButton.addActionListener(this);
		customGameModeButton.addActionListener(this);
		
		normalGameModeButton.setBackground(new Color(255,255,255));
		customGameModeButton.setBackground(new Color(255,255,255));
		
		panelTitle.add(titleGameMode);
		panelGameMode.add(normalGameModeButton);
		panelGameMode.add(customGameModeButton);
		
		janela.add(panelGameMode);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == normalGameModeButton ) {
			
			panelGameMode.setVisible(false);
			this.requestName = new RequestName(janela, panelTitle,p1,p2,ship,check);
			requestName.requestName(1);
		}else if(e.getSource() == customGameModeButton) {
			panelGameMode.setVisible(false);
			Custom custom = new Custom(janela, panelTitle,ship,p1,p2,check,requestName);
			
		}
		
	}

}
