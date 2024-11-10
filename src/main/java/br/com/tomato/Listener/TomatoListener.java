package br.com.tomato.Listener;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class TomatoListener implements Listener {

    //Ativado ao entrar no servidor
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(event.getPlayer().getName() + ChatColor.DARK_PURPLE + " entrou no servidor ");
    }

    //Ativado ao sair do servidor
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        event.setQuitMessage(event.getPlayer().getName() + ChatColor.DARK_PURPLE + " saiu do servidor");
    }

    //Ativado ao bater em um mob
    @EventHandler
    public void onPlayerHitEntity(EntityDamageByEntityEvent event) {

        Entity entity = event.getDamager();
        if (event.getDamager() instanceof Player && !(event.getEntity() instanceof Player)) {
            Player damager = (Player) event.getDamager();
            Entity target = event.getEntity();

            //Bukkit.getLogger().info(damager.getName() + " atingiu " + target.getType());
            damager.sendMessage(ChatColor.WHITE + " mob atingido");

        }
    }

    // ARRUMAR
    /*
    public void onPlayerDropItem(PlayerDropItemEvent event){

        ItemStack item = event.getItemDrop().getItemStack();

        System.out.println("Item deixado cair: " + item.getType() + " com durabilidade " + item.getDurability());

        if(item.getType() == Material.DIAMOND_SWORD){
            event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + " teste");
        }

    }
    */

    //Ativado ao quebrar um bloco
    @EventHandler
    public void breakBlockEvent(BlockBreakEvent event) {

        Block block = event.getBlock();
        Player player = event.getPlayer();

        World world = player.getWorld();

        if (block.getType() == Material.GRASS) {
            world.strikeLightningEffect(block.getLocation());
            world.playSound(player.getLocation(), Sound.AMBIENCE_CAVE, 5, 5);
            player.sendMessage(ChatColor.LIGHT_PURPLE+ " grama quebrada");
        } else {
            world.createExplosion(block.getLocation(), 5.0f, false);
            player.sendMessage(ChatColor.LIGHT_PURPLE+ " bloco quebrado");
        }
    }









}
