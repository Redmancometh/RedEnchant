package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.redmancometh.redenchants.abstraction.composites.CustomArmorEnchant;

import net.md_5.bungee.api.ChatColor;

public class Serenity extends CustomArmorEnchant
{

    public Serenity()
    {
        super(85, "SERENITY", 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onStruck(Player attacked, Player attacker, int level)
    {
        attacked.getNearbyEntities(20, 20, 20).forEach((ent) ->
        {
            if (ent instanceof LivingEntity)
            {
                for (int x = 0; x < 3; x++)
                    ((LivingEntity) ent).setHealth(Math.min(((LivingEntity) ent).getHealth() + 1, 20));
                ent.sendMessage(ChatColor.GOLD + "[Debug] Healed by Serenity Buff!");
            }
        });
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
