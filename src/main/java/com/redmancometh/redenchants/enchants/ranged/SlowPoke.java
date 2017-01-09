package com.redmancometh.redenchants.enchants.ranged;

import com.redmancometh.redenchants.abstraction.composites.RangedWeaponEnchant;

public class SlowPoke extends RangedWeaponEnchant
{

    public SlowPoke()
    {
        super(95, "SLOWPOKE", 2);
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
