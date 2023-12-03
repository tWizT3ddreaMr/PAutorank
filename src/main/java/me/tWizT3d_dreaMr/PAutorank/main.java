package me.tWizT3d_dreaMr.PAutorank;


import org.bukkit.Bukkit;


public class main  extends org.bukkit.plugin.java.JavaPlugin{
	public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
	}
}
