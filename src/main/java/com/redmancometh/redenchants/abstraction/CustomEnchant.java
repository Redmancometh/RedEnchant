package com.redmancometh.redenchants.abstraction;

import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.Enchantment;
import net.minecraft.server.v1_8_R3.EnchantmentSlotType;
import net.minecraft.server.v1_8_R3.MinecraftKey;

public abstract class CustomEnchant extends Enchantment
{
    protected String name;
    protected CustomBukkitEnchantment bukkitEnch;

    public CustomEnchant(int id, String name, EnchantmentSlotType slotType, int maxLevel)
    {
        super(id, new MinecraftKey(name.replace(" ", "_")), id, slotType);
        this.bukkitEnch = new CustomBukkitEnchantment(this, name);
        this.name = name;
        super.c(name);
    }

    @Override
    public String a()
    {
        System.out.println("A STRING!");
        return super.a();
    }

    public int a(int i)
    {
        System.out.println("A");
        return 100 * i;
    }

    public int b(int i)
    {
        System.out.println("B");
        return this.a(i) + 300;
    }

    @Override
    public String d(int i)
    {
        System.out.println("D!");
        return super.d(i);
    }

    public org.bukkit.enchantments.Enchantment getBukkitEnchantment()
    {
        System.out.println("GET BUKKIT ENCH!");
        return this.bukkitEnch;
    }

    public String getName()
    {
        System.out.println(name + " CALLED NAME");
        return name;
    }

    public String getNumeralLevel(int level)
    {
        switch (level)
        {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";

        }
        return level + "";
    }

    public abstract EnchantmentSlotType getItemTarget();

    public abstract int getMaxLevel();

    @Override
    public int getStartLevel()
    {
        return 1;
    }

    public boolean hasEnchant(ItemStack itemStack)
    {
        return itemStack != null && itemStack.getEnchantments() != null && itemStack.getEnchantments().containsKey(this);
    }

}
