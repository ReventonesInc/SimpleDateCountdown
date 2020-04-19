package simplecountdown;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class SimpleDateCountdown extends JavaPlugin {
	PluginDescriptionFile pdfFile = getDescription();
	public String version = pdfFile.getVersion();
	public String nombre = ChatColor.DARK_RED+"["+ChatColor.YELLOW+pdfFile.getName()+ChatColor.DARK_RED+"]";
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(nombre+" ha sido cargado correctamente (Versión :"+version+")");
		
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(nombre+" ha sido desactivado correctamente (Versión :"+version+")");
		
	}
	
}
