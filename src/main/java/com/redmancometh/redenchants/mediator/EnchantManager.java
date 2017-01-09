package com.redmancometh.redenchants.mediator;

import org.bukkit.inventory.ItemStack;

import com.redmancometh.redenchants.abstraction.CustomBukkitEnchantment;
import com.redmancometh.redenchants.abstraction.CustomEnchant;
import com.redmancometh.redenchants.abstraction.EquipEnchant;
import com.redmancometh.redenchants.enchantments.equip.armor.Jumper;
import com.redmancometh.redenchants.enchantments.equip.armor.Runner;
import com.redmancometh.redenchants.enchantments.equip.armor.WaterPurge;
import com.redmancometh.redenchants.enchants.melee.Daze;
import com.redmancometh.redenchants.enchants.melee.Poisonous;
import com.redmancometh.redenchants.enchants.tools.Haste;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;
import net.minecraft.server.v1_8_R3.Enchantment;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class EnchantManager implements Iterable<CustomBukkitEnchantment> //Iterable for the forEach/lambda syntax sugar
{
    private Map<String, CustomEnchant> enchantMap = new ConcurrentHashMap();
    private Map<String, CustomBukkitEnchantment> vanillaMap = new ConcurrentHashMap();

    private Set<EquipEnchant> equipEnchants = new HashSet();
    private Field idField;
    private Field bField;
    CtClass bukkitEnchantField;
    CtClass enchantClass;

    public EnchantManager()
    {
        try
        {
            idField = Enchantment.class.getDeclaredField("byId");
            bField = Enchantment.class.getDeclaredField("b");
            enchantClass = ClassPool.getDefault().get("net.minecraft.server.v1_8_R3.Enchantment");
            bukkitEnchantField = ClassPool.getDefault().get("org.bukkit.enchantments.Enchantment");
        }
        catch (NoSuchFieldException | SecurityException | NotFoundException e)
        {
            // TODO Auto-generated catch block
        }
        loadEnchantments();

    }

    public Collection<CustomEnchant> getNMSCustomEnchants()
    {
        return enchantMap.values();
    }

    public Collection<CustomBukkitEnchantment> getBukkitCustomEnchants()
    {
        return vanillaMap.values();
    }

    public boolean isUpgrade()
    {
        return false;

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

    public void unLoadEnchantments()
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
                    ((Map<Integer, Enchantment>) nameMap.get(null)).remove(ench.id);
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
    }

    public void insertBukkitMapEnchants()
    {
        // Reloadability
        try
        {
            Field idMapField = org.bukkit.enchantments.Enchantment.class.getDeclaredField("byId");
            Field nameMapField = org.bukkit.enchantments.Enchantment.class.getDeclaredField("byName");
            idMapField.setAccessible(true);
            nameMapField.setAccessible(true);
            Map<Integer, org.bukkit.enchantments.Enchantment> idMap = (Map<Integer, org.bukkit.enchantments.Enchantment>) idMapField.get(null);
            Map<String, org.bukkit.enchantments.Enchantment> nameMap = (Map<String, org.bukkit.enchantments.Enchantment>) nameMapField.get(null);
            enchantMap.forEach((name, ench) ->
            {
                try
                {
                    nameMap.put(name, ench.getBukkitEnchantment());
                    idMap.put(ench.id, ench.getBukkitEnchantment());
                }
                catch (IllegalArgumentException e)
                {
                    e.printStackTrace();
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void loadEnchantments()
    {
        // Allow New Enchantments
        try
        {
            Field f = org.bukkit.enchantments.Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            enchantMap.put("JUMPER", new Jumper());
            enchantMap.put("DAZE", new Daze());
            enchantMap.put("RUNNER", new Runner());
            enchantMap.put("HASTE", new Haste());
            enchantMap.put("POISONOUS", new Poisonous());
            enchantMap.put("WATERPURGE", new WaterPurge());
            setEquipEnchants();
            enchantMap.forEach((name, enchant) -> vanillaMap.put(name, (CustomBukkitEnchantment) enchant.getBukkitEnchantment()));
            addToArrays(enchantMap.values());
            insertBukkitMapEnchants();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addToArrays(Collection<CustomEnchant> enchList)
    {
        try
        {
            removeFinal(idField);
            removeFinal(bField);
            Enchantment[] enchField = (Enchantment[]) idField.get(null);
            List<Enchantment> enchantsB = new ArrayList(Arrays.asList(Enchantment.b));
            for (CustomEnchant enchant : enchList)
            {
                enchField[enchant.id] = enchant;
                enchantsB.add(enchant);
                enchantClass.addField(new CtField(enchantClass, enchant.getName(), enchantClass));
                CtField newField = new CtField(bukkitEnchantField, enchant.a(), bukkitEnchantField);
                bukkitEnchantField.addField(newField);
            }
            bField.set(null, enchantsB.toArray(new Enchantment[enchantsB.size()]));
            idField.set(null, enchField);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    static void removeFinal(Field field) throws Exception
    {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
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
    public Iterator<CustomBukkitEnchantment> iterator()
    {
        return vanillaMap.values().iterator();
    }
}
