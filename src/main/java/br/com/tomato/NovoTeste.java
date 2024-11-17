package br.com.tomato;

import br.com.tomato.Listener.DropFlowerListener;
import br.com.tomato.Listener.FireballListener;
import br.com.tomato.Listener.PlayerConnectionListener;
import br.com.tomato.Listener.ThorListener;
import br.com.tomato.commands.giveItemCommand;
import br.com.tomato.commands.healCommand;
import br.com.tomato.commands.time.turnDayCommand;
import br.com.tomato.commands.time.turnNightCommand;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;


public final class NovoTeste extends JavaPlugin{

    @Override
    public void onEnable() {
        //Commands
        this.getCommand("curar").setExecutor(new healCommand());
        this.getCommand("day").setExecutor(new turnDayCommand());
        this.getCommand("night").setExecutor(new turnNightCommand());
        this.getCommand("giveitem").setExecutor(new giveItemCommand());
        //Listeners
        this.getServer().getPluginManager().registerEvents(new PlayerConnectionListener(), this);
        this.getServer().getPluginManager().registerEvents(new ThorListener(), this);
        this.getServer().getPluginManager().registerEvents(new FireballListener(), this);
        this.getServer().getPluginManager().registerEvents(new DropFlowerListener(), this);

        Bukkit.getConsoleSender().sendMessage("Plugin Iniciado v2");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Plugin Desligado");
    }

}
