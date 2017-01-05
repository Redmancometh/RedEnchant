package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.entity.Player;

import com.redmancometh.redenchants.abstraction.composites.CustomArmorEnchant;

public class Serenity extends CustomArmorEnchant
{

    public Serenity()
    {
        super(83, "SERENITY");
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onStruck(Player attacked, Player attacker, int level)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
