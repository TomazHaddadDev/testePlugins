package br.com.tomato.commands.time;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class turnNightCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(! (sender instanceof Player)){
            return false;
        }
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("night")){
            if(args.length != 0){
                player.sendMessage(ChatColor.RED + "Use /night");
                return false;
            }

            if(args.length == 0){
                player.getWorld().setTime(13000);
                player.sendMessage(ChatColor.GREEN + "Tempo setado para " + ChatColor.GRAY + ChatColor.BOLD + "Noite");
                return true;
            }
        }
        return false;
    }
}
