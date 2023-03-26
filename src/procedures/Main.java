package procedures;

import entities.AttackBoard;
import entities.DefenseBoard;
import entities.Player;
import entities.Ship;
import exceptions.InvalidValueException;

public class Main {
	
	public static void main(String[] args){
	
		GameExecution gameExecutionP1 = new GameExecution();
		GameExecution gameExecutionP2 = new GameExecution();
	
		Player p1 = new Player();
		Player p2 = new Player();
	
		Check checkP1 = new Check();
		Check checkP2 = new Check();
		
		DefenseBoard defenseBoardP1 = new DefenseBoard();
		DefenseBoard defenseBoardP2 = new DefenseBoard();
	
		AttackBoard attackBoardP1 = new AttackBoard();
		AttackBoard attackBoardP2 = new AttackBoard();
	
		Ship ship1P1 = new Ship("ship1");
		Ship ship2P1 = new Ship("ship2");
		Ship ship3P1= new Ship("ship3");
		Ship ship4P1= new Ship("ship4");
	
		Ship ship1P2 = new Ship("ship1");
		Ship ship2P2 = new Ship("ship2");
		Ship ship3P2= new Ship("ship3");
		Ship ship4P2= new Ship("ship4");
		
		boolean continueLoop = false;
		
		do {
			try {
				gameExecutionP1.requestGameMode();
				continueLoop = false;
			} catch (InvalidValueException e) {
				gameExecutionP1.clearConsole();
				System.out.println(e.getMessage());
				continueLoop = true;
			}
		}while(continueLoop == true);
		gameExecutionP2.setGameMode(gameExecutionP1.getGameMode());
		gameExecutionP1.requestQuantShips(gameExecutionP1.getGameMode());
		
		gameExecutionP2.setTries(gameExecutionP1.getTries());
		
		if(gameExecutionP1.getGameMode().equals("custom")) {
			do {
				try {
					gameExecutionP1.requestTakeOffShip(gameExecutionP1.getGameMode());
					continueLoop = false;
				} catch (InvalidValueException e) {
					System.out.println(e.getMessage());
					continueLoop= true;
				}
			}while(continueLoop = true && gameExecutionP1.isLoop()==true);
		}else {
			gameExecutionP1.clearConsole();
		}
		gameExecutionP2.setOptionShip1(gameExecutionP1.getOptionShip1());
		gameExecutionP2.setOptionShip2(gameExecutionP1.getOptionShip2());
		gameExecutionP2.setOptionShip3(gameExecutionP1.getOptionShip3());
		gameExecutionP2.setOptionShip4(gameExecutionP1.getOptionShip4());
		
		System.out.println("Primeiro Jogador");
		p1.requestName();
		gameExecutionP1.clearConsole();
		defenseBoardP1.createBoard();
		
		
		while(gameExecutionP1.getTries() != 0) {
			System.out.println(p1.getName()+" - Posicione os seus barcos"); 
			defenseBoardP1.printBoard();
			
			
			do {
				try {
					gameExecutionP1.requestShip();
					continueLoop = false;
				}catch(InvalidValueException e) {
					gameExecutionP1.clearConsole();
					System.out.println(e.getMessage());
					System.out.println(p1.getName()); 
					defenseBoardP1.printBoard();
					continueLoop = true;
				}
			}while(continueLoop == true);
			
			do {
				try {
					if(gameExecutionP1.getSelectedShip().equals("ship4") ) {
						gameExecutionP1.requestPositionValue(ship4P1);
					}else if (gameExecutionP1.getSelectedShip().equals("ship3")) {
						gameExecutionP1.requestPositionValue(ship3P1);
					}else if (gameExecutionP1.getSelectedShip().equals("ship2")){
						gameExecutionP1.requestPositionValue(ship2P1);
					}else if (gameExecutionP1.getSelectedShip().equals("ship1")) {
						gameExecutionP1.requestPositionValue(ship1P1);
					}
					continueLoop = false;
				}catch (InvalidValueException e) {
					System.out.println(e.getMessage());
					continueLoop = true;
				}
			}while(continueLoop == true);
			
			//p1.requestDirection();
			if(gameExecutionP1.getSelectedShip().equals("ship4") ) {
				gameExecutionP1.setPositionShip(defenseBoardP1,ship4P1);
			}else if (gameExecutionP1.getSelectedShip().equals("ship3")) {
				gameExecutionP1.setPositionShip(defenseBoardP1,ship3P1);
			}else if (gameExecutionP1.getSelectedShip().equals("ship2")){
				gameExecutionP1.setPositionShip(defenseBoardP1,ship2P1);
			}else if (gameExecutionP1.getSelectedShip().equals("ship1")) {
				gameExecutionP1.setPositionShip(defenseBoardP1,ship1P1);
			}
			gameExecutionP1.clearConsole();
			gameExecutionP1.lessTries();
		}
		System.out.println(p1.getName()+" - Resultado final:"); 
		defenseBoardP1.printBoard();
		gameExecutionP1.requestProgress();
		gameExecutionP1.clearConsole();
		
		System.out.println("Segundo Jogador");
		p2.requestName();
		gameExecutionP2.clearConsole();
		defenseBoardP2.createBoard();
		
		while(gameExecutionP2.getTries() != 0) {
			System.out.println(p2.getName()+" - Posicione os seus barcos"); 
			defenseBoardP2.printBoard();
			
			
			do {
				try {
					gameExecutionP2.requestShip();
					continueLoop = false;
				}catch(InvalidValueException e) {
					gameExecutionP1.clearConsole();
					System.out.println(e.getMessage());
					System.out.println(p2.getName()); 
					defenseBoardP1.printBoard();
					continueLoop = true;
					
				}
			}while(continueLoop == true);
			
			do {
				try {
					if(gameExecutionP2.getSelectedShip().equals("ship4") ) {
						gameExecutionP2.requestPositionValue(ship4P2);
					}else if (gameExecutionP2.getSelectedShip().equals("ship3")) {
						gameExecutionP2.requestPositionValue(ship3P2);
					}else if (gameExecutionP2.getSelectedShip().equals("ship2")){
						gameExecutionP2.requestPositionValue(ship2P2);
					}else if (gameExecutionP2.getSelectedShip().equals("ship1")) {
						gameExecutionP2.requestPositionValue(ship1P2);
					}
					continueLoop = false;
				} catch (InvalidValueException e) {
					System.out.println(e.getMessage());
					continueLoop = true;
				}
			}while(continueLoop == true);
			
			//p1.requestDirection();
			if(gameExecutionP2.getSelectedShip().equals("ship4") ) {
				gameExecutionP2.setPositionShip(defenseBoardP2,ship4P2);
			}else if (gameExecutionP2.getSelectedShip().equals("ship3")) {
				gameExecutionP2.setPositionShip(defenseBoardP2,ship3P2);
			}else if (gameExecutionP2.getSelectedShip().equals("ship2")){
				gameExecutionP2.setPositionShip(defenseBoardP2,ship2P2);
			}else if (gameExecutionP2.getSelectedShip().equals("ship1")) {
				gameExecutionP2.setPositionShip(defenseBoardP2,ship1P2);
			}
			gameExecutionP2.clearConsole();
			gameExecutionP2.lessTries();
		}
		System.out.println(p2.getName()+" - Resultado Final:"); 
		defenseBoardP2.printBoard();
		gameExecutionP2.requestProgress();
		gameExecutionP2.clearConsole();
		
		attackBoardP1.createBoard();
		attackBoardP2.createBoard();
		
		first:
			while(checkP1.getVictory()==false && checkP2.getVictory()==false) {
				
				for(int i =0;i<3;i++) {
					System.out.println(p1.getName() + " - Hora de atacar"); 
					attackBoardP1.printBoard();
					do {
						try {
							gameExecutionP1.requestPositionValue();
							continueLoop = false;
						} catch (InvalidValueException e) {
							System.out.println(e.getMessage());
							continueLoop = true;
						}
					}while(continueLoop==true);
					
					gameExecutionP1.setAttack(attackBoardP1);
					gameExecutionP1.clearConsole();
					System.out.println(p1.getName() + " - Hora de atacar"); 
					attackBoardP1.printBoard();
					gameExecutionP1.requestProgress();
					gameExecutionP1.clearConsole();
					checkP2.checkRight(defenseBoardP2,gameExecutionP1.getNumberX(),gameExecutionP1.getNumberY());
					checkP1.checkVictory(defenseBoardP2, attackBoardP1);
					if(checkP1.getVictory()==true) {
						System.out.println("Parabéns "+ p1.getName() +" - Você venceu a partida");
						break first;
					}else if (checkP2.getVictory()==true) {
						System.out.println("Parabéns "+ p2.getName() +" - Você venceu a partida");
						break first;
					}
				}
				checkP1.checkHit();
				checkP1.setRight(0);
				gameExecutionP1.requestProgress();
				gameExecutionP1.clearConsole();
				
				
				
				for(int i =0;i<3;i++) {	
					System.out.println(p2.getName() + " - Hora de atacar"); 
					attackBoardP2.printBoard();
					do {
						try {
							gameExecutionP2.requestPositionValue();
							continueLoop = false;
						} catch (InvalidValueException e) {
							System.out.println(e.getMessage());
							continueLoop = true;
						}
					}while(continueLoop==true);
					gameExecutionP2.setAttack(attackBoardP2);
					gameExecutionP2.clearConsole();
					System.out.println(p2.getName() + " - Hora de atacar"); 
					attackBoardP2.printBoard();
					gameExecutionP2.requestProgress();
					gameExecutionP2.clearConsole();
					checkP2.checkRight(defenseBoardP1,gameExecutionP2.getNumberX(),gameExecutionP2.getNumberY());
					checkP2.checkVictory(defenseBoardP1, attackBoardP2);
					if(checkP1.getVictory()==true) {
						System.out.println("Parabéns "+ p1.getName() +" - Você venceu a partida");
						break first;
					}else if (checkP2.getVictory()==true) {
						System.out.println("Parabéns "+ p2.getName() +" - Você venceu a partida");
						break first;
					}
				}
				checkP2.checkHit();
				checkP2.setRight(0);
				gameExecutionP2.requestProgress();
				gameExecutionP2.clearConsole();
			}
		}
}
