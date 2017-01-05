package com.redmancometh.redenchants.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.redmancometh.redenchants.RedEnchants;

import net.md_5.bungee.api.ChatColor;

public class AdminEnchantCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!sender.isOp())
        {
            return true;
        }
        if (args.length < 1)
        {
            sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "(!) " + ChatColor.RESET + "Not enough arguments!");
        }
        Player p = (Player) sender;
        ItemStack i = p.getItemInHand();
        if (i == null || i.getType() == Material.AIR)
        {
            sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "(!) " + ChatColor.RESET + "Not a valid item!");
            return true;
        }
        i.getEnchantments().forEach((ench, level) -> System.out.println(ench.getName() + " " + level));
        if (args.length == 1)
        {
            net.minecraft.server.v1_8_R3.Enchantment ench = RedEnchants.getInstance().getManager().getByName(args[0]);
            net.minecraft.server.v1_8_R3.ItemStack nItem = CraftItemStack.asNMSCopy(i);
            nItem.addEnchantment(ench, 1);
            return true;
        }
        else if (args.length == 2)
        {
            try
            {
                net.minecraft.server.v1_8_R3.Enchantment ench = RedEnchants.getInstance().getManager().getByName(args[0]);
                net.minecraft.server.v1_8_R3.ItemStack nItem = CraftItemStack.asNMSCopy(i);
                nItem.addEnchantment(ench, Integer.parseInt(args[1]));
                return true;
            }
            catch (NumberFormatException e)
            {
                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "(!) " + ChatColor.RESET + "Please enter a valid level!");
            }
        }
        return true;
    }

}
