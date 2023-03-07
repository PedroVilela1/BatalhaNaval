package entities;

public class Ship {
	private String[][] portaAvioes = new String[3][3];
	
	private String[][] ship;
	private String positionValue;
	
	public Ship(String selectedShip) {

		if(selectedShip == "ship4") {
			this.ship=new String [1][4];
				for(int i=0;i<1;i++) {
					for(int j=0;j<4;j++) {
						this.ship[i][j]=" ";
					}
				}
				for(int i=0;i<4;i++) {
					this.ship[0][i] = "N"; 
				}
		}
		
		if(selectedShip == "ship3") {
			this.ship=new String [1][7];
			for(int i=0;i<1;i++) {
				for(int j=0;j<7;j++) {
					this.ship[i][j]=" ";
				}
			}
			for(int i=0;i<7;i++) {
				this.ship[0][i] = "N"; 
			}
			this.ship[0][3]= " ";
		}
		
		if(selectedShip == "ship2") {
			this.ship=new String [1][8];
			for(int i=0;i<1;i++) {
				for(int j=0;j<8;j++) {
					this.ship[i][j]=" ";
				}
			}
			for(int i=0;i<8;i++) {
				this.ship[0][i] = "N"; 
			}
			this.ship[0][2]=" ";
			this.ship[0][5]=" ";
		}
		
		if(selectedShip == "ship1") {
			this.ship=new String [1][7];
			for(int i=0;i<1;i++) {
				for(int j=0;j<7;j++) {
					this.ship[i][j]=" ";
				}
			}
			for(int i=0;i<7;i++) {
				this.ship[0][i] = "N"; 
			}
			this.ship[0][1]=" ";
			this.ship[0][3]=" ";
			this.ship[0][5]=" ";
		}
	}
	
	public String[][] getPortaAvioes() {
		return portaAvioes;
	}
	
	public String[][] getShip() {
		return ship;
	}
	
	/*public void setVertical() {
		this.ship4=new String [4][1];
		this.ship3=new String [7][1];
		this.ship2=new String [8][1];
		this.ship1=new String [7][1];
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<1;j++) {
				this.ship4[i][j]=" ";
			}
		}
		for(int i=0;i<4;i++) {
			this.ship4[i][0] = "N"; 
		}
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<1;j++) {
				this.ship3[i][j]=" ";
			}
		}
		for(int i=0;i<7;i++) {
			this.ship3[i][0] = "N"; 
		}
		this.ship3[3][0]= " ";
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<1;j++) {
				this.ship2[i][j]=" ";
			}
		}
		for(int i=0;i<8;i++) {
			this.ship2[i][0] = "N"; 
		}
		this.ship2[2][0]=" ";
		this.ship2[5][0]=" ";
		
		for(int i=0;i<7;i++) {
			for(int j=0;j<1;j++) {
				this.ship1[i][j]=" ";
			}
		}
		for(int i=0;i<7;i++) {
			this.ship1[i][0] = "N"; 
		}
		this.ship1[1][0]=" ";
		this.ship1[3][0]=" ";
		this.ship1[5][0]=" ";
		
	}*/
}
