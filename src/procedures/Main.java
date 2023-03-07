package procedures;

import entities.AttackBoard;
import entities.DefenseBoard;
import entities.Player;
import entities.Ship;

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
	
		p1.requestName();
		gameExecutionP1.clearConsole();
		defenseBoardP1.createBoard();
	
		while(gameExecutionP1.getTries() != 0) {
			System.out.println(p1.getName()); 
			defenseBoardP1.printBoard();
			gameExecutionP1.requestShip();
			gameExecutionP1.requestPositionValue();
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
		System.out.println(p1.getName()); 
		defenseBoardP1.printBoard();
		gameExecutionP1.requestProgress();
		gameExecutionP1.clearConsole();
		
		p2.requestName();
		gameExecutionP2.clearConsole();
		defenseBoardP2.createBoard();
	
		while(gameExecutionP2.getTries() != 0) {
			System.out.println(p2.getName()); 
			defenseBoardP2.printBoard();
			gameExecutionP2.requestShip();
			gameExecutionP2.requestPositionValue();
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
		System.out.println(p2.getName()); 
		defenseBoardP2.printBoard();
		gameExecutionP2.requestProgress();
		gameExecutionP2.clearConsole();
		
		attackBoardP1.createBoard();
		attackBoardP2.createBoard();
		
		while(checkP1.getVictory()==false && checkP2.getVictory()==false) {
			
			for(int i =0;i<3;i++) {
				System.out.println(p1.getName()); 
				attackBoardP1.printBoard();
				gameExecutionP1.requestPositionValue();
				gameExecutionP1.setAttack(attackBoardP1);
				gameExecutionP1.clearConsole();
				System.out.println(p1.getName()); 
				attackBoardP1.printBoard();
				gameExecutionP1.requestProgress();
				gameExecutionP1.clearConsole();
				checkP2.checkRight(defenseBoardP2,gameExecutionP1.getNumberX(),gameExecutionP1.getNumberY());
				checkP1.checkVictory(defenseBoardP2, attackBoardP1);
			}
			checkP1.checkHit();
			checkP1.setRight(0);
			
			for(int i =0;i<3;i++) {	
				System.out.println(p1.getName()); 
				attackBoardP2.printBoard();
				gameExecutionP2.requestPositionValue();
				gameExecutionP2.setAttack(attackBoardP2);
				gameExecutionP2.clearConsole();
				System.out.println(p1.getName()); 
				attackBoardP2.printBoard();
				gameExecutionP2.requestProgress();
				gameExecutionP2.clearConsole();
				checkP2.checkRight(defenseBoardP1,gameExecutionP2.getNumberX(),gameExecutionP2.getNumberY());
				checkP1.checkVictory(defenseBoardP1, attackBoardP2);
			}
			checkP2.checkHit();
			checkP2.setRight(0);
		}
		if(checkP1.getVictory()==true) {
			System.out.println("Parabéns "+ p1.getName() +"você venceu a partida");
	
		}else if (checkP2.getVictory()==true) {
			System.out.println("Parabéns "+ p2.getName() +"você venceu a partida");
		}
	}
}
