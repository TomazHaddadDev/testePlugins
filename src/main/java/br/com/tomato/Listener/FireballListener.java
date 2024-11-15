package br.com.tomato.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FireballListener implements Listener {

    //Solta bola de fogo pela blazerod
    @EventHandler
    public void fireball(PlayerInteractEvent event){



        if(event.getAction() == Action.RIGHT_CLICK_AIR){

            Player player = event.getPlayer();
            Material material = event.getMaterial();

            if(material == Material.BLAZE_ROD){
                Fireball fireball = player.launchProjectile(Fireball.class);
                fireball.setVelocity(player.getLocation().getDirection().multiply(1.5));
                player.sendMessage(ChatColor.DARK_RED + " bola de fogo lançada");

            }


        }

    }

}
