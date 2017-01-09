package com.redmancometh.redenchants.enchants.ranged;

import com.redmancometh.redenchants.abstraction.composites.RangedWeaponEnchant;

public class Shotgun extends RangedWeaponEnchant
{

    public Shotgun()
    {
        super(94, "SHOTGUN", 2);
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
