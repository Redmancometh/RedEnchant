package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.entity.Player;

import com.redmancometh.redenchants.abstraction.composites.CustomArmorEnchant;

public class EggyMorning extends CustomArmorEnchant
{

    public EggyMorning()
    {
        super(79, "EGGYMORNING", 2);
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
