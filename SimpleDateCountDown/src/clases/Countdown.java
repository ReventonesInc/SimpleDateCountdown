package clases;

import java.text.SimpleDateFormat;

public class Countdown{
	private String countdownName;
	private SimpleDateFormat countdownDate;
	
	public Countdown(String countdownName, SimpleDateFormat countdownDate) {
		this.countdownName = countdownName;
		this.countdownDate = countdownDate;
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
	
	public void setCountdownName(SimpleDateFormat date) {
		this.countdownDate = date;
	}
}
