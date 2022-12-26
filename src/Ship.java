
public class Ship extends Board{
	private String[][] portaAvioes = new String[3][3];
	private String[][] ship4;
	private String[][] ship3;
	private String[][] ship2;
	private String[][] ship1;
	
	public String[][] getPortaAvioes() {
		return portaAvioes;
	}
	public void setPortaAvioes(String[][] portaAvioes) {
		this.portaAvioes = portaAvioes;
	}
	public String[][] getShip4() {
		return ship4;
	}
	public void setShip4(String[][] ship4) {
		this.ship4 = ship4;
	}
	public String[][] getShip3() {
		return ship3;
	}
	public void setShip3(String[][] ship3) {
		this.ship3 = ship3;
	}
	public String[][] getShip2() {
		return ship2;
	}
	public void setShip2(String[][] ship2) {
		this.ship2 = ship2;
	}
	public String[][] getShip1() {
		return ship1;
	}
	public void setShip1(String[][] ship1) {
		this.ship1 = ship1;
	}
	
	public void setHorizontal() {
		this.ship4=new String [1][4];
		this.ship3=new String [1][7];
		this.ship2=new String [1][8];
		this.ship1=new String [1][7];
		
		for(int i=0;i<1;i++) {
			for(int j=0;j<4;j++) {
				this.ship4[i][j]=" ";
			}
		}
		for(int i=0;i<4;i++) {
			this.ship4[0][i] = "N"; 
		}
		
		for(int i=0;i<1;i++) {
			for(int j=0;j<7;j++) {
				this.ship3[i][j]=" ";
			}
		}
		for(int i=0;i<7;i++) {
			this.ship3[0][i] = "N"; 
		}
		this.ship3[0][3]= " ";
		
		for(int i=0;i<1;i++) {
			for(int j=0;j<8;j++) {
				this.ship2[i][j]=" ";
			}
		}
		for(int i=0;i<8;i++) {
			this.ship2[0][i] = "N"; 
		}
		this.ship2[0][2]=" ";
		this.ship2[0][5]=" ";
		
		for(int i=0;i<1;i++) {
			for(int j=0;j<7;j++) {
				this.ship1[i][j]=" ";
			}
		}
		for(int i=0;i<7;i++) {
			this.ship1[0][i] = "N"; 
		}
		this.ship1[0][1]=" ";
		this.ship1[0][3]=" ";
		this.ship1[0][5]=" ";
		
	}
	
	public void setVertical() {
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
		
	}
}
