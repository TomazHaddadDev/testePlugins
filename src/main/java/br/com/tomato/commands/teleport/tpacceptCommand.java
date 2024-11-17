package br.com.tomato.commands.teleport;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

public class tpacceptCommand implements CommandExecutor {

    private final Map<Player, Player> tpaRequests;

    public tpacceptCommand(Map<Player, Player> tpaRequests){
        this.tpaRequests = tpaRequests;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if(! (sender instanceof Player)){
            return false;
        }
        Player target = (Player) sender;

        if(!tpaRequests.containsKey(target)){
            target.sendMessage(ChatColor.RED + "Você não tem nenhuma solicitação de teletransporte pendente.");
            return false;
        }

        Player player = tpaRequests.get(target);
        player.teleport(target.getLocation());
        target.sendMessage(ChatColor.GREEN + player.getName() + " foi teletransportado para você.");
        player.sendMessage(ChatColor.GREEN + "Você foi teletransportado para " + target.getName());

        tpaRequests.remove(target);
        return true;
    }
}
