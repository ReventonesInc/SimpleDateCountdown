package simplecountdown;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Countdown{
	private String countdownName;
	private Date countdownDate;
	
	public Countdown(String countdownName, Date countdownDate) {
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
	
	public Date getCountdownDate() {
		return countdownDate;
	}
	
	public void setCountdownDate(Date date) {
		this.countdownDate = date;
	}
	
  	public String getTimeRaiming(){
      
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	Calendar current = Calendar.getInstance();
    	Date currentDate;
    	String current_date = format.format(current.getTime());
      
        try {
            currentDate = format.parse(current_date);
            long diffInMillies = countdownDate.getTime() - currentDate.getTime();
            long diffenceInMinutes = TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
          		
          	int daysRemaining = (int)(diffenceInMinutes%1440);
          	long aux = diffenceInMinutes - (daysRemaining*1440);
          	int hoursRemaining = (int)(aux%60);
          	aux = aux-(hoursRemaining*60);
      		int minutesRemaining = (int)aux;
          	
          	String text = daysRemaining+" días, "+hoursRemaining+" horas y "+minutesRemaining+" minutos";
            return text;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
      
    public long getTimeRaimingMinutes(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	Calendar current = Calendar.getInstance();
    	Date currentDate;
    	String current_date = format.format(current.getTime());
        try {
            currentDate = format.parse(current_date);
            long diffInMillies = countdownDate.getTime() - currentDate.getTime();
            long diffenceInMinutes = TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
            return diffenceInMinutes;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
  	}
}