package com.redmancometh.redenchants.abstraction.composites;

import java.util.Arrays;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.EnchantmentSlotType;

public abstract class HeldEnchant extends CustomEquipEnchant
{
    public HeldEnchant(int id, String name, EnchantmentSlotType slotType, int maxLevel)
    {
        super(id, name, slotType, maxLevel);
    }

    @Override
    public List<ItemStack> getEquippedInSlot(Player p)
    {
        return Arrays.asList(new ItemStack[]
        { p.getItemInHand() });
    }

    @Override
    public EnchantmentSlotType getItemTarget()
    {
        return EnchantmentSlotType.ALL;
    }
}
