package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.redmancometh.redenchants.abstraction.composites.EquippedArmorEnchant;

public class WaterPurge extends EquippedArmorEnchant
{
    public WaterPurge()
    {
        super(77, "WATERPURGE");
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

    @Override
    public String getMetaName()
    {
        return "runner";
    }

    @Override
    public void tickItem(Player p, int level)
    {
        p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 1200, level));
    }

    @Override
    public boolean isEffectApplied(Player p)
    {
        return p.hasPotionEffect(PotionEffectType.WATER_BREATHING) && p.hasMetadata(getMetaName());
    }

    @Override
    public void removeEquipEffect(Player p)
    {
        p.removePotionEffect(PotionEffectType.WATER_BREATHING);
    }

    @Override
    public boolean onStruck(Player attacked, Player attacker, int level)
    {
        return false;
    }

}
