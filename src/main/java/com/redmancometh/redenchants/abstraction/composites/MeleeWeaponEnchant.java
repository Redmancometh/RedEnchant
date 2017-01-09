package com.redmancometh.redenchants.abstraction.composites;

import com.redmancometh.redenchants.abstraction.CombatEnchant;
import com.redmancometh.redenchants.abstraction.CustomEnchant;

import net.minecraft.server.v1_8_R3.EnchantmentSlotType;

public abstract class MeleeWeaponEnchant extends CustomEnchant implements CombatEnchant
{

    public MeleeWeaponEnchant(int id, String name, int maxLevel)
    {
        super(id, name, EnchantmentSlotType.WEAPON, maxLevel);
    }

    @Override
    public EnchantmentSlotType getItemTarget()
    {
        return EnchantmentSlotType.WEAPON;
    }

}
