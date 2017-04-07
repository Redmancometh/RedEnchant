package com.redmancometh.redenchants.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import com.google.common.base.CaseFormat;
import com.redmancometh.redenchants.RedEnchants;
import com.redmancometh.redenchants.abstraction.CustomEnchant;
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
        net.minecraft.server.v1_8_R3.ItemStack nItem = CraftItemStack.asNMSCopy(i);
        if (i == null || i.getType() == Material.AIR)
        {
            sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "(!) " + ChatColor.RESET + "Not a valid item!");
            return true;
        }
        i.getEnchantments().forEach((ench, level) -> System.out.println(ench.getName() + " " + level));
        if (args.length == 1)
        {
            System.out.println(nItem.getTag());
            return true;
        }
        else if (args.length == 2)
        {
            try
            {
                net.minecraft.server.v1_8_R3.Enchantment ench = RedEnchants.getInstance().getManager().getByName(args[0].toUpperCase());
                i.addUnsafeEnchantment(((CustomEnchant) ench).getBukkitEnchantment(), Integer.parseInt(args[1]));
                System.out.println(((CustomEnchant) ench).getBukkitEnchantment().getName());
                //addCustomLore(i, (CustomEnchant) ench, Integer.parseInt(args[1]));
                p.updateInventory();
                return true;
            }
            catch (NumberFormatException e)
            {
                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "(!) " + ChatColor.RESET + "Please enter a valid level!");
            }
        }
        return true;
    }

    private void addCustomLore(ItemStack item, CustomEnchant enchantment, int level)
    {
        if (!(enchantment instanceof CustomEnchant))
        {
            return;
        }
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore() == null ? new ArrayList<String>() : meta.getLore();
        String newEnchant = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, enchantment.getName());
        int chosenIndex = -1;
        for (int x = 0; x < lore.size(); x++)
        {
            String loreLine = lore.get(x);
            if (loreLine.startsWith(ChatColor.GRAY + newEnchant))
            {
                chosenIndex = x;
            }
        }
        if (chosenIndex == -1)
        {
            lore.add(0, ChatColor.GRAY + newEnchant + " " + enchantment.getNumeralLevel(level));
        }
        else
        {
            lore.set(chosenIndex, ChatColor.GRAY + newEnchant + " " + enchantment.getNumeralLevel(level));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

}
