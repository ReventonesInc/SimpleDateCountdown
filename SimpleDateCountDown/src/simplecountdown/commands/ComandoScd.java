package simplecountdown.commands;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComandoScd implements CommandExecutor{
	
	private String appname;
	private String version;
	
	public ComandoScd(String name, String version){
		this.appname = name;
		this.version = version;
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
				case "add":
					//Crear el countdown de una fecha especifica
					break;
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
							//comando incorrecto
						}
					}
					break;
				case "delete":
					//Eliminar countdown
					break;
				case "enable":
					//se activa la visualización del countdown en scoreboard
					return true;
				case "disable":
					//se desactiva la visualización del countdown en scoreboard
					return true;
				default:
					//comando incorrecto
			}
		}
		return false;
	}

	

}
