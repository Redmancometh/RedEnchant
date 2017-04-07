package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.redmancometh.redenchants.abstraction.composites.EquippedArmorEnchant;

public class FireDeflect extends EquippedArmorEnchant
{
    public FireDeflect()
    {
        super(81, "FIREDEFLECT", 2);
    }

    @Override
    public String getMetaName()
    {
        return "firedeflect";
    }

    @Override
    public void tickItem(Player p, int level)
    {
        p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, level));
    }

    @Override
    public boolean isEffectApplied(Player p)
    {
        return p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE) && p.hasMetadata(getMetaName());
    }

    @Override
    public void removeEquipEffect(Player p)
    {
        p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    }

    @Override
    public boolean onStruck(Player attacked, Player attacker, int level)
    {
        if (Math.random() > .1 * level)
        {
            attacker.damage(2);
            attacker.setFireTicks(60);
        }
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 3;
    }

    @Override
    public org.bukkit.enchantments.Enchantment getEnchant()
    {
        return bukkitEnch;
    }

}
