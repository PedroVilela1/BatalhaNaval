package procedures;

import javax.swing.JLabel;

public class TimerAttack extends Thread{
	private JLabel timerLabel;
	private boolean pausedP1 = true;
	private boolean pausedP2 = true;
	private int secondsP1 = 0;
	private int minutesP1 = 0;
	private int hoursP1 = 0;
	private int secondsP2 = 0;
	private int minutesP2 = 0;
	private int hoursP2 = 0;
	private String time;
	
	public TimerAttack(JLabel label){
		this.timerLabel=label;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000); 
				if(pausedP1==false) {
					secondsP1++;
					if (secondsP1 >= 60) {
						secondsP1 = 0;
						minutesP1++;
						if (minutesP1 >= 60) {
							minutesP1 = 0;
							hoursP1++;
						}
					}
					this.time = String.format("%02d:%02d:%02d", hoursP1, minutesP1, secondsP1);
					timerLabel.setText(time);
				}
				if(pausedP2==false) {
					secondsP2++;
					if (secondsP2 >= 60) {
						secondsP2= 0;
						minutesP2++;
						if (minutesP2 >= 60) {
							minutesP2 = 0;
							hoursP2++;
						}
					}
					this.time = String.format("%02d:%02d:%02d", hoursP2, minutesP2, secondsP2);
					timerLabel.setText(time);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void resetTimer() {
		secondsP1=0;
		secondsP2=0;
		minutesP1=0;
		minutesP2=0;
		hoursP1=0;
		hoursP2=0;
		pausedP1=true;
		pausedP2=true;
	}
	public void pauseP1() {
		this.pausedP1 = true;
		
	}
	public void pauseP2() {
		this.pausedP2 = true;
	}
	
	public void playP1() {
		this.pausedP1 = false;
	}
	public void playP2() {
		this.pausedP2= false;
	}
}

