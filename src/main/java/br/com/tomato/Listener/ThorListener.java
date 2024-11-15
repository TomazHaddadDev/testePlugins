package br.com.tomato.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class ThorListener implements Listener {

    //Solta raio pelo machado de diamante renomeado
    @EventHandler
    public void thor(PlayerInteractEvent event){

        if(event.getAction() == Action.RIGHT_CLICK_AIR){

            Player player = event.getPlayer();
            Material material = event.getMaterial();
            ItemStack item = player.getInventory().getItemInHand();
            String itemName = item.getItemMeta().getDisplayName();

            if(material == material.DIAMOND_AXE && itemName.equalsIgnoreCase("thor")){
                Block targetBlock = player.getTargetBlock((Set<Material>) null, 100);
                player.sendMessage("2");
                if(targetBlock != null){

                    Location targetLocation =  targetBlock.getLocation();
                    player.getWorld().strikeLightning(targetLocation);
                    player.sendMessage(ChatColor.WHITE + " Raio!");
                }
            }

        }

    }

}
