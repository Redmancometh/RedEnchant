package com.redmancometh.redenchants.abstraction.composites;

import net.minecraft.server.v1_8_R3.EnchantmentSlotType;

public abstract class HeldWeaponEnchant extends HeldEnchant
{

    public HeldWeaponEnchant(int id, String name, EnchantmentSlotType slotType, int maxLevel)
    {
        super(id, name, slotType, maxLevel);
    }

    @Override
    public EnchantmentSlotType getItemTarget()
    {
        return EnchantmentSlotType.WEAPON;
    }
}
