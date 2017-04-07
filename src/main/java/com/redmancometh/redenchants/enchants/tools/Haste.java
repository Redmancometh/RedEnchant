package com.redmancometh.redenchants.enchants.tools;

import org.bukkit.event.block.BlockBreakEvent;

import com.redmancometh.redenchants.abstraction.composites.CustomToolEnchant;

public class Haste extends CustomToolEnchant
{

    public Haste()
    {
        super(98, "HASTE", 5);
    }

    @Override
    public String a()
    {
        return super.a();
    }

    @Override
    public String d(int i)
    {
        return super.d(i);
    }

    @Override
    public String getName()
    {
        return super.getName();
    }

    @Override
    public void handleBlockBreak(BlockBreakEvent e, int level)
    {
        
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
