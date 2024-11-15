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
import org.bukkit.util.Vector;

import java.util.Collections;

import java.util.Set;

public class ThorListener implements Listener {

    //Solta raio pelo machado de diamante renomeado
    @EventHandler
    public void thor(PlayerInteractEvent event){

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInHand();
            String itemName = item.getItemMeta().getDisplayName();

            if (item.getType() == Material.DIAMOND_AXE && itemName.equalsIgnoreCase("thor")) {

                Location eyeLocation = player.getEyeLocation();
                Vector direction = eyeLocation.getDirection();

                double maxRange = 40.0;

                for (double distance = 1; distance <= maxRange; distance++) {
                    Location checkLocation = eyeLocation.clone().add(direction.clone().multiply(distance));
                    Block block = checkLocation.getBlock();

                    if (block.getType() != Material.AIR) {
                        player.getWorld().strikeLightning(block.getLocation());
                        player.sendMessage(ChatColor.WHITE + "Raio lançado");
                        break;
                    }
                }
            }
        }

    }



}
