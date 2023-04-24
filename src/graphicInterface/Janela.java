package graphicInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import entities.*;
import exceptions.InvalidAttackException;
import exceptions.NotSelectedException;
import exceptions.OutOfBoundsException;
import exceptions.QuantShipException;
import exceptions.ShipUnderOtherShipException;
import procedures.*;

public class Janela extends JFrame{
	private Player p1 = new Player();
	private Player p2 = new Player();
	private Ship ship = new Ship();
	private Check check = new Check();
	
	public Janela() {
		super("Batalha Naval");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024,720);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		Initial initial = new Initial(this, p1, p2, ship, check);
	}
	
	
}
		
		