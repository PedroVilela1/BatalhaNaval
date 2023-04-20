package entities;

public class Ship {
	private int length = 1;
	private String selectedShip="";
	private int quantShip1=1;
	private int quantShip2=1;
	private int quantShip3=1;
	private int quantShip4=1;
	private int quantPortaAvioes=1;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getSelectedShip() {
		return selectedShip;
	}
	public void setSelectedShip(String selectedShip) {
		this.selectedShip = selectedShip;
	}
	public int getQuantShip1() {
		return quantShip1;
	}

	public void setQuantShip1(int quantShip1) {
		this.quantShip1 = quantShip1;
	}

	public int getQuantShip2() {
		return quantShip2;
	}

	public void setQuantShip2(int quantShip2) {
		this.quantShip2 = quantShip2;
	}

	public int getQuantShip3() {
		return quantShip3;
	}

	public void setQuantShip3(int quantShip3) {
		this.quantShip3 = quantShip3;
	}

	public int getQuantShip4() {
		return quantShip4;
	}

	public void setQuantShip4(int quantShip4) {
		this.quantShip4 = quantShip4;
	}

	public int getQuantPortaAvioes() {
		return quantPortaAvioes;
	}

	public void setQuantPortaAvioes(int quantPortaAvioes) {
		this.quantPortaAvioes = quantPortaAvioes;
	}
}
