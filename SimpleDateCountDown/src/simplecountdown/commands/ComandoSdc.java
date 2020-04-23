package simplecountdown.commands;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import simplecountdown.Countdown;
import simplecountdown.SimpleDateCountdown;

public class ComandoSdc implements CommandExecutor{
	
	private String appname;
	private String version;
	private Countdown cuenta;
	private SimpleDateFormat formato;
	
	public ComandoSdc(String name, String version, Countdown cuenta){
		this.appname = name;
		this.version = version;
		this.cuenta = cuenta;
		this.formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
		if(!(sender instanceof Player)) {
			/*
			 * Command is Executed by console
			 * 
			 */
			Bukkit.getConsoleSender().sendMessage("No se debe ejecutar este comando desde la consola.");
		}
		else {
			Player jugador = (Player) sender;
			
			switch(args[0]) {
				case "set":
					if(args[1].contentEquals("name")) {
						if(!args[2].isEmpty()) {
							SimpleDateCountdown.cuentaRegresiva.setCountdownName(args[2]);
							//GUARDAR en YAML
							return true;
						}
						else {
							jugador.sendMessage(appname+ChatColor.RED+" Uso incorrecto, el uso correcto es /sdc set name <NombreNuevo>");
						}
						return true;
					}
					else {
						if(args[1].contentEquals("date")) {
							if(!args[2].isEmpty()) {
								if(isThisDateValid(args[2],formato)) {
									SimpleDateCountdown.cuentaRegresiva.setCountdownDate(args[2]);
									//GUARDAR EN YAML
								}
								else {
									jugador.sendMessage(appname+ChatColor.RED+" Uso incorrecto del comando, el uso correcto es /sdc set date dd/mm/yyyy HH:mm");
								}
							}
							//Se modifica la fecha del contador
							return true;
						}
						else {
							jugador.sendMessage(appname+ChatColor.RED+" Uso incorrecto del comando.");
							jugador.sendMessage("/sdc set |name|date|");
						}
					}
					break;
				case "delete":
					jugador.sendMessage(appname+ChatColor.WHITE+" Cuenta regresiva eliminada");
					//Eliminar countdown
					return true;
				case "reload":
					//Comando reload
					return true;
				case "enable":
					jugador.sendMessage(appname+ChatColor.WHITE+" Cuenta activada");
					//se activa la visualización del countdown en scoreboard
					return true;
				case "disable":
					jugador.sendMessage(appname+ChatColor.WHITE+" Cuenta regresiva desactivada");
					//se desactiva la visualización del countdown en scoreboard
					return true;
				case "info":
					//Muestra la info del plugin
					jugador.sendMessage(ChatColor.GREEN+"------------"+appname+ChatColor.GREEN+"------------");
                	jugador.sendMessage("             "+ChatColor.GOLD+"Versión instalada "+version);
                	jugador.sendMessage(ChatColor.GREEN+"------------------------------------------");
					return true;
				case "remaining":
					jugador.sendMessage(appname+ChatColor.WHITE+cuenta.getTimeRaiming()+" restantes para "+ChatColor.DARK_RED+cuenta.getCountdownName());
					return true;
              	case "view":
              		jugador.sendMessage(ChatColor.GREEN+"------------"+appname+ChatColor.GREEN+"------------");
                	jugador.sendMessage(ChatColor.WHITE+" Nombre de la cuenta regresiva: "+ cuenta.getCountdownName());
                	jugador.sendMessage(ChatColor.WHITE+" Fecha final: "+ cuenta.getCountdownDate());
                	jugador.sendMessage(ChatColor.GREEN+"---------------------------------------------");
                	return true;
				default:
					jugador.sendMessage(appname+ChatColor.RED+" No existe el comando!");
			}
		}
		return false;
	}
	
	public boolean isThisDateValid(String dateToValidate, SimpleDateFormat dateFormat){

		if(dateToValidate == null){
			return false;
		}
		
		SimpleDateFormat sdf = dateFormat;
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);
			System.out.println(date);

		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	

}
