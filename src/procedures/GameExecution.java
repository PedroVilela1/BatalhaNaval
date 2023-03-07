package procedures;
import java.util.Scanner;

import entities.AttackBoard;
import entities.DefenseBoard;
import entities.Ship;

public class GameExecution{
	
	private String positionValue;
	private String letter;
	private String numberX;
	private String numberY;
	private String selectedShip;
	//private String direction;
	private int tries=4;
	
	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
	}
	public void	lessTries() {
		this.tries = this.tries - 1;
	}
	public void setPositionValue(String positionValue) {
		this.positionValue = positionValue;
	}
	public String getPositionValue() {
		return this.positionValue;
	}
	public String getNumberX() {
		return this.numberX;
	}
	public String getNumberY() {

		return this.numberY;
	}
	public String getSelectedShip() {
		return this.selectedShip;
	}
	
	public void clearConsole() {
		for(int i =0;i<20;i++) {
			System.out.println();
		}
	}
	
	public boolean setPositionShip(DefenseBoard board,Ship selectedShip){		
		
		int intNumberX = Integer.parseInt(this.numberX);
		int intNumberY = Integer.parseInt(this.numberY);
		int length = selectedShip.getShip()[0].length;
		
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(j==intNumberY && i <= intNumberX && i > (intNumberX-length))  {
					board.setBoard("N",i,j);
				}
				
				if(selectedShip.getShip()[0].length == 7) {
					if(j==intNumberY && i == intNumberX-3 ) {
						 board.setBoard("0",i,j);
					}
				}
				
				if(selectedShip.getShip()[0].length == 8) {
					if(j==intNumberY && i == intNumberX-2 ) {
						board.setBoard("0",i,j);
					}
					if(j==intNumberY && i == intNumberX-5 ) {
						board.setBoard("0",i,j);
					}
				}
				
				if(selectedShip.getShip()[0].length == 7 && selectedShip.getShip()[0][1]==" ") {
					if(j==intNumberY && i == intNumberX-1) {
						board.setBoard("0",i,j);
					}
					if(j==intNumberY && i == intNumberX-3 ) {
						board.setBoard("0",i,j);
					}
					if(j==intNumberY && i == intNumberX-5 ) {
						board.setBoard("0",i,j);
					}
				}
			}
		}
		//os barcos estão na vertical
		return true;
	}
	
	public void treatString() {
		this.letter = this.positionValue.substring(0,1).toLowerCase();
		
		if(this.positionValue.length() == 3) {
			this.numberY = this.positionValue.substring(2,3);
		} else {
			this.numberY = this.positionValue.substring(1,2);
		}
		
		switch(this.letter) {
		
			case "a":
			this.numberX = "0";
			break;
			
			case "b":
			this.numberX = "1";
			break;
			
			case "c":
			this.numberX = "2";
			break;
			
			case "d":
			this.numberX = "3";
			break;
			
			case "e":
			this.numberX = "4";
			break;
			
			case "f":
			this.numberX = "5";
			break;
			
			case "g":
			this.numberX = "6";
			break;
			
			case "h":
			this.numberX = "7";
			break;
			
			case "i":
			this.numberX = "8";
			break;
			
			case "j":
			this.numberX = "9";
			break;
		}
	}
	
	public void requestPositionValue() {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite a posição (Ex:A-5): ");
		this.positionValue = sc.nextLine();
		
		treatString();
		
	}

	
	//public void requestDirection() {
		//Scanner sc = new Scanner(System.in);
		//System.out.print("Digite a direção do navio: ");
		//String answer = sc.nextLine().toLowerCase();
		//System.out.println(answer);
		//if(answer == "vert" || answer == "vertical") {
			//setVertical();
			//this.direction="vert";
		//}else if(answer == "horiz" || answer == "horizontal"){
			//setHorizontal();
			//this.direction="horiz";
		//}
	//}
	
	public void requestShip() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Navios: (Ship1) (Ship2) (Ship3) (Ship4)");
		System.out.print("Digite o navio selecionado: ");
		this.selectedShip = sc.nextLine().toLowerCase();
	}
	
	public void printInstructions() {

		System.out.println("");
	}
	
	public boolean setAttack(AttackBoard board) {
		int intNumberX = Integer.parseInt(this.numberX);
		int intNumberY = Integer.parseInt(this.numberY);
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(j==intNumberY && i == intNumberX )  {
					board.setBoard("N",i,j);
				}
			}
		}
		return true;
	}
	
	public void requestProgress() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Aperte enter para prosseguir");
		sc.nextLine();
	}
}