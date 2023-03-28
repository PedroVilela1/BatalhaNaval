package procedures;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entities.AttackBoard;
import entities.DefenseBoard;
import entities.Ship;
import exceptions.InvalidValueException;

public class GameExecution{
	
	private String positionValue;
	private String letter;
	private String numberX;
	private String numberY;
	private String selectedShip;
	private String optionShip1 = "Ship1";
	private String optionShip2 = "Ship2";
	private String optionShip3 = "Ship3";
	private String optionShip4 = "Ship4";
	private String gameMode;
	private boolean loop = true;
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
		for(int i =0;i<100;i++) {
			System.out.println();
		}
	}
	
	public void requestTakeOffShip(String gameMode) throws InvalidValueException {
		
		if(gameMode.equals("custom")) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Se quiser tirar algum tipo de navio das opções: (Ship1) (Ship2) (Ship3) (Ship4), digite S, se não digite N");
			System.out.print("Digite sua opção: ");
			String resposta = sc.nextLine().toLowerCase();
			if(resposta.equals("s") || resposta.equals("n") ) {
				String resposta2;
				
				clearConsole();
				if(resposta.equals("s")) {
					boolean continueLoop=false;
					do {
						System.out.println("Qual navio deseja tirar: " + this.optionShip1 + " " +this.optionShip2 + " "+ this.optionShip3 + " " + this.optionShip4);
						System.out.print("Digite sua opção: ");
						resposta2 = sc.nextLine().toLowerCase();
						if(resposta2.equals("ship1")  || resposta2.equals("ship2") || resposta2.equals("ship3")  || resposta2.equals("ship4") ) {
							if(resposta2.equals("ship1")) {
								this.optionShip1 = "       ";
							}else if(resposta2.equals("ship2")) {
								this.optionShip2 = "       "; 
							}else if(resposta2.equals("ship3")) {
								this.optionShip3 = "       "; 
							}else if(resposta2.equals("ship4")) {
								this.optionShip4 = "       "; 
							}
						}else {
							InvalidValueException e = new InvalidValueException("O texto digitado anteriormente é invalido(" + resposta2 +")" + " Digite novamente:");
							throw e;
						}

						
						
						if(this.optionShip1.equals("       ") && this.optionShip2.equals("       ") && this.optionShip3.equals("       ") && this.optionShip4.equals("       ") ) {
							break;
						}
						
						clearConsole();
						System.out.println("Se quiser retirar outro digite S, se não digite N");
						System.out.print("Digite sua opção: ");
						resposta = sc.nextLine().toLowerCase();
						clearConsole();
						
						if(resposta.equals("s")) {
							continueLoop=true;
						} else{
							continueLoop = false;
						}
					}while(continueLoop==true);
					setLoop(false);
					clearConsole();
				}else {
					setLoop(false);
				}
			}else {
				InvalidValueException e = new InvalidValueException("O texto digitado anteriormente é invalido(" + resposta +")" + " Tente novamente:");
				
				throw e;
			}
		
		}
			
	}
	
	public void requestGameMode() throws InvalidValueException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Modos de jogo: (Custom) (Normal)");
		System.out.print("Digite o modo de jogo selecionado: ");
		String resposta = sc.nextLine().toLowerCase();
		
		if(resposta.equals("custom")  || resposta.equals("normal") ) {
			this.setGameMode(resposta);
		}else {
			InvalidValueException e = new InvalidValueException("O texto digitado anteriormente é invalido(" + resposta +")" + "\nDigite novamente");
			throw e;
		}
	}
	
	public void requestQuantShips(String gameMode)  {
		if(gameMode.equals("custom")) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Digite quantos navios poderão ser colocados: ");
			int resposta = sc.nextInt();
			
			setTries(resposta);
			clearConsole();
		}else {
			setTries(4);
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
	
	public void requestPositionValue() throws InvalidValueException{
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite a posição (Ex:A-5): ");
		this.positionValue = sc.nextLine();
		treatString();
		int numberX = Integer.parseInt(this.numberX);
		int numberY = Integer.parseInt(this.numberY);
		
		if(numberX <= 9 && numberX >= 0 && numberY <= 9 && numberY >= 0 ) {
			
		}else {
			InvalidValueException e = new InvalidValueException("O texto digitado anteriormente é invalido(" + this.positionValue +") pois está fora da tabela" + "\nDigite novamente");
			throw e;
		}
			
	}

	public void requestPositionValue(Ship selectedShip) throws InvalidValueException{
		int length = selectedShip.getShip()[0].length;
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite a posição (Ex:A-5): ");
		this.positionValue = sc.nextLine();
		treatString();
		int numberX = Integer.parseInt(this.numberX);
		int numberY = Integer.parseInt(this.numberY);
		
		if(numberX <= 9 && numberX >= 0 && numberY <= 9 && numberY >= 0 && numberX >= length-1) {
			
		}else {
			InvalidValueException e = new InvalidValueException("O texto digitado anteriormente é invalido(" + this.positionValue +") pois está fora da tabela" + "\nDigite novamente");
			throw e;
		}
			
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
	
	public void requestShip() throws InvalidValueException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Navios:" + this.optionShip1 + " " + this.optionShip2 + " "+ this.optionShip3 + " " + this.optionShip4 );
		System.out.print("Digite o navio selecionado: ");
		String resposta = sc.nextLine().toLowerCase();
		
		if(resposta.equals(this.optionShip1.toLowerCase())  || resposta.equals(this.optionShip2.toLowerCase()) || resposta.equals(this.optionShip3.toLowerCase())  || resposta.equals(this.optionShip4.toLowerCase()) ) {
			this.selectedShip = resposta;
		}else {
			InvalidValueException e = new InvalidValueException("O texto digitado anteriormente é invalido(" + resposta + ")" + "\nDigite novamente");
			throw e;
		}
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
	
	public void putOnRecords(String name, String score) {
		String newGame = name + " - " + score;
		try {
			FileWriter writer = new FileWriter("record.txt");
			writer.append("\n"+newGame);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public String getGameMode() {
		return gameMode;
	}
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	public String getOptionShip1() {
		return optionShip1;
	}
	public void setOptionShip1(String optionShip1) {
		this.optionShip1 = optionShip1;
	}
	public String getOptionShip2() {
		return optionShip2;
	}
	public void setOptionShip2(String optionShip2) {
		this.optionShip2 = optionShip2;
	}
	public String getOptionShip3() {
		return optionShip3;
	}
	public void setOptionShip3(String optionShip3) {
		this.optionShip3 = optionShip3;
	}
	public String getOptionShip4() {
		return optionShip4;
	}
	public void setOptionShip4(String optionShip4) {
		this.optionShip4 = optionShip4;
	}
	public boolean isLoop() {
		return loop;
	}
	public void setLoop(boolean loop) {
		this.loop = loop;
	}
}