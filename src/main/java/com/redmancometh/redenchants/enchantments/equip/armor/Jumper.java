package com.redmancometh.redenchants.enchantments.equip.armor;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.redmancometh.redenchants.abstraction.composites.EquippedArmorEnchant;

import net.minecraft.server.v1_8_R3.Enchantment;

public class Jumper extends EquippedArmorEnchant
{
    public Jumper()
    {
        super(76, "JUMPER");
    }

    @Override
    public String getMetaName()
    {
        return "jumper";
    }

    @Override
    public void tickItem(Player p, int level)
    {
        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, level));
    }

    @Override
    public boolean isEffectApplied(Player p)
    {
        return p.hasPotionEffect(PotionEffectType.JUMP) && p.hasMetadata(getMetaName());
    }

    @Override
    public void removeEquipEffect(Player p)
    {
        p.removePotionEffect(PotionEffectType.JUMP);
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
        return 3;
    }

    @Override
    public org.bukkit.enchantments.Enchantment getEnchant()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
