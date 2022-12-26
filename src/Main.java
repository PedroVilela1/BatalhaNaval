
public class Main {
	
public static void main(String[] args){
	GameExecution p1 = new GameExecution();
	GameExecution p2 = new GameExecution();
	
	p1.requestName();
	p1.createDefenseBoard();
	
	while(p1.getTries() != 0) {
		p1.printDefenseBoard();
		p1.requestShip();
		p1.requestPositionValue();
		//p1.requestDirection();
		p1.setPositionShip();
		p1.clearConsole();
	}
	
	p2.requestName();
	p2.createDefenseBoard();
	
	while(p2.getTries() != 0) {
		p2.printDefenseBoard();
		p2.requestShip();
		p2.requestPositionValue();
		//p1.requestDirection();
		p2.setPositionShip();
		p2.clearConsole();
		
		}
	}
}
