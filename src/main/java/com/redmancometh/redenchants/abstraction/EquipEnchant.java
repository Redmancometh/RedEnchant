package com.redmancometh.redenchants.abstraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import com.redmancometh.redenchants.RedEnchants;

import javafx.util.Pair;

public interface EquipEnchant
{
    public abstract String getMetaName();

    Set slots = new HashSet(Arrays.asList(1, 36, 37, 38, 39));

    public abstract Set<Integer> getSlots();

    public abstract Enchantment getEnchant();

    public default List<ItemStack> getEquippedInSlot(Player p)
    {
        List<ItemStack> itemList = new ArrayList();
        getSlots().forEach((slot) -> itemList.add(p.getInventory().getItem((slot))));
        return itemList;
    }

    public default Pair<Boolean, ItemStack> isEquipped(Player p)
    {
        for (ItemStack item : getEquippedInSlot(p))
        {
            if (item != null)
            {
                if (item.containsEnchantment(getEnchant()))
                {
                    return new Pair(true, item);
                }
            }
        }
        return new Pair(false, null);
    }

    public abstract void tickItem(Player p, int level);

    public default void applyItemEnchants(Player player, ItemStack item)
    {
        for (CustomEnchant customEnchant : RedEnchants.getInstance().getManager().getNMSCustomEnchants())
        {
            if (!(customEnchant instanceof EquipEnchant))
            {
                continue;
            }
            EquipEnchant equipEnchant = (EquipEnchant) customEnchant;
            Pair<Boolean, ItemStack> equipResult = equipEnchant.isEquipped(player);
            if (equipResult.getKey())
            {
                if (equipEnchant.isEffectApplied(player))
                {
                    equipEnchant.tickItem(player, equipResult.getValue().getEnchantmentLevel(getEnchant()));
                    continue;
                }
                equipEnchant.onTickApply(player, item.getEnchantmentLevel(getEnchant()));
                continue;
            }
            if (equipEnchant.isTickApplied(player))
            {
                equipEnchant.removeEffects(player);
            }
        }
    }

    public default void onTickApply(Player p, int level)
    {
        setEquipMeta(p);
        tickItem(p, level);
    }

    public abstract boolean isEffectApplied(Player p);

    public default boolean isTickApplied(Player p)
    {
        return p.hasMetadata(getMetaName());
    }

    public default void removeEffects(Player p)
    {
        p.removeMetadata(getMetaName(), RedEnchants.getInstance());
        removeEquipEffect(p);
    }

    public abstract void removeEquipEffect(Player p);

    public default void setEquipMeta(Player p)
    {
        p.setMetadata(getMetaName(), new FixedMetadataValue(RedEnchants.getInstance(), getMetaName()));
    }
}
