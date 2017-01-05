package com.redmancometh.redenchants.enchants.tools;

import org.bukkit.event.block.BlockBreakEvent;

import com.redmancometh.redenchants.abstraction.composites.CustomToolEnchant;

public class Haste extends CustomToolEnchant
{

    public Haste()
    {
        super(71, "HASTE");
    }

    @Override
    public void handleBlockBreak(BlockBreakEvent e, int level)
    {
        System.out.println("HASTE!");
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
