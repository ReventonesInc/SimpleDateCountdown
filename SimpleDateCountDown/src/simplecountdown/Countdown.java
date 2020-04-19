package simplecountdown;

import java.text.SimpleDateFormat;

public class Countdown{
	private String countDownName;
	private SimpleDateFormat countDownDate;
	
	public Countdown(String countDownName, SimpleDateFormat countDownDate) {
		this.countDownName = countDownName;
		this.countDownDate = countDownDate;
	}
	
	public Countdown(String countDownName) {
		this.countDownName = countDownName;
		this.countDownDate = null;
		//COMENTARIO PARA PUSHEAR
	}
	
	public Countdown() {
		this.countDownName = null;
		this.countDownDate = null;
	}
	
	public String getCountDownName() {
		return countDownName;
	}
	
	public void setCountDownName(String name) {
		this.countDownName = name;
	}
	
	public SimpleDateFormat getCountDownDate() {
		return countDownDate;
	}
	
	public void setCountDownDate(SimpleDateFormat date) {
		this.countDownDate = date;
	}
}
