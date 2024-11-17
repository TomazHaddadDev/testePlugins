package br.com.tomato.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if(!(sender instanceof Player)){
            return false;
        }
        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("giveitem")){

            if(args.length != 2){
                player.sendMessage(ChatColor.RED + "Use: /giveitem <item> <quantidade>");
                return false;
            }

            if(args.length == 2){
                String itemName = args[0];
                Material material = Material.getMaterial(itemName.toUpperCase());
                if(material == null){
                    player.sendMessage(ChatColor.RED + "Item não encontado");
                    return false;
                }
                int quantity;
                try {
                    ItemStack item = new ItemStack(material);
                    quantity = Integer.parseInt(args[1]);
                    if (quantity <= 0) {
                        player.sendMessage(ChatColor.RED + "Quantidade deve ser maior que 0");
                        return false;
                    }
                } catch(NumberFormatException e){
                    player.sendMessage(ChatColor.RED + "Insira um número");
                    return false;
                }
                if(player.getInventory().firstEmpty() == -1){
                    player.sendMessage(ChatColor.RED + "Seu inventário está cheio!");
                    return false;
                }


                ItemStack item = new ItemStack(material, quantity);
                player.getInventory().addItem(item);
                player.sendMessage(ChatColor.GREEN + "Item recebido");
            }
        }
        return false;
    }
}
