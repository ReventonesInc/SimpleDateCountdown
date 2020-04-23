package simplecountdown;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Countdown{
	private String countdownName;
	private String countdownDate;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	public Countdown(String countdownName, String countdownDate) {
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
	
	public String getCountdownDate() {
		return countdownDate;
	}
	
	public void setCountdownDate(String date) {
		this.countdownDate = date;
	}
	
  	public String getTimeRaiming(){
  		
  		Date finalDate;
    	Calendar current = Calendar.getInstance();
    	Date currentDate;
    	String current_date = format.format(current.getTime());
      
        try {
        	finalDate = format.parse(countdownDate);
            currentDate = format.parse(current_date);
            long diffInMillies = finalDate.getTime() - currentDate.getTime();
            long diffenceInMinutes = TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
            
          	int daysRemaining = 0;
          	int hoursRemaining = 0;
          	int minutesRemaining = 0;
          	
            long auxMin = diffenceInMinutes;
            if(auxMin<0) {
            	return "La fecha estipulada ya ocurrió o es inválida";
            }
            while(auxMin > 1440) {
            	auxMin-=1440;
            	daysRemaining++;
            }
            while(auxMin > 60) {
            	auxMin-=60;
            	hoursRemaining++;
            }
            
            if(auxMin > 0) {
            	minutesRemaining = (int) auxMin;
            }
            
          	
          	String text = daysRemaining+" días, "+hoursRemaining+" horas y "+minutesRemaining+" minutos";
            return text;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
      
    public long getTimeRaimingMinutes(){
    	
    	Date finalDate;
    	Calendar current = Calendar.getInstance();
    	Date currentDate;
    	String current_date = format.format(current.getTime());
        try {
        	finalDate = format.parse(countdownDate);
            currentDate = format.parse(current_date);
            long diffInMillies = finalDate.getTime() - currentDate.getTime();
            long diffenceInMinutes = TimeUnit.MINUTES.convert(diffInMillies,TimeUnit.MILLISECONDS);
            return diffenceInMinutes;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
  	}
}