package simplecountdown;

import simplecountdown.commands.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class SimpleDateCountdown extends JavaPlugin {
	
	public PluginDescriptionFile archivoPlugin = getDescription();
	public String version = archivoPlugin.getVersion();
	public String nombre = ChatColor.BOLD+""+ChatColor.DARK_RED+"["+ChatColor.GOLD+archivoPlugin.getName()+ChatColor.DARK_RED+"]";
    public static Countdown cuentaRegresiva;
    public PluginManager pm;
    
    public SimpleDateCountdown() {
    	this.pm = Bukkit.getPluginManager();
    }
    
	public void onEnable() {
		String fecha = "25/04/2020 12:30";
		//Cargar datos cuenta regresiva desde config.yml
		cuentaRegresiva = new Countdown("Prueba",fecha);
		Bukkit.getConsoleSender().sendMessage("\n");
		Bukkit.getConsoleSender().sendMessage(nombre+" ha sido cargado (Versión :"+version+")");
		Bukkit.getConsoleSender().sendMessage("\n");
		
		registerCommands();
		registerEvents();

	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("\n");
		Bukkit.getConsoleSender().sendMessage(nombre+" ha sido desactivado (Versión :"+version+")");
		Bukkit.getConsoleSender().sendMessage("\n");
	}
	
	public void registerCommands() {
		this.getCommand("simpledatecountdown").setExecutor(new ComandoSdc(nombre,version,cuentaRegresiva));
		this.getCommand("sdc").setExecutor(new ComandoSdc(nombre,version,cuentaRegresiva));
		this.getCommand("countdown").setExecutor(new ComandoSdc(nombre,version,cuentaRegresiva));
		
	}

	public void registerEvents() {
		
	}
}
