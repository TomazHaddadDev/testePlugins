package br.com.tomato;

import br.com.tomato.Listener.FireballListener;
import br.com.tomato.Listener.PlayerConnectionListener;
import br.com.tomato.Listener.ThorListener;
import br.com.tomato.commands.healCommand;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;


public final class NovoTeste extends JavaPlugin{

    @Override
    public void onEnable() {
        this.getCommand("curar").setExecutor(new healCommand());
        this.getServer().getPluginManager().registerEvents(new PlayerConnectionListener(), this);
        this.getServer().getPluginManager().registerEvents(new ThorListener(), this);
        this.getServer().getPluginManager().registerEvents(new FireballListener(), this);
        Bukkit.getConsoleSender().sendMessage("Plugin Iniciado COMMAND");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Plugin Desligado");
    }

}
