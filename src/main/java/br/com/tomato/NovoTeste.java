package br.com.tomato;

import br.com.tomato.Listener.DropFlowerListener;
import br.com.tomato.Listener.FireballListener;
import br.com.tomato.Listener.PlayerConnectionListener;
import br.com.tomato.Listener.ThorListener;
import br.com.tomato.commands.giveItemCommand;
import br.com.tomato.commands.healCommand;
import br.com.tomato.commands.teleport.teleportCommand;
import br.com.tomato.commands.teleport.tpaCommand;
import br.com.tomato.commands.teleport.tpacceptCommand;
import br.com.tomato.commands.time.turnDayCommand;
import br.com.tomato.commands.time.turnNightCommand;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;


public final class NovoTeste extends JavaPlugin{

    private Map<Player, Player> tpaRequests;

    @Override
    public void onEnable() {

        tpaRequests = new HashMap<>();

        //Commands
        this.getCommand("curar").setExecutor(new healCommand());
        this.getCommand("day").setExecutor(new turnDayCommand());
        this.getCommand("night").setExecutor(new turnNightCommand());
        this.getCommand("giveitem").setExecutor(new giveItemCommand());
        this.getCommand("teleport").setExecutor(new teleportCommand());
        getCommand("tpa").setExecutor(new tpaCommand(tpaRequests));
        getCommand("tpaccept").setExecutor(new tpacceptCommand(tpaRequests));
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
