package com.redmancometh.redenchants.enchants.tools;

import org.bukkit.event.block.BlockBreakEvent;

import com.redmancometh.redenchants.abstraction.composites.CustomToolEnchant;

public class DemonBreaker extends CustomToolEnchant
{

    public DemonBreaker(int id, String name)
    {
        super(97, "DEMONBREAKER", 3);
    }

    @Override
    public void handleBlockBreak(BlockBreakEvent e, int level)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }
}
