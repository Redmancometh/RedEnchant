package com.redmancometh.redenchants.mediator;

import org.bukkit.inventory.ItemStack;
import com.redmancometh.redenchants.abstraction.CustomEnchant;
import com.redmancometh.redenchants.abstraction.EquipEnchant;
import com.redmancometh.redenchants.enchantments.equip.armor.Jumper;
import com.redmancometh.redenchants.enchantments.equip.armor.Runner;
import com.redmancometh.redenchants.enchantments.equip.armor.WaterPurge;
import com.redmancometh.redenchants.enchants.melee.Daze;
import com.redmancometh.redenchants.enchants.melee.Poisonous;
import com.redmancometh.redenchants.enchants.tools.Haste;

import net.minecraft.server.v1_8_R3.Enchantment;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class EnchantManager implements Iterable<CustomEnchant> //Iterable for the forEach/lambda syntax sugar
{
    private Map<String, CustomEnchant> enchantMap = new ConcurrentHashMap();

    private Set<EquipEnchant> equipEnchants = new HashSet();

    public EnchantManager()
    {
        loadEnchantments();
    }

    public Collection<CustomEnchant> getEnchants()
    {
        return enchantMap.values();
    }

    public void setEquipEnchants()
    {
        forEachEquippable((ench) -> equipEnchants.add((EquipEnchant) ench));
    }

    public Enchantment getByName(String name)
    {
        return enchantMap.get(name);
    }

    public boolean enchantExists(String name)
    {
        return enchantMap.containsKey(name);
    }

    /* public void unLoadEnchantments()
    {
        // Reloadability
        try
        {
            Field idMap = Enchantment.class.getDeclaredField("byId");
            Field nameMap = Enchantment.class.getDeclaredField("byName");
            idMap.setAccessible(true);
            nameMap.setAccessible(true);
            enchantMap.forEach((name, ench) ->
            {
                try
                {
                    ((Map<String, Enchantment>) nameMap.get(null)).remove(ench.getName());
                    ((Map<Integer, Enchantment>) nameMap.get(null)).remove(ench.getId());
                }
                catch (IllegalArgumentException | IllegalAccessException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }*/

    public void loadEnchantments()
    {
        // Allow New Enchantments
        try
        {
            try
            {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                enchantMap.put("JUMPER", new Jumper());
                enchantMap.put("DAZE", new Daze());
                enchantMap.put("RUNNER", new Runner());
                enchantMap.put("HASTE", new Haste());
                enchantMap.put("POISONOUS", new Poisonous());
                enchantMap.put("WATERPURGE", new WaterPurge());
                enchantMap.put("JUMPER", new Jumper());
                //enchantMap.values().forEach((ench) -> Enchantment.registerEnchantment(ench));
                setEquipEnchants();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int getEnchantmentLevel(Enchantment enchantment, ItemStack itemStack)
    {
        return itemStack.getEnchantments().containsKey(enchantment) ? itemStack.getEnchantments().get(enchantment) : 0;
    }

    public void forEachEquippable(Consumer<? super EquipEnchant> action)
    {
        Iterable.super.forEach((ench) ->
        {
            if (ench instanceof EquipEnchant)
            {
                action.accept((EquipEnchant) ench);
            }
        });
    }

    @Override
    public Iterator<CustomEnchant> iterator()
    {
        return enchantMap.values().iterator();
    }
}
