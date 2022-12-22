
public class Main {
	
public static void main(String[] args){
	GameExecution p1 = new GameExecution();
	GameExecution p2 = new GameExecution();
	
	p1.requestName();
	p1.createDefenseBoard();
	
	for(int i=0;i<4;i++) {
		p1.printDefenseBoard();
		p1.requestPositionValue();
		p1.requestDirection();
		p1.clearConsole();
		}
	}
}
