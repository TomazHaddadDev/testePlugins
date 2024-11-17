package br.com.tomato.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class teleportCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(! (sender instanceof Player)){
            return false;
        }
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("teleport")){

            if(args.length != 1){
                player.sendMessage(ChatColor.RED + "Use: /teleport <player>");
                return false;
            }

            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);

                if(target == null){
                    player.sendMessage(ChatColor.RED + "Jogador não encontrado");
                    return false;
                }
                if(player == target){
                    player.sendMessage(ChatColor.RED + "Não é possível teleportar a si mesmo");
                    return false;
                }
                player.teleport(target.getLocation());
                player.sendMessage(ChatColor.GREEN + "Teletransporte bem sucedido");
                return true;
            }
        }
        return false;
    }
}
