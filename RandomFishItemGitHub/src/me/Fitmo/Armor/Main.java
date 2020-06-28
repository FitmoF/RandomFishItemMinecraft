package me.Fitmo.Armor;

import org.bukkit.plugin.java.JavaPlugin;
import me.Fitmo.Armor.WearListener.WearListener;

public class Main extends JavaPlugin {
 
	@Override
	public void onEnable() {
        new WearListener(this);
        
    }
}