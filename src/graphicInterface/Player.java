package graphicInterface;

public class Player {
	private String name="";
	private int time=0;
	private int tries=4;
	private int attackTries = 3;
	private int right;
	
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
}
