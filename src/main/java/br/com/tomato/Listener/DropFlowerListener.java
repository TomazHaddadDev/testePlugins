package br.com.tomato.Listener;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.entity.Player;
import java.util.Random;


public class DropFlowerListener implements Listener {


    @EventHandler
    public void onDropFlower(PlayerDropItemEvent event){

        Player player = event.getPlayer();
        Material material = event.getItemDrop().getItemStack().getType();

        if(material == Material.RED_ROSE) {
            player.sendMessage("teste");
            Random rand = new Random();

            Location playerLocation = player.getLocation();
            for (int i = 0; i < 20; i++) {
                double offsetX = (rand.nextDouble() - 0.5) * 2;  // Gera um valor entre -1 e 1
                double offsetY = (rand.nextDouble() - 0.5) * 2;  // Gera um valor entre -1 e 1
                double offsetZ = (rand.nextDouble() - 0.5) * 2;  // Gera um valor entre -1 e 1

                // Cria uma nova localização com o deslocamento
                Location particleLocation = playerLocation.clone().add(offsetX, offsetY, offsetZ);
                player.getWorld().playEffect(particleLocation, Effect.HEART, 0);
            }
        }

    }
}




