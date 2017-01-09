package com.redmancometh.redenchants.abstraction.composites;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;

import com.redmancometh.redenchants.abstraction.CustomEnchant;

import net.minecraft.server.v1_8_R3.EnchantmentSlotType;

public abstract class CustomArmorEnchant extends CustomEnchant
{
    private HashSet slots = new HashSet(Arrays.asList(36, 37, 38, 39));

    public CustomArmorEnchant(int id, String name, int maxLevel)
    {
        super(id, name, EnchantmentSlotType.ARMOR, id);
    }

    public Set<Integer> getSlots()
    {
        //don't force implementation
        //use getEquippedInSlot which calls this by default
        //leave this as default and override getEquippedInSlot 
        //this is an armor enchant as default
        return slots;
    }

    @Override
    public EnchantmentSlotType getItemTarget()
    {
        return EnchantmentSlotType.ARMOR;
    }

    public void onStruckBy(Projectile proj, Player struck, int level)
    {

    }

    public abstract boolean onStruck(Player attacked, Player attacker, int level);
}
