package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.entity.Player;

import com.redmancometh.redenchants.abstraction.composites.CustomArmorEnchant;

import net.md_5.bungee.api.ChatColor;

public class Combatant extends CustomArmorEnchant
{

    public Combatant()
    {
        super(78, "COMBATANT", 2);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onStruck(Player attacked, Player attacker, int level)
    {
        if (Math.random() > .1 * level)
        {
            attacked.setHealth(Math.min(attacked.getHealth() + 1 * level, 20));
            attacked.sendMessage(ChatColor.GOLD + "[DEBUG]: Combatant heal!");
        }
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 1;
    }

}
