package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Janela extends JFrame{
	public Janela() {
		super("Batalha Naval");
		createMenu();
		createButtons();
	}
	
	public void createMenu() {
		JMenu menu =new JMenu();
		JMenuItem home = new JMenuItem("Home");
		menu.add(home);
		JMenuBar barra = new JMenuBar();
		barra.add(menu);
		
	}
	
	public void createButtons() {
		JPanel panelButton = new JPanel(new FlowLayout());
		
		JPanel panelTitle = new JPanel(new FlowLayout());
		JLabel title = new JLabel("Batalha Naval");
		title.setFont(new Font("Verdana",Font.PLAIN,70));
		panelTitle.add(title);
		
		JButton newGameButton = new JButton("Novo Jogo");
		newGameButton.setFont(new Font("Verdana",Font.PLAIN,35));
		NewGameAction newGameAction = new NewGameAction();
		newGameButton.addActionListener(newGameAction);
		
		JButton instructionButton = new JButton("Instruções");
		instructionButton.setFont(new Font("Verdana",Font.PLAIN,35));
		InstructionAction instructionAction = new InstructionAction();
		instructionButton.addActionListener(instructionAction);
		
		JButton recordeButton = new JButton("Recorde");
		recordeButton.setFont(new Font("Verdana",Font.PLAIN,35));
		RecordeAction recordeAction = new RecordeAction();
		recordeButton.addActionListener(recordeAction);
		
		JButton exitButton = new JButton("Sair");
		exitButton.setFont(new Font("Verdana",Font.PLAIN,35));
		ExitAction exitAction = new ExitAction();
		exitButton.addActionListener(exitAction);
		
		panelButton.add(newGameButton);
		panelButton.add(instructionButton);
		panelButton.add(recordeButton);
		panelButton.add(exitButton);
		
		add(panelTitle, BorderLayout.NORTH);
		add(panelButton, BorderLayout.CENTER);
	}
}
