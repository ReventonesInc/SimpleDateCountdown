package clases;

import java.text.SimpleDateFormat;

public class Countdown{
	private String countDownName;
	private SimpleDateFormat countDownDate;
	
	public Countdown(String countDownName, SimpleDateFormat countDownDate) {
		this.countDownName = countDownName;
		this.countDownDate = countDownDate;
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
