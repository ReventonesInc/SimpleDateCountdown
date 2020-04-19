package simplecountdown;

import java.text.SimpleDateFormat;

public class Countdown{
	private String countdownName;
	private SimpleDateFormat countdownDate;
	
	public Countdown(String countdownName, SimpleDateFormat countdownDate) {
		this.countdownName = countdownName;
		this.countdownDate = countdownDate;
	}
	
	public Countdown(String countdownName) {
		this.countdownName = countdownName;
		this.countdownDate = null;
		//COMENTARIO PARA PUSHEAR
	}
	
	public Countdown() {
		this.countdownName = null;
		this.countdownDate = null;
	}
	
	public String getCountdownName() {
		return countdownName;
	}
	
	public void setCountdownName(String name) {
		this.countdownName = name;
	}
	
	public SimpleDateFormat getCountdownDate() {
		return countdownDate;
	}
	
	public void setCountdownDate(SimpleDateFormat date) {
		this.countdownDate = date;
	}
}
