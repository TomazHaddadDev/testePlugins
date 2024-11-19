package br.com.tomato.commands.teleport;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class tpaCommand implements CommandExecutor {

    private Map<Player, Player> tpaRequests;

    public tpaCommand(Map<Player, Player> tpaRequests) {
        this.tpaRequests = tpaRequests;
    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("tpa")) {

            if (args.length != 1) {
                player.sendMessage(ChatColor.RED + "Use: /tpa <player>");
                return false;
            }

            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Jogador não encontrado");
                    return false;
                }
                if (target == player) {
                    player.sendMessage(ChatColor.RED + "Não é possível enviar uma solicitação a si mesmo");
                    return false;
                }

                if(tpaRequests.containsKey(target)){
                    player.sendMessage(ChatColor.RED + "Jogador já possui solicitação pendente");
                    return false;
                }
                tpaRequests.put(target, player);
                player.sendMessage(ChatColor.GREEN + "Solicitação enviada para " + target.getName());
                target.sendMessage(ChatColor.YELLOW + player.getName() + " quer se teletransportar até você. Use /tpaccept para aceitar.");



            }
        }
        return false;
    }
}
