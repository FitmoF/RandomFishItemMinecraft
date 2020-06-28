
package me.Fitmo.Armor.WearListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
//import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.Plugin;

import me.Fitmo.Armor.Main;

public class WearListener implements Listener
{
	
	
    Random rand;
    
    @SuppressWarnings("unused")
	private Main plugin;
    
    public WearListener(Main plugin) {
        this.rand = new Random();
        this.plugin = plugin;               
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    

    @EventHandler
    public void onPlayerFish(PlayerFishEvent e) {
    	if(e.getState() != PlayerFishEvent.State.FISHING) {
    	Entity hook = e.getHook();
    	e.setCancelled(true);
    	Player p = (Player) e.getPlayer();
    	int randomamount = new Random().nextInt(15) + 1;
    	List<ItemStack> items = new ArrayList<>();
    	for (Material material : Material.values()) {
    	    ItemStack item = new ItemStack(material, randomamount);
    	    items.add(item);
    	}    	    	
    	
    	int size = items.size();
    	int random = new Random().nextInt(size);    	 
    	ItemStack picked = items.get(random);
    	p.getInventory().addItem(picked);
    	hook.remove();
    }
    }
    
}