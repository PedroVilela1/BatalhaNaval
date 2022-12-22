import java.util.Scanner;

public class GameExecution extends Ship{
	private String positionValue;
	private String letter;
	private String numberX;
	private String numberY;
	
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
	
	public void clearConsole() {
		for(int i =0;i<20;i++) {
			System.out.println();
		}
	}
	
	public void setPositionShip(){
		
	}
	
	public void treatString() {
		this.letter = this.positionValue.substring(0,1).toLowerCase();
		
		if(this.positionValue.length() == 3) {
			this.numberY = this.positionValue.substring(2,3);
		} else {
			this.numberY = this.positionValue.substring(2,4);
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
		System.out.print("Digite a posição: ");
		this.positionValue = sc.nextLine();
		treatString();
	}
	
	public void requestDirection() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite a direção do navio: ");
		String answer = sc.nextLine().toLowerCase();
		if(answer == "vert" || answer == "vertical") {
			setVertical();
		}else {
			setHorizontal();
		}
	}
	
}
