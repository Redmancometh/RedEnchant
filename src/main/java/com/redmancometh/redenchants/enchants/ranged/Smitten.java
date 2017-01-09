package com.redmancometh.redenchants.enchants.ranged;

import com.redmancometh.redenchants.abstraction.composites.RangedWeaponEnchant;

public class Smitten extends RangedWeaponEnchant
{
    public Smitten()
    {
        super(96, "SMITTEN", 2);
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
