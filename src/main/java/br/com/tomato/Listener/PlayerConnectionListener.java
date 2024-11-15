package br.com.tomato.Listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectionListener implements Listener {

    //Entrar no servidor
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(event.getPlayer().getName() + ChatColor.AQUA + " entrou no servidor");
    }

    //Sair do servidor
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        event.setQuitMessage(event.getPlayer().getName() + ChatColor.AQUA + " saiu do servidor");
    }


}
