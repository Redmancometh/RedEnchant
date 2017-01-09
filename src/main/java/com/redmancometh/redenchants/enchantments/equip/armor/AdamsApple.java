package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import com.redmancometh.redenchants.abstraction.composites.EquippedArmorEnchant;

public class AdamsApple extends EquippedArmorEnchant
{

    public AdamsApple()
    {
        super(77, "ADAMSAPPLE", 2);
    }

    @Override
    public String getMetaName()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Enchantment getEnchant()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void tickItem(Player p, int level)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEffectApplied(Player p)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeEquipEffect(Player p)
    {
        // TODO Auto-generated method stub

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
        return 5;
    }

}
