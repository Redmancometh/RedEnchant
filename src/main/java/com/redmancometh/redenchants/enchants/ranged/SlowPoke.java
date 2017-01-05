package com.redmancometh.redenchants.enchants.ranged;

import com.redmancometh.redenchants.abstraction.composites.RangedWeaponEnchant;

public class SlowPoke extends RangedWeaponEnchant
{

    public SlowPoke()
    {
        super(89, "SLOWPOKE");
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
