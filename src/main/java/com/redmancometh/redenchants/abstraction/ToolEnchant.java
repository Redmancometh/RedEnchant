package com.redmancometh.redenchants.abstraction;

import org.bukkit.event.block.BlockBreakEvent;

public interface ToolEnchant
{
    public abstract void handleBlockBreak(BlockBreakEvent e, int level);
}
