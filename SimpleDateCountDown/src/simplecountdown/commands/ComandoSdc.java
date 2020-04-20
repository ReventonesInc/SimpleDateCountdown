package simplecountdown.commands;
import java.text.SimpleDateFormat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import simplecountdown.Countdown;

public class ComandoSdc implements CommandExecutor{
	
	private String appname;
	private String version;
	private Countdown cuenta;
	
	public ComandoSdc(String name, String version, Countdown cuenta){
		this.appname = name;
		this.version = version;
		this.cuenta = cuenta;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command comando, String label, String[] args) {
		if(!(sender instanceof Player)) {
			/*
			 * Command is Executed by console
			 * 
			 */
			Bukkit.getConsoleSender().sendMessage("No se debe ejecutar este comando desde la consola");
		}
		else {
			Player jugador = (Player) sender;
			
			switch(args[0]) {
				case "set":
					if(args[1].contentEquals("countdownname")) {
						//Comandos para modificar el nombre de la cuenta regresiva
						return true;
					}
					else {
						if(args[1].contentEquals("date")) {
							//Se modifica la fecha del contador
							return true;
						}
						else {
							jugador.sendMessage(appname+ChatColor.RED+" No existe el comando!");
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
					jugador.sendMessage(ChatColor.GREEN+"------------------------------------------");
                	jugador.sendMessage(appname+ChatColor.WHITE+"Versión instalada "+version);
                	jugador.sendMessage(ChatColor.GREEN+"------------------------------------------");
					return true;
				case "remaining":
					jugador.sendMessage(appname+ChatColor.WHITE+cuenta.getTimeRaiming()+"restantes para "+cuenta.getCountdownName());
					return true;
              	case "view":
                	jugador.sendMessage(appname+ChatColor.WHITE+" Nombre de la cuenta regresiva: "+ cuenta.getCountdownName());
                	jugador.sendMessage(appname+ChatColor.WHITE+" Fecha final: "+ cuenta.getCountdownDate());
                	return true;
				default:
					jugador.sendMessage(appname+ChatColor.RED+" No existe el comando!");
			}
		}
		return false;
	}

	

}
