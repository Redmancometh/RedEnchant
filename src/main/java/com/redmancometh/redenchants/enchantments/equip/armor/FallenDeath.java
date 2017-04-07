package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.entity.Player;

import com.redmancometh.redenchants.abstraction.composites.CustomArmorEnchant;

public class FallenDeath extends CustomArmorEnchant
{

    public FallenDeath()
    {
        super(80, "FALLENDEATH", 2);
    }

    @Override
    public boolean onStruck(Player attacked, Player attacker, int level)
    {
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

}
