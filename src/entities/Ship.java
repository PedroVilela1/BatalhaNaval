package entities;

public class Ship {
	private int length = 1;
	private String selectedShip="";
	
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
}
