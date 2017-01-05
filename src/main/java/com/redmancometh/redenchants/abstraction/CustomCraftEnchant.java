package com.redmancometh.redenchants.abstraction;

import org.bukkit.craftbukkit.v1_8_R3.enchantments.CraftEnchantment;

import net.minecraft.server.v1_8_R3.Enchantment;

public class CustomCraftEnchant extends CraftEnchantment
{
    public CustomCraftEnchant(Enchantment target)
    {
        super(target);
    }
}
