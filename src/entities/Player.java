package entities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import javax.swing.JLabel;

public class Player {
	private String name="";
	private int tries=4;
	private int attackTries = 3;
	private int right;
	private boolean victory = false;
	
	public void putOnRecords(JLabel time) {
		try {
			FileWriter writer = new FileWriter("record.txt",true);
			writer.write(this.name + " - " + time.getText()+"\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String readRecord() {
		String record="";
		try {
			FileReader reader = new FileReader("record.txt");
			int caracter= reader.read();
			while(caracter!=-1) {
				record = record + (char)caracter;
				caracter=reader.read();
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return record;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public int getAttackTries() {
		return attackTries;
	}
	public void setAttackTries(int attackTries) {
		this.attackTries = attackTries;
	}
	public boolean isVictory() {
		return victory;
	}
	public void setVictory(boolean victory) {
		this.victory = victory;
	}
}
