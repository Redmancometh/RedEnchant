package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.entity.Player;

import com.redmancometh.redenchants.abstraction.composites.CustomArmorEnchant;

public class EggyMorning extends CustomArmorEnchant
{

    public EggyMorning()
    {
        super(77, "EGGYMORNING");
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
