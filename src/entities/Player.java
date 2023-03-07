package entities;
import java.util.Scanner;
public class Player {
	
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void requestName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite seu Nome: ");
		this.name = sc.nextLine();
	}
	
}
