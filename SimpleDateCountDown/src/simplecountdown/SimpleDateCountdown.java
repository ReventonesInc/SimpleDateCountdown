package simplecountdown;

import simplecountdown.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class SimpleDateCountdown extends JavaPlugin {
	PluginDescriptionFile archivoPlugin = getDescription();
	public String version = archivoPlugin.getVersion();
	public String nombre = ChatColor.DARK_RED+"["+ChatColor.YELLOW+archivoPlugin.getName()+ChatColor.DARK_RED+"]";
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(nombre+" ha sido cargado (Versión :"+version+")");
		registerCommands();
		registerEvents();

	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(nombre+" ha sido desactivado (Versión :"+version+")");
		
		
	}
	
	public void registerCommands() {
		this.getCommand("scd").setExecutor(new ComandoScd(nombre,version));
		this.getCommand("simpledatecountdown").setExecutor(new ComandoScd(nombre,version));
		
	}

	public void registerEvents() {
		
	}
}
