package com.redmancometh.redenchants.abstraction.composites;

import org.bukkit.enchantments.EnchantmentTarget;

import com.redmancometh.redenchants.abstraction.CombatEnchant;
import com.redmancometh.redenchants.abstraction.CustomEnchant;

public abstract class MeleeWeaponEnchant extends CustomEnchant implements CombatEnchant
{

    public MeleeWeaponEnchant(int id, String name)
    {
        super(id, name);
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return EnchantmentTarget.WEAPON;
    }

}
