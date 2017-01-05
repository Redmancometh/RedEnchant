package com.redmancometh.redenchants.enchants.ranged;

import com.redmancometh.redenchants.abstraction.composites.RangedWeaponEnchant;

public class Shotgun extends RangedWeaponEnchant
{

    public Shotgun()
    {
        super(88, "SHOTGUN");
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
