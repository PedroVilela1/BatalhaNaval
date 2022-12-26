import java.util.Scanner;

public class GameExecution extends Ship{
	private String positionValue;
	private String letter;
	private String numberX;
	private String numberY;
	//private String direction;
	private String selectedShip;
	private int tries=4;
	
	public int getTries() {
		return tries;
	}
	public void setTries(int tries) {
		this.tries = tries;
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
	
	public void setPositionShip(){
		setHorizontal();
		int intNumberX = Integer.parseInt(this.numberX);
		int intNumberY = Integer.parseInt(this.numberY);
		int length= 0;
		
		switch(this.selectedShip) {
			case "ship4":
				length=this.getShip4()[0].length;
				break;
			case "ship3":
				
				length=this.getShip3()[0].length;
				break;
			case "ship2":
				length=this.getShip2()[0].length;
				break;
			case "ship1":
				length=this.getShip1()[0].length;
				break;
		}
		
		for(int i =0;i< 10;i++) {
			for(int j=0;j< 10;j++) {
				if(j==intNumberY && i <= intNumberX && i > (intNumberX-length))  {
					setDefenseBoard("N",i,j);
				}
				switch(this.selectedShip) {
				case "ship4":
					break;
				case "ship3":
					if(j==intNumberY && i == intNumberX-3 ) {
						setDefenseBoard("0",i,j);
					}
					break;
				case "ship2":
					if(j==intNumberY && i == intNumberX-2 ) {
						setDefenseBoard("0",i,j);
					}
					if(j==intNumberY && i == intNumberX-5 ) {
						setDefenseBoard("0",i,j);
					}
					break;
				case "ship1":
					if(j==intNumberY && i == intNumberX-1) {
						setDefenseBoard("0",i,j);
					}
					if(j==intNumberY && i == intNumberX-3 ) {
						setDefenseBoard("0",i,j);
					}
					if(j==intNumberY && i == intNumberX-5 ) {
						setDefenseBoard("0",i,j);
					}
					break;
				}
			}
		}
		//os barcos estão na vertical
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
		System.out.print("Digite a posição: ");
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
		System.out.print("Digite o navio selecionado: ");
		this.selectedShip = sc.nextLine().toLowerCase();
		
	}
}
