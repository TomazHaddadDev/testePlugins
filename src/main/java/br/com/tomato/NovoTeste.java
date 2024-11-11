package br.com.tomato;

import br.com.tomato.Listener.TomatoListener;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;


public final class NovoTeste extends JavaPlugin{

    @Override
    public void onEnable() {
        this.getCommand("curar").setExecutor(new testCommand());
        this.getServer().getPluginManager().registerEvents(new TomatoListener(), this);
        Bukkit.getConsoleSender().sendMessage("Plugin Iniciado COMMAND");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Plugin Desligado");
    }

}
