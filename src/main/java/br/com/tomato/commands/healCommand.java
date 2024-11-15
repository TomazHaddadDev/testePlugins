package br.com.tomato.commands;

import com.avaje.ebean.validation.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("curar")){

            if(args.length != 2){
                player.sendMessage(ChatColor.RED + "Use: /curar <player> <quantidade>");
                return false;
            }

            if(args.length == 2){
                Player target = Bukkit.getServer().getPlayer(args[0]);
                int quantity = Integer.parseInt(args[1]);

                //Sem player
                if(target == null){
                    player.sendMessage(ChatColor.RED + "Jogador não encontrado");
                    return false;
                }
                //Target com vida atual máxima
                else if(target.getHealth() == target.getMaxHealth()){
                    player.sendMessage(ChatColor.RED + "Jogador está com vida cheia!");
                    return false;
                }
                //Cura maior que o possivel
                if(target.getHealth() + quantity > target.getMaxHealth()){
                    int healing = (int) (target.getMaxHealth() - target.getHealth());
                    target.setHealth(target.getMaxHealth());
                    sendCureFeedback(target, healing);
                }
                //Cura 0 ou negativa
                else if(quantity <= 0){
                    player.sendMessage(ChatColor.RED + "O valor da cura deve ser positivo!");
                    return false;
                }
                //Correto
                else {
                    target.setHealth(target.getHealth() + quantity);
                    sendCureFeedback(target, quantity);
                }



            }

        }

        return false;
    }

    public void sendCureFeedback(Player target, int quantity){
        target.sendMessage(ChatColor.GREEN + " você curou " + quantity + ChatColor.RED + " corações");
        target.playSound(target.getLocation(), Sound.CAT_PURREOW, 5, 5);
    }

}
