package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.redmancometh.redenchants.abstraction.composites.EquippedArmorEnchant;

public class Runner extends EquippedArmorEnchant
{

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

    public Runner()
    {
        super(84, "RUNNER", 6);
    }

    @Override
    public String getMetaName()
    {
        return "runner";
    }

    @Override
    public void tickItem(Player p, int level)
    {
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, level));
    }

    @Override
    public boolean isEffectApplied(Player p)
    {
        return p.hasPotionEffect(PotionEffectType.SPEED) && p.hasMetadata(getMetaName());
    }

    @Override
    public void removeEquipEffect(Player p)
    {
        p.removePotionEffect(PotionEffectType.SPEED);
    }

    @Override
    public boolean onStruck(Player attacked, Player attacker, int level)
    {
        return false;
    }

    @Override
    public Enchantment getEnchant()
    {
        return bukkitEnch;
    }

}
