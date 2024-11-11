package br.com.tomato;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class testCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("curar")){

            if(args.length == 0){
                player.sendMessage(ChatColor.RED + "Use: /curar <player> <quantidade>");
                return false;
            }

            if(args.length == 2){
                Player target = Bukkit.getServer().getPlayer(args[0]);

                if(target == null){
                    return false;
                }

                int quantity = Integer.parseInt(args[1]);

                target.setHealth(target.getHealth() + quantity);
                target.sendMessage(ChatColor.GREEN + " você curou " + quantity + ChatColor.RED + " corações");
                target.playSound(target.getLocation(), Sound.CAT_PURREOW, 5, 5);

            }

        }

        return false;
    }

}
