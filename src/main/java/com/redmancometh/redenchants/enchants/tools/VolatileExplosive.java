package com.redmancometh.redenchants.enchants.tools;

import org.bukkit.event.block.BlockBreakEvent;

import com.redmancometh.redenchants.abstraction.composites.CustomToolEnchant;

public class VolatileExplosive extends CustomToolEnchant
{

    public VolatileExplosive(int id, String name)
    {
        super(99, name, 3);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void handleBlockBreak(BlockBreakEvent e, int level)
    {
        int radius = level + 1;
        for (int x = 0; x <= radius; radius++)
        {

        }
    }

    @Override
    public int getMaxLevel()
    {
        return 3;
    }
}
