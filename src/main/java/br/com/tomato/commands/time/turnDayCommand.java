package br.com.tomato.commands.time;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class turnDayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(! (sender instanceof Player)){
            return false;
        }
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("day")) {

            if (args.length != 0) {
                player.sendMessage(ChatColor.RED + "Use: /day");
            }

            if (args.length == 0) {

                player.getWorld().setTime(1000);
                player.sendMessage(ChatColor.GREEN + "Tempo definido para " + ChatColor.YELLOW + ChatColor.BOLD + "Dia");
                return true;
            }
        }
        return false;
    }
}
